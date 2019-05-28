import org.jetbrains.research.boolector.BitvecSort;
import org.jetbrains.research.boolector.Btor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BitvecSortTest {

    @Test
    public void bitvecSort() {
        Btor btor = new Btor();
        BitvecSort sort = BitvecSort.bitvecSort(8);
        assertTrue(sort.isBitvecSort());
        assertEquals(8,sort.getWidth());
        btor.btorRelease();
    }
}