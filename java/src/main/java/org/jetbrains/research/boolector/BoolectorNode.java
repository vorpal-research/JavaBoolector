package org.jetbrains.research.boolector;

public class BoolectorNode extends BoolectorObject {

    BoolectorNode(long ref) {
        super(ref);
    }

    private TypeNode kind = TypeNode.Unknown;

    public void release() {
        Native.releaseNode(ref);
    }

    public BoolectorNode copy() {
        return new BoolectorNode(Native.copy(ref));
    }

    public BoolNode eq(BoolectorNode node) {
        return new BoolNode(Native.eq(ref, node.ref));
    }

    public BoolectorNode ite(BoolNode cond, BoolectorNode elseNode) {
        return new BoolectorNode(Native.cond(cond.ref, ref, elseNode.ref)); //fdjfksdjfkldsjfksdjfkljdskfjsdkfsjklfsfkdsfjklds
    }

    public BoolectorSort getSort() {//если уже изменялся все сломается
        return new BoolectorSort(Native.getSort(ref));
    }

    public int getID() {
        return Native.getId(ref);
    }

    public String getSymbol() {
        return Native.getSymbol(ref);
    }

    public void assertForm() {
        Native.assertForm(ref);
    }

    //dsfjsklxfjksdljfklsdjfklsdjfklsjfkls
    public BitvecNode toBitvecNode() {
        if (isArrayNode()) throw new ClassCastException();
        return new BitvecNode(ref);
    }

    public BoolNode toBoolNode() {
        if (isBoolConst() || isBoolNode()) return new BoolNode(ref);
        else throw new ClassCastException();
    }

    public ArrayNode toArrayNode() {
        if (isArrayNode()) return new ArrayNode(ref);
        else throw new ClassCastException();
    }

    public boolean isBoolConst() {
        if (kind == TypeNode.BoolConst) return true;
        if (kind == TypeNode.Unknown) return kindNode() == TypeNode.BoolConst;
        else return false;
    }

    public boolean isBitvecConst() {
        if (kind == TypeNode.BitvecConst) return true;
        if (kind == TypeNode.Unknown) return kindNode() == TypeNode.BitvecConst;
        else return false;
    }

    public boolean isArrayNode(){
        if (kind == TypeNode.ArrayNode) return true;
        if (kind == TypeNode.Unknown) return kindNode() == TypeNode.ArrayNode;
        else return false;
    }

    public boolean isBoolNode() {
        if (kind == TypeNode.BoolNode) return true;
        if (kind == TypeNode.Unknown) return kindNode() == TypeNode.BoolNode;
        else return false;
    }

    public boolean isBitvecNode() {
        if (kind == TypeNode.BitvecNode) return true;
        if (kind == TypeNode.Unknown) return kindNode() == TypeNode.BitvecNode;
        else return false;
    }

    public TypeNode kindNode() {
        int kindObj = Native.kindNode(ref);
        switch (kindObj) {
            case 0:
                kind = TypeNode.BoolConst;
                return kind;
            case 1:
                kind = TypeNode.BitvecConst;
            return kind;
            case 2:
                kind = TypeNode.ArrayNode;
            return kind;
            case 3:
                kind = TypeNode.BoolNode;
            return kind;
            case 4:
                kind = TypeNode.BitvecNode;
            return kind;
            default:
                kind = TypeNode.Unknown;
            return kind;
        }
    }
}


