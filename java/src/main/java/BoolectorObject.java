import java.util.*;

abstract class BoolectorObject {

    final long ref;
    private static Map<Long, List<BoolectorObject>> allObj = new HashMap<Long, List<BoolectorObject>>();

    BoolectorObject(long ref) {
        this.ref = ref;
        setAllObj();
    }

    private void setAllObj() {
        if (!existObj(ref)) allObj.put(ref, new ArrayList<BoolectorObject>());
        allObj.get(ref).add(this);
    }

    static Map<Long, List<BoolectorObject>> getAllObj() {
        return allObj;
    }

    static boolean existObj(long ref) {
        return allObj.get(ref) != null;
    }

    abstract void release();

    static void releaseAll() {
        Map<Long, List<BoolectorObject>> map = new HashMap<Long, List<BoolectorObject>>();

        for (Map.Entry<Long, List<BoolectorObject>> now : allObj.entrySet()) {
            map.put(now.getKey(), now.getValue());
        }
        for (Map.Entry<Long, List<BoolectorObject>> nowRef : map.entrySet()) {
            nowRef.getValue().get(0).release();
        }

    }
}
