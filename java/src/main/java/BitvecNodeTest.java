import org.junit.Test;

import static org.junit.Assert.*;

public class BitvecNodeTest {

    @Test
    public void bitvecNode() throws Exception {
        Btor.btor();
        BitvecSort sort = BitvecSort.bitvecSort(8);
        BitvecNode x =  BoolectorNode.var(sort, "nullINc").toBitvecNode();
        BitvecNode y = BoolectorNode.var(sort, "nullINc").toBitvecNode();
        BitvecNode ansXor = x.xor(y);
        BitvecNode ansOr = andNot(x,y).or(andNot(y,x));
        BitvecNode eq = ansXor.eq(ansOr).toBitvecNode();
        BoolectorNode formula =eq.not();
        formula.assertForm();
        int result = BoolectorSat.sat();

        assertEquals(BoolectorSat.UNSAT,result);
        if (result == BoolectorSat.UNKNOWN) throw new Exception("BOOLECTOR UNKNOWN");

        BitvecNode a = BoolectorNode.var(sort,"nullINc").toBitvecNode();
        BitvecNode b = BoolectorNode.var(sort,"nullINc").toBitvecNode();

        Btor.btorRelease();
    }

    private BitvecNode andNot(BitvecNode x, BitvecNode y) {
        return x.and(y.not());
    }
}