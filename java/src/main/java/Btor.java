public class Btor {
    static {
        String root = System.getProperty("user.dir");
        System.load(root+"/../c/lib/libJavaBoolector.so");
    }
    static void btor() {
        Native.btor();
    }

    static void btorRelease() {
        BoolectorObject.releaseAll();
        Native.btorRelease();
    }


}
