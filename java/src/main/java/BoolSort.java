public class BoolSort extends BoolectorSort {
    BoolSort(long ref) {
        super(ref);
    }

    static BoolSort boolSort() {
        return new BoolSort(Native.bitvecSort(1));
    }

    // isBoolSort???
}
