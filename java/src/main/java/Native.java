public final class Native {

    public static native void btor();

    public static native void btorRelease();

    public static native long var(long ref,String name);

    public static native void releaseNode(long ref);

    public static native long bitvecSort(int width);

    public static native void releaseSort(long ref);

    public static native boolean isBitvecSort(long ref);

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
}
