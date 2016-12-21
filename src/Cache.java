import java.util.ArrayList;
import java.util.List;

/**
 * Created by ed on 21/12/2016.
 */
class Cache {
    private int l, k, n;
    private List<CacheSet> sets = new ArrayList<>();

    Cache(int l, int k, int n) {
        this.l = l;
        this.k = k;
        this.n = n;

        for (int i = 0; i < n; i++) sets.add(i, new CacheSet(k));
    }

    boolean checkTagSet(String address) {
        int a = (int) Long.parseLong(address, 16);
        int setNumber = (a >> 4) & ((1 << (int) (Math.log(getN()) / Math.log(2))) - 1);
        int tag = a >> ((int) (Math.log(getN()) / Math.log(2)) + 4);

        CacheSet set = sets.get(setNumber);
        return set.checkTag(tag);
    }

    int getL() {
        return l;
    }

    int getK() {
        return k;
    }

    int getN() {
        return n;
    }
}
