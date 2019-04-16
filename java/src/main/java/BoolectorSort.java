class BoolectorSort extends BoolectorObject{

    BoolectorSort(long ref) {
        super(ref);
    }

    boolean isBitvecSort() {
        return Native.isBitvecSort(ref);
    }

    void release() {
        Native.releaseSort(ref);
        getAllObj().remove(ref);
    }
}
