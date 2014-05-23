package interview.google;

import java.util.HashSet;

public class UnionFind {
    int[] ar;
    int[] sz;

    public UnionFind(int n) {
        ar = new int[n];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = i;
            sz[i] = 1;
        }
    }

    /**
     * add connection.
     */
    public void union(int p, int q) {
        
        if(sz[p]>sz[q]) {
            
        }
        int t = ar[q];
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == t) {
                ar[i] = ar[p];
            }

        }
    }

    /**
     * are p and q in same component?
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return ar[p] == ar[q];
    }

    /**
     * number of components
     * @return
     */
    public int count() {
        HashSet<Integer> s = new HashSet<Integer>();
        for (int d : ar) {
            s.add(d);
        }
        return s.size();
    }

    /**
     * component identifier for p
     * @param p
     * @return
     */
    public int find(int p) {
        return 0;
    }
}
