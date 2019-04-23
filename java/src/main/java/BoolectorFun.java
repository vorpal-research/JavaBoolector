class BoolectorFun extends BoolectorObject {

    BoolectorFun(long ref) {
        super(ref);
    }

    void release() {
        Native.releaseNode(ref);
    }

    static class FuncParam extends BoolectorFun {
        FuncParam(long ref) {
            super(ref);
        }
        static FuncParam param(BoolectorSort sort, String name) {
            return new FuncParam(Native.param(sort.ref, name));
        }
    }
}
