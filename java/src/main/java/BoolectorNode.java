public class BoolectorNode extends BoolectorObject {

    BoolectorNode(long ref) {
        super(ref);
    }

    void release() {
        Native.releaseNode(ref);
    }

    public BoolectorNode copy() {
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

    BitvecNode toBitvecNode() {
        // if (!isArray) .. .
        return new BitvecNode(ref);
    }

    BoolNode toBoolNode() {
        return new BoolNode(ref);
    }

}
