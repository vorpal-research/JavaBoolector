public class ArrayNode extends BoolectorNode {

    ArrayNode(long ref) {
        super(ref);
    }

    ArrayNode constArray(ArraySort sort, String name) {
        return new ArrayNode(Native.array(sort.ref,name));
    }

    BitvecNode read(BitvecNode index) {
        return new BitvecNode(Native.read(ref,index.ref));
    }

    ArrayNode write(BitvecNode index, BitvecNode value) {
        return new ArrayNode(Native.write(ref,index.ref,value.ref));
    }

}
