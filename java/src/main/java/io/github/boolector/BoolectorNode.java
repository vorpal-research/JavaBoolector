package io.github.boolector;

public class BoolectorNode extends BoolectorObject {

    BoolectorNode(long ref) {
        super(ref);
    }

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
        return Native.kindNode(ref) == 0;
    }

    public boolean isBitvecConst() {
        return Native.kindNode(ref) == 1;
    }

    public boolean isArrayNode() {
        return Native.kindNode(ref) == 2;
    }

    public boolean isBoolNode() {
        return Native.kindNode(ref) == 3;
    }

    public boolean isBitvecNode() {
        return Native.kindNode(ref) == 4;
    }


}
