final class Native {

    public static native void btor();

    public static native void btorRelease();

    public static native long var(long ref, String name);

    public static native void releaseNode(long ref);

    public static native long bitvecSort(int width);

    public static native void releaseSort(long ref);

    public static native boolean isBitvecSort(long ref);

    public static native boolean isArraySort(long ref);

    public static native int getWidth(long ref);

    public static native long not(long ref);

    public static native long add(long firstRef, long secondRef);

    public static native long and(long firstRef, long secondRef);

    public static native long or(long firstRef, long secondRef);

    public static native long xor(long firstRef, long secondRef);

    public static native long neg(long ref);

    public static native long eq(long firstRef, long secondRef);

    public static native long copy(long ref);

    public static native void assertForm(long ref);

    public static native int getSat();

    public static native long sub(long firstRef, long secondRef);

    public static native long mul(long firstRef, long secondRef);

    public static native long sdiv(long firstRef, long secondRef);

    public static native long udiv(long firstRef, long secondRef);

    public static native long smod(long firstRef, long secondRef);

    public static native long urem(long firstRef, long secondRef);

    public static native long sgt(long firstRef, long secondRef);

    public static native long sgte(long firstRef, long secondRef);

    public static native long slt(long firstRef, long secondRef);

    public static native long slte(long firstRef, long secondRef);

    public static native long sll(long firstRef, long secondRef);

    public static native long srl(long firstRef, long secondRef);

    public static native long sra(long firstRef, long secondRef);

    public static native long implies(long firstRef, long secondRef);

    public static native long iff(long firstRef, long secondRef);

    public static native long concat(long firstRef, long secondRef);

    public static native long cond(long condRef, long firstRef, long secondRef);

    public static native long zero(long ref);

    public static native long constBitvec(String bits);

    public static native boolean isBoolSort(long ref);

    public static native long constNodeTrue();

    public static native long constNodeFalse();

    public static native long getSort(long ref);

    public static native int getId(long ref);

    public static native String getSymbol(long ref);

    public static native int simplify();

    public static native long constInt(int value, long ref);

    public static native long sext(long ref, int width);

    public static native long uext(long ref, int width);

    public static native long slice(long ref, int upper, int lower);

    public static native long arraySort(long indexSortRef, long elementSortRef);

    public static native long array(long ref, String name);

    public static native long read(long arrayRef, long indexRef);

    public static native long write(long arrayRef, long indexRef, long valueRef);

    public static native long param(long ref, String name);

    public static native long fun(long[] params, int length, long nodeBody);

    public static native long apply(long[] argNodes, int length, long ref);

    public static native void printModel();

    public static native String getBits(long ref);

    public static native long constLong(String value);

    public static native long forAll(long[] params, int length, long ref);

    public static native boolean boolectorAssert(String ans, long ref);

    public static native int kindNode(long ref);

    public static native long writerInArray(long refIndex, long refElements, String name, long[] toLong, int length);
}
