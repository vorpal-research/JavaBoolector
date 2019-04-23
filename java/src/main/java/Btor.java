public class Btor {
    static {
        String root = System.getProperty("user.dir");
        System.load(root+"/../c/lib/libJavaBoolector.so");
    }

    static void btor() {
        Native.btor();
    }

    static void btorRelease() {
        Native.btorRelease();
    }

    static void printModel() {
        Native.printModel();
    }

}
