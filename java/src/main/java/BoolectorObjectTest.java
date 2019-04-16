import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class BoolectorObjectTest {
    private static BoolectorSort sort;
    private static BoolectorNode node;

    @Test
    public void getAllObj() {
        Btor.btor();
        sort = BitvecSort.bitvecSort(8);
        node = BoolectorNode.var(sort,"nullINc");
        Map<Long, List<BoolectorObject>> allObj = BoolectorObject.getAllObj();
        assertTrue(allObj.containsKey(sort.ref) && allObj.containsKey(node.ref));
        Btor.btorRelease();
    }

    @Test
    public void existObj() {
        Btor.btor();
        sort = BitvecSort.bitvecSort(8);
        node = BoolectorNode.var(sort,"nullINc");
        assertTrue(BoolectorObject.existObj(sort.ref));
        Btor.btorRelease();
    }

    @Test
    public void releaseAll() {
        Btor.btor();
        sort = BitvecSort.bitvecSort(8);
        node = BoolectorNode.var(sort,"nullINc");
        Btor.btorRelease();
       assertEquals(new HashMap<Long, List<BoolectorObject>>(),BoolectorObject.getAllObj());
    }
}