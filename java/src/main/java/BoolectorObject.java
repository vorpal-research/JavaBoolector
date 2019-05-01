import java.util.*;

abstract class BoolectorObject {

    final long ref;

    BoolectorObject(long ref) {
        this.ref = ref;
    }

    abstract void release();

    static long[] toLong(BoolectorObject[] boolectorObj) {
        int size = boolectorObj.length;
        long[] toLong = new long[size];
        for (int i = 0; i < size; i++) {
            toLong[i] = boolectorObj[i].ref;
        }
        return toLong;
    }
}
