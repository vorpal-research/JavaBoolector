package org.jetbrains.research.boolector;

public class UninterpretedFunction extends BoolectorFunction {
    private final String name;

    private UninterpretedFunction(Btor btor, long ref, String name) {
        super(btor, ref);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static UninterpretedFunction func(String name, BoolectorSort sort) {
        Btor btor = sort.getBtor();
        return new UninterpretedFunction(btor, Native.uf(btor.getRef(), sort.ref, name), name);
    }
}
