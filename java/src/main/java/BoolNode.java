class BoolNode extends BoolectorNode {
    BoolNode(long ref) {
        super(ref);
    }

    static BoolNode constBool(boolean bool) {
        return new BoolNode(bool ? Native.constNodeTrue() : Native.constNodeFalse());
    }

    BoolNode and(BoolNode boolNode) {
        return new BoolNode(Native.and(ref, boolNode.ref));
    }

    BoolNode or(BoolNode boolNode) {
        return new BoolNode(Native.or(ref, boolNode.ref));
    }

    BoolNode xor(BoolNode boolNode) {
        return new BoolNode(Native.xor(ref, boolNode.ref));
    }

    BoolNode not() {
        return new BoolNode(Native.not(ref));
    }

    BoolNode implies(BoolNode boolNode) {
        return new BoolNode(Native.implies(ref, boolNode.ref));
    }

    BoolNode iff(BoolNode boolNode) {
        return new BoolNode(Native.iff(ref, boolNode.ref));
    }

}
