import java.util.ArrayList;

/**
 * Created by ed on 21/12/2016.
 */
class CacheSet {
    private ArrayList<Tag> tags = new ArrayList<>();
    private long time;

    CacheSet(int k) {
        this.time = 0;

        for (int i = 0; i < k; i++)
            tags.add(i, new Tag());
    }

    /**
     * checks for a cache hit and cache misses via LRU
     *
     * @param tag tag to be checked
     * @return true for a hit
     */
    boolean checkTag(int tag) {
        time++;
        int t, index = -1;

        // check for tag caching
        for (int i = 0; i < tags.size(); i++) {
            if (tags.get(i).getV() == tag) {
                index = i;
                break;
            }
        }

        // check for cache hit
        if (index > -1) {
            Tag temp = tags.get(index);
            temp.setTime(time);
            return true;
        }
        // determine cache miss
        else {
            int oldest = 0;
            t = Integer.MAX_VALUE;

            for (int i = 0; i < tags.size(); i++) {
                if (tags.get(i).getTime() < t) {
                    oldest = i;
                    t = (int) tags.get(i).getTime();
                }
            }

            // replace LRU
            tags.get(oldest).setV(tag);
            // set write-time
            tags.get(oldest).setTime(time);
        }

        return false;
    }
}
