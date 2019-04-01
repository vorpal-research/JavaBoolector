
public class JavaBoolector {
    static {
        System.loadLibrary("JavaBoolector");
    }

    private static final int width = 8;

    public static void main(String[] args) throws Exception {
        JBtor btor = new JBtor();
        int result;
        JBoolectorNode x = new JBoolectorNode();
        JBoolectorNode y = new JBoolectorNode();
        JBoolectorNode oldX, oldY, temp, eq1, eq2, and, formula;
        JBoolectorSort s = new JBoolectorSort();
        s = s.jboolectorBitvecSort(width);
        x = x.jboolectorVar(s, null);
        y = y.jboolectorVar(s, null);

        oldX = x.jboolectorCopy();
        oldY = y.jboolectorCopy();
//равно
        temp = x.jboolectorXor(y);
        x.jboolectorRelease();
        x.clone(temp);

        temp = x.jboolectorXor(y);
        y.jboolectorRelease();
        y.clone(temp);

        temp = x.jboolectorXor(y);
        x.jboolectorRelease();
        x.clone(temp);

        eq1 = oldX.jboolectorEq(y);
        eq2 = oldY.jboolectorEq(x);
        and = eq1.jboolectorAnd(eq2);

        formula = and.jboolectorNot();
        formula.jboolectorAssert();
        JBoolectorSat jsat = new JBoolectorSat();
        result = jsat.jboolectorSat();
        System.out.println("Expect: unsat\n");
        System.out.printf ("Boolector: %s\n",
                result == JBoolectorSat.JSAT
                        ? "sat"
                        : (result == JBoolectorSat.JUNSAT ? "unsat" : "unknown"));
        if (result == JBoolectorSat.JUNKNOWN) throw new Exception("BOOLECTOR UNKNOWN");

        x.jboolectorRelease();
        y.jboolectorRelease();
        oldX.jboolectorRelease();
        oldY.jboolectorRelease();
        eq1.jboolectorRelease();
        eq2.jboolectorRelease();
        and.jboolectorRelease();
        formula.jboolectorRelease();
        s.jboolectorReleaseSort();
        btor.jbtorRelease();
    }
}
