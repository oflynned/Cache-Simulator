import java.util.ArrayList;

/**
 * Created by ed on 21/12/2016.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Cache> caches = new ArrayList<>();
        caches.add(new Cache(16, 8, 1));
        caches.add(new Cache(16, 4, 2));
        caches.add(new Cache(16, 2, 4));
        caches.add(new Cache(16, 1, 8));

        for (Cache cache : caches) {
            int count = 0;
            for (int i=0; i<Constants.inputs.length; i++) {
                if (cache.checkTagSet(Constants.inputs[i]))
                    count++;
            }
            System.out.println("L:" + cache.getL() + ", K:" + cache.getK() +
                    ", N:" + cache.getN() + ", Hits:" + count);
        }
    }
}
