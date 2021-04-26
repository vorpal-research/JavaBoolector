package org.jetbrains.research.boolector;

public class FunctionSort extends BoolectorSort {

    FunctionSort(Btor btor, long ref, Integer width) {
        super(btor, ref, width);
    }

    @Override
    public BitvecSort toBitvecSort() {
        throw new ClassCastException();
    }

    @Override
    public BoolSort toBoolSort() {
        throw new ClassCastException();
    }

    @Override
    public ArraySort toArraySort() {
        throw new ClassCastException();
    }

    public static FunctionSort functionSort(BoolectorSort[] argSorts, BoolectorSort returnSort) {
        Btor btor = returnSort.getBtor();
        long[] argSortRefs = new long[argSorts.length];
        for (int i = 0; i < argSorts.length; ++i) {
            argSortRefs[i] = argSorts[i].getRef();
        }
        return new FunctionSort(btor,
                Native.funcSort(btor.getRef(), argSortRefs, argSortRefs.length, returnSort.getRef()),
                returnSort.getWidth());
    }
}
