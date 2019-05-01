class Function extends BoolectorFun {
    final private long[] params;

    private Function(long ref, long[] params) {
        super(ref);
        this.params = params;
    }

    BoolectorNode apply(BoolectorNode... argNodesFunc) {
        long[] argNodes = toLong(argNodesFunc);
        return new BoolectorNode(Native.apply(argNodes, argNodes.length, ref));
    }

    long[] getParams() {
        return params;
    }

    static Function func(BoolectorNode nodeBody, FuncParam... func_params) {
        long[] params = toLong(func_params);
        return new Function(Native.fun(params, params.length, nodeBody.ref), params);
    }

    static Function forAll(BoolectorNode nodeBody, FuncParam... func_params) {
        long[] params = toLong(func_params);
        return new Function(Native.forAll(params, params.length, nodeBody.ref), params);
    }
}
