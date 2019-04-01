
public class JBoolectorNode {
    private long nodeRef = -1L;

    public JBoolectorNode jboolectorVar(JBoolectorSort sort, String symbol) {
        JBoolectorNode var = new JBoolectorNode();
        if (symbol == null) {
            symbol = "nullINc";
        }
        var.nodeRef = jboolectorVarC(sort.sortRef, symbol);
        return var;
    }

    private native long jboolectorVarC(long sortRef, String symbol);

    public JBoolectorNode jboolectorCopy() {
        JBoolectorNode copy = new JBoolectorNode();
        copy.nodeRef = jboolectorCopyC(nodeRef);
        return copy;
    }

    private native long jboolectorCopyC(long nodeRef);

    public JBoolectorNode jboolectorXor(JBoolectorNode secondNode) {
        JBoolectorNode xor = new JBoolectorNode();
        xor.nodeRef = jboolectorXorC(nodeRef, secondNode.nodeRef);
        return xor;
    }

    private native long jboolectorXorC(long firstNodeRef, long secondNodeRef);

    public JBoolectorNode jboolectorEq(JBoolectorNode secondNode) {
        JBoolectorNode equalsNode = new JBoolectorNode();
        equalsNode.nodeRef = jboolectorEqC(nodeRef, secondNode.nodeRef);
        return equalsNode;
    }

    private native long jboolectorEqC(long firstNodeRef, long secondNodeRef);

    public JBoolectorNode jboolectorAnd(JBoolectorNode secondNode) {
        JBoolectorNode and = new JBoolectorNode();
        and.nodeRef = jboolectorAndC(nodeRef, secondNode.nodeRef);
        return and;
    }

    private native long jboolectorAndC(long firstNodeRef, long secondNodeRef);

    public JBoolectorNode jboolectorNot() {
        JBoolectorNode not = new JBoolectorNode();
        not.nodeRef = jboolectorNotC(nodeRef);
        return not;
    }

    private native long jboolectorNotC(long nodeRef);

    public void jboolectorAssert() {
        jboolectorAssertC(nodeRef);
    }

    private native void jboolectorAssertC(long nodeRef);

    public void jboolectorRelease() {
        jboolectorReleaseC(nodeRef);
        nodeRef = -1L;
    }

    private native void jboolectorReleaseC(long nodeRef);

    public void clone(JBoolectorNode real) {
        nodeRef = real.nodeRef;
    }
}
