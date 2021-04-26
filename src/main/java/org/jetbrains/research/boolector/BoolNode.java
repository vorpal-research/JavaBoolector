package org.jetbrains.research.boolector;

public class BoolNode extends BoolectorNode {
    BoolNode(Btor btor, long ref) {
        this(btor, ref, null);
    }

    BoolNode(Btor btor, long ref, String name) {
        super(btor, ref, name, TypeNode.BOOLNODE);
    }

    public static BoolNode constBool(Btor btor, boolean bool) {
        return new BoolNode(btor, bool ? Native.constNodeTrue(btor.getRef()) : Native.constNodeFalse(btor.getRef()));
    }

    public BoolNode and(BoolNode boolNode) {
        return new BoolNode(btor, Native.and(btor.getRef(), ref, boolNode.getRef()));
    }

    public BoolNode or(BoolNode boolNode) {
        return new BoolNode(btor, Native.or(btor.getRef(), ref, boolNode.getRef()));
    }

    public BoolNode xor(BoolNode boolNode) {
        return new BoolNode(btor, Native.xor(btor.getRef(), ref, boolNode.getRef()));
    }

    public BoolNode not() {
        return new BoolNode(btor, Native.not(btor.getRef(), ref));
    }

    public BoolNode implies(BoolNode boolNode) {
        return new BoolNode(btor, Native.implies(btor.getRef(), ref, boolNode.getRef()));
    }

    public BoolNode iff(BoolNode boolNode) {
        return new BoolNode(btor, Native.iff(btor.getRef(), ref, boolNode.getRef()));
    }

    public Boolean assigment() {
        return Native.bitvecAssignment(btor.getRef(), ref) == 1;
    }

    @Override
    public BoolNode toBoolNode() {
        return this;
    }

    @Override
    public BitvecNode toBitvecNode() {
        return (BitvecNode) BitvecNode.create(this.btor, this.ref, this.name);
    }

    @Override
    public BitvecNode toBitvecNode(int width) {
        return toBitvecNode().toBitvecNode(width);
    }

    @Override
    public ArrayNode toArrayNode() {
        throw new ClassCastException();
    }

}
