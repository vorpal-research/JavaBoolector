public class BitvecSort extends BoolectorSort {

    BitvecSort(long ref) {
        super(ref);
    }

    static BitvecSort bitvecSort(int width) {
        return new BitvecSort(Native.bitvecSort(width));
    }

    int getWidth() {
        return Native.getWidth(ref);
    }

}
