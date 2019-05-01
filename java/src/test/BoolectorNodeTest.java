import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoolectorNodeTest {

    @Test
    public void bitvecNodeFirst() {
        Btor.btor();
        BitvecSort sort = BitvecSort.bitvecSort(8);
        BitvecNode x = BitvecNode.var(sort, "nullINc");
        BitvecNode y = BitvecNode.var(sort, "nullINc");
        BitvecNode ansXor = x.xor(y);
        BitvecNode ansOr = andNot(x, y).or(andNot(y, x));
        BoolNode eq = ansXor.eq(ansOr); //fdskfdjsfkjdsklfjdskfjkldsjfkl
        BoolNode formula = eq.not();
        formula.assertForm();
        int result = BoolectorSat.getBoolectorSat();
        assertEquals(BoolectorSat.UNSAT, result);
        Btor.btorRelease();
    }

    private BitvecNode andNot(BitvecNode x, BitvecNode y) {
        return x.and(y.not());
    }

    @Test
    public void bitvecNodeSecond() {
        Btor.btor();
        BitvecSort sort = BitvecSort.bitvecSort(8);
        BitvecNode x = BitvecNode.var(sort, "nullINc");
        BitvecNode y = BitvecNode.var(sort, "nullINc");
        BitvecNode zero = BitvecNode.zero(sort);
        BoolNode xSgtZero = x.sgt(zero);
        BoolNode ySgtZero = y.sgt(zero);
        BoolNode varsSgtZero = xSgtZero.and(ySgtZero);

        BitvecNode add = x.add(y);   // saddo???
        BoolNode addSgtZero = add.sgt(zero);
        BoolNode overflow = add.sgt(x);
        BoolNode varsSgt = varsSgtZero.and(overflow);
        BoolNode ans = varsSgt.implies(addSgtZero);
        BoolectorSat.simplify();
        assertFormuls(ans);
    }

    @Test
    public void BitveNodeTest() {
        Btor.btor();
        BitvecNode x, y, longConst, sext, uext, slice, neg, add, sub, mul, sdiv, udiv, smod, urem, sll, srl, sra, concat;
        BoolNode sgt, sgte, slt, slte;
        x = BitvecNode.constBitvec("000101");
        y = BitvecNode.constBitvec("000011");
        longConst = BitvecNode.constLong(3000000000L);


        sext = x.sext(4);
        uext = x.uext(4);
        slice = x.slice(2,0);
        neg = x.neg();
        add = x.add(y);
        sub = x.sub(y);
        mul = x.mul(y);
        sdiv = x.sdiv(y);
        udiv = x.udiv(y);
        smod = x.smod(y);
        urem = x.urem(y);
        sgt = x.sgt(y);
        sgte = x.sgte(y);
        slt = x.slt(y);
        slte = x.slte(y);
        sll = x.sll(y);
        srl = x.srl(y);
        sra = x.sra(y);
        concat = x.concat(y);
        BoolectorSat.getBoolectorSat();
        boolectorAssert("0000000000000000000000000000000010110010110100000101111000000000", longConst);
        boolectorAssert("0000000101", sext);
        boolectorAssert("0000000101",uext);
        boolectorAssert("101",slice);
        boolectorAssert("111011", neg); // разве доп + не само число?
        boolectorAssert("001000", add);
        boolectorAssert("000010", sub);
        boolectorAssert("001111", mul);
        boolectorAssert("000001", sdiv);
        boolectorAssert("000001", udiv);
        boolectorAssert("000010", smod);
        boolectorAssert("000010", urem);
        boolectorAssert("1", sgt);
        boolectorAssert("1", sgte);
        boolectorAssert("0", slt);
        boolectorAssert("0", slte);
        boolectorAssert("101000", sll);
        boolectorAssert("000000", srl);
        boolectorAssert("000000", sra);
        boolectorAssert("000101000011", concat);
        Btor.btorRelease();
    }

    @Test
    public void BoolNodeTest() {
        Btor.btor();
        BoolNode x, y, or, xor, iff;
        x = BoolNode.constBool(true);
        y = BoolNode.constBool(false);
        or = x.or(y);
        xor = x.xor(y);
        iff = x.iff(y);
        BoolectorSat.getBoolectorSat();
        boolectorAssert("1", or);
        boolectorAssert("1", xor);
        boolectorAssert("0", iff);
        Btor.btorRelease();
    }

    @Test
    public void BoolectorNode() {
        Btor.btor();
        BoolectorNode x, y, bool, bitvec, ite, getSymbol;

        x = BitvecNode.constBitvec("000101");
        y = BitvecNode.constBitvec("000011");

        bool = BitvecNode.constBitvec("1");
        ite = x.ite(bool.toBoolNode(), y);
        BoolectorSort getSort = x.getSort();
        bitvec = BitvecNode.var(getSort.toBitvecSort(), "test");
        x.getID();
        BoolectorSat.getBoolectorSat();
        boolectorAssert("000101", ite);
        assertEquals("test", bitvec.getSymbol());
        assertFalse(x.isBoolConst());
        assertFalse(bitvec.isBitvecConst());
        int i = 0;
        try {
            bitvec.toArrayNode();
        } catch (ClassCastException e) {
            ++i;
        }
        assertEquals(1, i);
        Btor.btorRelease();
    }

    @Test
    public void arrayNode() {
        Btor.btor();
        BitvecNode x, y, i, j;
        ArrayNode arrayConst, array;
        BitvecSort index, e;

        x = BitvecNode.constBitvec("000101");
        y = BitvecNode.constBitvec("000011");
        i = BitvecNode.constBitvec("0");
        j = BitvecNode.constBitvec("1");

        index = x.getSort().toBitvecSort();
        ArraySort sort = ArraySort.arraySort(index, index);
        array = ArrayNode.arrayNode(sort, "Temp");

        arrayConst = ArrayNode.constArrayNode("test", x, y);
        arrayConst = arrayConst.write(i, y);
        BoolNode eq = arrayConst.read(i).eq(arrayConst.read(j));
        BoolectorSat.getBoolectorSat();
        boolectorAssert("1", eq);
        Btor.btorRelease();
    }

    private static void assertFormuls(BoolNode node) {
        BoolNode formula = node.not();
        formula.assertForm();
        int ans = BoolectorSat.getBoolectorSat();
        assertEquals(BoolectorSat.UNSAT, ans);
        Btor.btorRelease();
    }

    private static void boolectorAssert(String ans, BoolectorNode node) {
        assertTrue(Native.boolectorAssert(ans, node.ref));
    }
}