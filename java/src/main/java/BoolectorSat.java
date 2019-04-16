class BoolectorSat {

    static final int SAT = 10;
    static final int UNSAT = 20;
    static final int UNKNOWN = 0;


    static int sat() {
        int name = getSat();
        switch (name) {
            case 10:
                return SAT;
            case 20:
                return UNSAT;
            default:
                return UNKNOWN;

        }
    }

    private static int getSat() {
     return Native.getSat();
    }
}

