package io.github.boolector;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;

public class Btor {

    static {
        try {
            NativeUtils.loadLibraryFromJar("/libJavaBoolector.so");
        } catch (IOException e) {
            // This is probably not the best way to handle exception :-)
            e.printStackTrace();
        }
    }

    public static void btor() {
        Native.btor();
    }

    public static void btorRelease() {
        Native.btorRelease();
    }

    public static void printModel() {
        Native.printModel();
    }
}
