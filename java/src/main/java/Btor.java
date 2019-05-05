import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;

class Btor {

    static {
        try {
            NativeUtils.loadLibraryFromJar("/libJavaBoolector.so");
        } catch (IOException e) {
            // This is probably not the best way to handle exception :-)
            e.printStackTrace();
        }
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
