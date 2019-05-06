package io.github.boolector;


import java.util.*;

public abstract class BoolectorObject {

    public final long ref;

    BoolectorObject(long ref) {
        this.ref = ref;
    }

    abstract public void release();

    static long[] toLong(BoolectorObject[] boolectorObj) {
        int size = boolectorObj.length;
        long[] toLong = new long[size];
        for (int i = 0; i < size; i++) {
            toLong[i] = boolectorObj[i].ref;
        }
        return toLong;
    }
}
