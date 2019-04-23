import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import static org.junit.Assert.*;

public class BitvecNodeTest {

    @Test
    public void bitvecNodeFirst() throws Exception {
        Btor.btor();
        BitvecSort sort = BitvecSort.bitvecSort(8);
        BitvecNode x =  BitvecNode.var(sort, "nullINc");
        BitvecNode y = BitvecNode.var(sort, "nullINc");
        BitvecNode ansXor = x.xor(y);
        BitvecNode ansOr = andNot(x,y).or(andNot(y,x));
        BoolNode eq = ansXor.eq(ansOr); //fdskfdjsfkjdsklfjdskfjkldsjfkl
        BoolNode formula =eq.not();
        formula.assertForm();
        int result = BoolectorSat.getBoolectorSat();

        assertEquals(BoolectorSat.UNSAT,result);
        Btor.btorRelease();
    }

    private BitvecNode andNot(BitvecNode x, BitvecNode y) {
        return x.and(y.not());
    }


    @Test
    public void bitvecNodeSecond() {
        Btor.btor();
        BitvecSort sort = BitvecSort.bitvecSort(8);
        BitvecNode x = BitvecNode.var(sort,"nullINc");
        BitvecNode y = BitvecNode.var(sort,"nullINc");
        BitvecNode zero = BitvecNode.zero(sort);
        BoolNode xSgtZero = x.sgt(zero);
        BoolNode ySgtZero = y.sgt(zero);
        BoolNode varsSgtZero = xSgtZero.and(ySgtZero);

        BitvecNode add = x.add(y);   // saddo???
        BoolNode addSgtZero = add.sgt(zero);
        BoolNode overflow = add.sgt(x);
        BoolNode varsSgt = varsSgtZero.and(overflow);
        BoolNode ans =varsSgt.implies(addSgtZero);
        BoolSort a = BoolSort.boolSort();
        System.out.println(a.isBoolSort());
        BitvecNodeTest.assertFormuls(ans);


    }

    @Test
    public void all() {
    }

    private static void assertFormuls(BoolNode node) {
        BoolNode formula = node.not();
        formula.assertForm();
        assertEquals(BoolectorSat.UNSAT, BoolectorSat.getBoolectorSat());
        Btor.btorRelease();
    }
}