package org.jetbrains.research.boolector;

public class BoolectorSat {

    public enum Status {
        SAT(10),
        UNSAT(20),
        UNKNOWN(0);

        private final int intValue;

        Status(int i) {
            this.intValue = i;
        }

        public final int toInt() {
            return this.intValue;
        }
    }

    public static int simplify() {
        return Native.simplify();
    }

    public static int getBoolectorSat() {
        return Native.getSat();
    }
}

