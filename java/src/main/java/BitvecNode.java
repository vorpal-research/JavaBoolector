class BitvecNode extends BoolectorNode {
    BitvecNode(long ref) {
        super(ref);
    }

    static BitvecNode var(BitvecSort sort, String name) {
        return new BitvecNode(Native.var(sort.ref, name));
    }

    static BitvecNode zero(BitvecSort sort) {
        return new BitvecNode(Native.zero(sort.ref));
    }

    static BitvecNode constBitvec(String bits) {
        return new BitvecNode(Native.constBitvec(bits));
    }

    static BitvecNode constInt(int value, BitvecSort sort) {
        return new BitvecNode(Native.constInt(value, sort.ref));
    }

    static BitvecNode constLong(long value) {
        return new BitvecNode(Native.constLong(String.valueOf(value)));
    }

    BitvecNode sext(int width) {
        return new BitvecNode(Native.sext(ref, width));
    }

    BitvecNode uext(int width) {
        return new BitvecNode(Native.uext(ref, width));
    }

    BitvecNode slice(int upper, int lower) {
        return new BitvecNode(Native.slice(ref, upper, lower));
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

    BoolNode sgt(BitvecNode bvNode) {
        return new BoolNode(Native.sgt(ref, bvNode.ref));
    }

    BoolNode sgte(BitvecNode bvNode) {
        return new BoolNode(Native.sgte(ref, bvNode.ref));
    }

    BoolNode slt(BitvecNode bvNode) {
        return new BoolNode(Native.slt(ref, bvNode.ref));
    }

    BoolNode slte(BitvecNode bvNode) {
        return new BoolNode(Native.slte(ref, bvNode.ref));
    }

    BitvecNode sll(BitvecNode bvNode) {
        return new BitvecNode(Native.sll(ref, bvNode.ref));
    }

    BitvecNode srl(BitvecNode bvNode) {
        return new BitvecNode(Native.srl(ref, bvNode.ref));
    }

    BitvecNode sra(BitvecNode bvNode) {
        return new BitvecNode(Native.sra(ref, bvNode.ref));
    }

    BitvecNode concat(BitvecNode bvNode) {
        return new BitvecNode(Native.concat(ref, bvNode.ref));
    }

    String getBits() {
        return Native.getBits(ref);
    }

}
