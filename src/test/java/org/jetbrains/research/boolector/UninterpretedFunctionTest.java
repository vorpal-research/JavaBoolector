package org.jetbrains.research.boolector;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class UninterpretedFunctionTest {

    @Test
    public void testUf() {
        Btor btor = new Btor();
        BitvecSort intSort = BitvecSort.bitvecSort(btor, 32);
        BoolectorSort[] array = { intSort };
        FunctionSort functionSort = FunctionSort.functionSort(array, intSort);

        BitvecNode a = BitvecNode.var(intSort, "a", true);
        BitvecNode b = BitvecNode.var(intSort, "b", true);
        UninterpretedFunction f = UninterpretedFunction.func("f", functionSort);

        BitvecNode const20 = BitvecNode.constInt(20, intSort);
        BitvecNode const10 = BitvecNode.constInt(10, intSort);
        BitvecNode const1 = BitvecNode.constInt(1, intSort);

        BoolectorNode res = f.apply(Collections.singletonList(const10));

        BoolNode result = a.ugt(const20);
        result = result.and(b.ugt(a));
        result = result.and(res.eq(const1));

        result.assertForm();
        Btor.Status r = btor.check();
        assertEquals(Btor.Status.SAT, r);
    }
}
