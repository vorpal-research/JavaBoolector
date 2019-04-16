public class BoolectorNode extends BoolectorObject{

    BoolectorNode(long ref) {
        super(ref);
    }

    static BoolectorNode var(BoolectorSort sort, String name) {
        return new BoolectorNode(Native.var(sort.ref,name));
    }

    void release() {
        Native.releaseNode(ref);
        getAllObj().remove(ref);
    }

    public BoolectorNode copy() {
        return new BoolectorNode(Native.copy(ref));
    }

    BoolectorNode eq(BoolectorNode node) {return new BoolectorNode(Native.eq(ref,node.ref));}

    void assertForm() {
        Native.assertForm(ref);
    }

    BitvecNode toBitvecNode() {
       // if (isBitvec) .. .
        return new BitvecNode(ref);
    }

    BitvecNode not() {
        return new BitvecNode(Native.not(ref));
    }

    BitvecNode add(BitvecNode bvNode) {
        return new BitvecNode(Native.add(ref, bvNode.ref));
    }

    BitvecNode and(BitvecNode bvNode) {
        return new BitvecNode(Native.and(ref, bvNode.ref));
    }

    BitvecNode or(BitvecNode bvNode) {
        return new BitvecNode(Native.or(ref, bvNode.ref));
    }

    BitvecNode xor(BitvecNode bvNode) {
        return new BitvecNode(Native.xor(ref, bvNode.ref));
    }

    BitvecNode neg() {
        return new BitvecNode(Native.neg(ref));
    }

    BitvecNode sub(BitvecNode bvNode) {
        return new BitvecNode(Native.sub(ref, bvNode.ref));
    }

    BitvecNode mul(BitvecNode bvNode) {
        return new BitvecNode(Native.mul(ref, bvNode.ref));
    }

    BitvecNode sdiv(BitvecNode bvNode) {
        return new BitvecNode(Native.sdiv(ref, bvNode.ref));
    }

    BitvecNode udiv(BitvecNode bvNode) {
        return new BitvecNode(Native.udiv(ref, bvNode.ref));
    }

    BitvecNode smod(BitvecNode bvNode) {
        return new BitvecNode(Native.smod(ref, bvNode.ref));
    }

    BitvecNode urem(BitvecNode bvNode) {
        return new BitvecNode(Native.urem(ref, bvNode.ref));
    }

    BitvecNode sgt(BitvecNode bvNode) {
        return new BitvecNode(Native.sgt(ref, bvNode.ref));
    } //     return boolSort {

    BitvecNode sgte(BitvecNode bvNode) {
        return new BitvecNode(Native.sgte(ref, bvNode.ref));
    }

    BitvecNode slt(BitvecNode bvNode) {
        return new BitvecNode(Native.slt(ref, bvNode.ref));
    }

    BitvecNode slte(BitvecNode bvNode) {
        return new BitvecNode(Native.slte(ref, bvNode.ref));
    }//                 }

    BitvecNode sll(BitvecNode bvNode) {
        return new BitvecNode(Native.sll(ref, bvNode.ref));
    }

    BitvecNode srl(BitvecNode bvNode) {
        return new BitvecNode(Native.srl(ref, bvNode.ref));
    }

    BitvecNode sra(BitvecNode bvNode) {
        return new BitvecNode(Native.sra(ref, bvNode.ref));
    }
}
