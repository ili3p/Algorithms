package my.topcoder;
import java.util.*;

public class MagicMoleculeEasy {

    public static void main(String[] args) {
        int[] magicPower = new int[] { 61422, 10815, 41813, 50959, 43846,
                61862, 89132, 69605, 81433, 30310, 37157, 51062, 2246, 30020,
                31073, 68113, 57764, 69201, 63032, 87685, 95436, 12214, 30681,
                33985, 77017, 38699, 60309, 65772, 45533, 88062, 89107, 4075,
                30917, 84063, 58573, 36221, 37217, 31666, 44205, 52226, 72709,
                66238, 35429, 40402, 68347, 13860, 84076, 80431, 79678, 90687 };
        String[] magicBond = new String[] {
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY" };

        int k = 14;
        // for (int i = 0; i < 50; ++i) {
        // System.out.println((1 + (int) (Math.random() * 100000)) + ",");
        // }

        MagicMoleculeEasy m = new MagicMoleculeEasy();
        long t = System.nanoTime();
        int ma = m.maxMagicPower(magicPower, magicBond, k);
        System.out.println(System.nanoTime() - t);
        System.out.println(ma);
    }

    class Node implements Comparable<Node> {
        int power;
        int ind;

        public Node(int p, int i2) {
            power = p;
            ind = i2;
        }

        public int compareTo(Node o) {
            return o.power - power;
        }

        @Override
        public String toString() {

            return "power:" + power + " ind:" + ind;
        }
    }

    public int maxMagicPower(int[] magicPower, String[] magicBond, int k) {

        // TODO try with kosarajuSCC
        // TODO try with biparite graph
        // TODO max-flow algos
        int n = magicPower.length - 1;
        int[] subset = new int[k];

        List<Node> list = new ArrayList<Node>();

        for (int i = 0; i < magicPower.length; ++i) {
            list.add(new Node(magicPower[i], i));
        }

        Collections.sort(list);

        for (int i = 0; i < k; ++i) {
            subset[i] = i;
        }
        int max = -1;
        while (subset != null) {
            boolean possible = check(list, subset, magicBond);
            if (possible) {
                int sum = 0;
                for (int i = 0; i < subset.length; ++i) {
                    sum += magicPower[list.get(subset[i]).ind];
                }
                return sum;
            } else {
                subset = nextSubset(n, subset);
            }
        }

        return max;
    }

    private boolean check(List<Node> list, int[] subset, String[] magicBond) {
        boolean result = true;
        for (int i = 0; i < magicBond.length; ++i) {
            char[] s = magicBond[i].toCharArray();

            for (int j = i + 1; j < s.length; ++j) {
                if (s[j] == 'Y') {
                    result = false;
                    for (int j2 = 0; j2 < subset.length; j2++) {
                        int ind = list.get(subset[j2]).ind;
                        if ((ind == i || ind == j)) {
                            result = true;
                            break;
                        }
                    }
                    if (!result) {
                        break;
                    }
                }
            }

            if (!result) {
                break;
            }
        }

        return result;
    }

    static int[] nextSubset(int n, int[] subset) {
        int l = subset.length;
        int[] result = copyArray(subset);
        boolean newSubset = false;

        for (int k = l - 1; k > -1; --k) {
            int d = l - 1 - k;
            int a = subset[k];
            if (a + 1 <= (n - d)) {
                int j = 1;
                for (int i = k; i < l; ++i) {
                    result[i] = a + j;
                    ++j;
                    newSubset = true;
                }
                break;
            }
        }
        return newSubset ? result : null;
    }

    private static int[] copyArray(int[] subset) {
        int[] result = new int[subset.length];
        for (int i = 0; i < subset.length; i++) {
            result[i] = subset[i];

        }
        return result;
    }
}
