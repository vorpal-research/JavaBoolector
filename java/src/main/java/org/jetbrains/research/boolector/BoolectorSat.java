package org.jetbrains.research.boolector;

public class BoolectorSat {

    public static final int SAT = 10;
    public static final int UNSAT = 20;
    public static final int UNKNOWN = 0;

    public static int simplify() {
        return Native.simplify();
    }

    public static int getBoolectorSat() {
        return Native.getSat();
    }
}

