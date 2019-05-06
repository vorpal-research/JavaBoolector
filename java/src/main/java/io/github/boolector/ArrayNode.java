package io.github.boolector;

public class ArrayNode extends BoolectorNode {

    ArrayNode(long ref) {
        super(ref);
    }

    public static ArrayNode arrayNode(ArraySort sort, String name) {
        return new ArrayNode(Native.array(sort.ref, name));//sfdjfsdjffffffffffffffff
    }

    public static ArrayNode constArrayNode(String name, BitvecNode... elements) {
        int length = elements.length;
        BitvecSort indexSort = BitvecSort.bitvecSort(widthSort(length));
        BitvecSort elementsSort;
        if (length == 0) elementsSort = BitvecSort.bitvecSort(0);
        else elementsSort = elements[0].getSort().toBitvecSort();
        return new ArrayNode(Native.writerInArray(indexSort.ref, elementsSort.ref, name, toLong(elements), elements.length));
    }

    private static int widthSort(int width) {
        int ans = 0;
        for (int i = 1; i < width; i *= 2) ++ans;
        return ans;
    }

    public BitvecNode read(BitvecNode index) {
        return new BitvecNode(Native.read(ref, index.ref));
    }

    public ArrayNode write(BitvecNode index, BitvecNode value) {
        return new ArrayNode(Native.write(ref, index.ref, value.ref));
    }

}
