public class JBoolectorSort {
    public long sortRef = -1L;

    public JBoolectorSort jboolectorBitvecSort(int width) {
        JBoolectorSort bitvecSort = new JBoolectorSort();
        bitvecSort.sortRef = jboolectorBitvecSortC(width);
        return bitvecSort;
    }

    private native long jboolectorBitvecSortC(int width);

    public void jboolectorReleaseSort() {
        jboolectorReleaseSortC(sortRef);
        sortRef = -1L;
    }

    private native void jboolectorReleaseSortC(long sortRef);
}
