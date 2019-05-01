import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionTest {

    @Test
   public void testAll() {
        Btor.btor();
        BitvecSort sort = BitvecSort.bitvecSort(8);
        BitvecNode x = BitvecNode.var(sort, "nullINc");
        BitvecNode y = BitvecNode.var(sort, "nullINc");
        BitvecNode oldX = x.copy().toBitvecNode();
        BitvecNode oldY = y.copy().toBitvecNode();
        BitvecNode a= BitvecNode.constInt(10,sort);
        BitvecNode b = BitvecNode.constInt(20, sort);
        BitvecNode ab = a.add(b);
        System.out.println(ab.getBits());
        BoolSort boolSort = BoolSort.boolSort();
        BitvecNode temp = x.add(y);
        BoolectorFun.FuncParam firstParam = BoolectorFun.FuncParam.param(sort,"nullINc");
        BoolectorFun.FuncParam secondParam = BoolectorFun.FuncParam.param(sort,"nullINc");
        Function slt = Function.func(temp,firstParam,secondParam);
        BitvecNode first = slt.apply(x,y).toBitvecNode();
        BitvecNode second = slt.apply(y,x).toBitvecNode();
        BoolNode eq = first.eq(second);
        //BoolNode ans =first.and(second);

        assertFormuls(eq);
    }

    public static void assertFormuls(BoolNode node) {
        BoolNode formula = node.not();
        formula.assertForm();
        int ans = BoolectorSat.getBoolectorSat();
        assertEquals(BoolectorSat.UNSAT, ans);

        Btor.btorRelease();
    }

}