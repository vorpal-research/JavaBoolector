package org.jetbrains.research.boolector;

import java.util.List;

public class FunctionDecl extends BoolectorFunction {
    final private long[] params;

    private FunctionDecl(Btor btor, long ref, long[] params) {
        super(btor, ref);
        this.params = params;
    }

    public static class FunctionParam extends BoolectorObject {
        FunctionParam(Btor btor, long ref) {
            super(btor, ref);
        }

        public void release() {
            Native.releaseNode(btor.getRef(), ref);
        }

        public static FunctionParam param(BoolectorSort sort, String name) {
            Btor btor = sort.getBtor();
            return new FunctionParam(btor, Native.param(btor.getRef(), sort.getRef(), name));
        }
    }

    public static FunctionDecl func(BoolectorNode nodeBody, List<FunctionParam> functionParams) {
        Btor btor = nodeBody.getBtor();
        long[] params = toLong(functionParams.toArray(new FunctionParam[0]));
        return new FunctionDecl(btor, Native.fun(btor.getRef(), params, params.length, nodeBody.getRef()), params);
    }

    protected long[] getParams() {
        return params;
    }

    public static FunctionDecl forAll(BoolectorNode nodeBody, List<FunctionParam> functionParams) {
        Btor btor = nodeBody.getBtor();
        long[] params = toLong(functionParams.toArray(new FunctionParam[0]));
        return new FunctionDecl(btor, Native.forAll(btor.getRef(), params, params.length, nodeBody.getRef()), params);
    }
}
