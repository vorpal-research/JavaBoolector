package org.jetbrains.research.boolector;

public class ArrayNode extends BoolectorNode {

    ArrayNode(long ref) {
        super(ref);
    }

    public static ArrayNode arrayNode(ArraySort sort, String name) {
        return new ArrayNode(Native.array(sort.ref, name));//sfdjfsdjffffffffffffffff
    }

    public static ArrayNode constArrayNode(BitvecSort indexSort, BitvecNode element) {
        BitvecSort elementsSort= element.getSort().toBitvecSort();
        ArraySort arraySort = ArraySort.arraySort(indexSort,elementsSort);
        return new ArrayNode(Native.constArray(arraySort.ref,indexSort.ref, element.ref));
    }

    public BitvecNode read(BitvecNode index) {
        return new BitvecNode(Native.read(ref, index.ref));
    }

    public ArrayNode write(BitvecNode index, BitvecNode value) {
        return new ArrayNode(Native.write(ref, index.ref, value.ref));
    }

}
