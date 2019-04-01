public class JBoolectorSat {

    static final int JSAT = 10;
    static final int JUNSAT = 20;
    static final int JUNKNOWN = 0;


    public int jboolectorSat() {
        int name = jboolectorSatC();
        switch (name) {
            case 10:
                return JSAT;
            case 20:
                return JUNSAT;
            default:
                return JUNKNOWN;

        }
    }

    private native int jboolectorSatC();
}

