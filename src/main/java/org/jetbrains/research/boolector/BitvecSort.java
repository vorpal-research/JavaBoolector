package org.jetbrains.research.boolector;

public class BitvecSort extends BoolectorSort {

    BitvecSort(Btor btor, long ref, int width) {
        super(btor, ref, width);
    }

    public static BitvecSort bitvecSort(Btor btor, int width) {
        return new BitvecSort(btor, Native.bitvecSort(btor.getRef(), width), width);
    }

    @Override
    public BitvecSort toBitvecSort() {
        return this;
    }

    @Override
    public BoolSort toBoolSort() {
        if (!this.isBoolSort()) throw new ClassCastException();
        return new BoolSort(this.btor, this.ref);
    }

    @Override
    public ArraySort toArraySort() {
        throw new ClassCastException();
    }
}
