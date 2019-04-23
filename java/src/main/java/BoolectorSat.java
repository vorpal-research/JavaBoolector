class BoolectorSat {

    static final int SAT = 10;
    static final int UNSAT = 20;
    static final int UNKNOWN = 0;

    static int simplify() {
        return  Native.simplify();
    }

    static int getBoolectorSat() {
     return Native.getSat();
    }
}

