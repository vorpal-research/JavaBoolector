class BoolectorNode extends BoolectorObject {

    BoolectorNode(long ref) {
        super(ref);
    }

    void release() {
        Native.releaseNode(ref);
    }

    BoolectorNode copy() {
        return new BoolectorNode(Native.copy(ref));
    }

    BoolNode eq(BoolectorNode node) {
        return new BoolNode(Native.eq(ref, node.ref));
    }

    BoolectorNode ite(BoolNode cond, BoolectorNode elseNode) {
        return new BoolectorNode(Native.cond(cond.ref, ref, elseNode.ref)); //fdjfksdjfkldsjfksdjfkljdskfjsdkfsjklfsfkdsfjklds
    }

    BoolectorSort getSort() {//если уже изменялся все сломается
        return new BoolectorSort(Native.getSort(ref));
    }

    int getID() {
        return Native.getId(ref);
    }

    String getSymbol() {
        return Native.getSymbol(ref);
    }

    void assertForm() {
        Native.assertForm(ref);
    }

    //dsfjsklxfjksdljfklsdjfklsdjfklsjfkls
    BitvecNode toBitvecNode() {
        if (isArrayNode()) throw new ClassCastException();
        return new BitvecNode(ref);
    }

    BoolNode toBoolNode() {
        if (isBoolConst() || isBoolNode()) return new BoolNode(ref);
        else throw new ClassCastException();
    }

    ArrayNode toArrayNode() {
        if (isArrayNode()) return new ArrayNode(ref);
        else throw new ClassCastException();
    }

    boolean isBoolConst() {
        return Native.kindNode(ref) == 0;
    }

    boolean isBitvecConst() {
        return Native.kindNode(ref) == 1;
    }

    boolean isArrayNode() {
        return Native.kindNode(ref) == 2;
    }

    boolean isBoolNode() {
        return Native.kindNode(ref) == 3;
    }

    boolean isBitvecNode() {
        return Native.kindNode(ref) == 4;
    }


}
