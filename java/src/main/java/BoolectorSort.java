class BoolectorSort extends BoolectorObject {

    BoolectorSort(long ref) {
        super(ref);
    }

    boolean isBitvecSort() {
        return Native.isBitvecSort(ref);
    }

    boolean isBoolSort() {
        return Native.isBoolSort(ref);
    }

    boolean isArraySort() {
        return Native.isArraySort(ref);
    }

    BitvecSort toBitvecSort() {
        if (isArraySort()) throw new ClassCastException();
        else return new BitvecSort(ref);
    }

    BoolSort toBooleSort() {
        if (isBoolSort()) return new BoolSort(ref);
        else throw new ClassCastException();
    }

    ArraySort toArraySort() {
        if (isArraySort()) return new ArraySort(ref);
        else throw new ClassCastException();
    }

    void release() {
        Native.releaseSort(ref);
    }
}
