public class ArraySort extends BoolectorSort {

    ArraySort(long ref) {
        super(ref);
    }

    static ArraySort arraySort(BoolectorSort index, BoolectorSort element) {
        return new ArraySort(Native.arraySort(index.ref, element.ref));
    }
}
