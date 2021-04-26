package org.jetbrains.research.boolector;

import java.util.List;

public abstract class BoolectorFunction extends BoolectorObject {

    protected BoolectorFunction(Btor btor, long ref) {
        super(btor, ref);
    }

    public void release() {
        Native.releaseNode(btor.getRef(), ref);
    }

    public BoolectorNode apply(List<BoolectorNode> argNodesFunc) {
        long[] argNodes = toLong(argNodesFunc.toArray(new BoolectorNode[0]));
        return BoolectorNode.create(btor, Native.apply(btor.getRef(), argNodes, argNodes.length, ref), null);
    }
}
