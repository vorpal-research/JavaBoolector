import org.junit.Test;

import static org.junit.Assert.*;

public class BitvecSortTest {

    @Test
    public void bitvecSort() {
        Btor.btor();
        BitvecSort sort = BitvecSort.bitvecSort(8);
        assertTrue(sort.isBitvecSort());
        assertEquals(8,sort.getWidth());
        Btor.btorRelease();
    }
}