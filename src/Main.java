public class Main {

    public static void main(String[] args) {
        int[][] config = {
                //lru
                {16, 1, 8, 0},
                {16, 2, 4, 0},
                {16, 4, 2, 0},
                {16, 8, 1, 0},

                //pseudo-lru
                {16, 1, 8, 1},
                {16, 2, 4, 1},
                {16, 4, 2, 1},
                {16, 8, 1, 1}
        };

        for (int[] aConfig : config) {
            int l = aConfig[0];
            int k = aConfig[1];
            int n = aConfig[2];

            // 0 is LRU, 1 is PSEUDO_LRU
            Cache.ReplacementPolicy policy = Cache.ReplacementPolicy.values()[aConfig[3]];

            Cache cache = new Cache(l, k, n, policy);
            for (String address : Constants.inputs) {
                int currAddress = Integer.parseInt(address, 16);
                cache.access(currAddress);
            }

            int accesses = cache.getAccesses();
            int hits = cache.getHits();

            System.out.println("L: " + l + ", K: " + k + ", N: " + n + ", Policy: " + policy.toString().replace("_", " "));
            System.out.println("Accesses: " + accesses + ", Hits: " + hits + ", Hit rate: " +
                    (double) hits / accesses + "\n");
        }
    }
}