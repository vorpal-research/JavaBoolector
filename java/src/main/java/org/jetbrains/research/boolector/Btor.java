package org.jetbrains.research.boolector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
        BitvecNode.setConstNameClear();
        Native.btorRelease();
    }

    public List<String> dumpSmt2() {
        Native.dumpSmt2();
        return reader(Paths.get("dumpSmt2.txt"));
    }

    public List<String> printModel() {
        Native.printModel();
        return reader(Paths.get("model.txt"));
    }

    private List<String> reader(Path file) {
        List<String> text = new ArrayList<>();
        try {
            text = Files.readAllLines(file);
            Files.delete(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
