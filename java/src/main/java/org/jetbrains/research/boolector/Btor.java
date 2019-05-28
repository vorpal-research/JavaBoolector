package org.jetbrains.research.boolector;

import java.io.IOException;

public class Btor {
    public Btor() {
        Native.btor();
    }

    static {
        try {
            NativeUtils.loadLibraryFromJar("/libJavaBoolector.so");
        } catch (IOException e) {
            // This is probably not the best way to handle exception :-)
            e.printStackTrace();
        }
    }

    public void btorRelease() {
        Native.btorRelease();
    }

    public void printModel() {
        Native.printModel();
    }
}
