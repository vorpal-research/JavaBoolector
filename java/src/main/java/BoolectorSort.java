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

    void release() {
        Native.releaseSort(ref);
    }
}
