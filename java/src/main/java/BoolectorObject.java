import java.util.*;

abstract class BoolectorObject {

    final long ref;

    BoolectorObject(long ref) {
        this.ref = ref;
    }

    abstract void release();
}
