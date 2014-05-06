package others.code;

import java.util.*;
import java.io.*;


class sC implements Runnable {
    @SuppressWarnings("unchecked")
	HashMap[][] createHashMapArray(int w, int h) {
        HashMap[][] r = new HashMap[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                r[i][j] = new HashMap();
            }
        }
        return r;
    }

    @SuppressWarnings("unchecked")
	public void solve() throws IOException {
        Scanner in = new Scanner(new File("C-small-attempt0.in"));
        PrintWriter out = new PrintWriter(new File("C-small-attempt0.out"));

        int testn = in.nextInt();
        for (int test = 0; test < testn; test++) {
            int n = in.nextInt();
            int q = in.nextInt();

            char[][] a = new char[n][];
            for (int i = 0; i < n; i++) {
                a[i] = in.next().toCharArray();
            }

            out.println("Case #" + (test + 1) + ":");
            for (int qq = 0; qq < q; qq++) {
                System.err.println(test + " " + qq);
                int p = in.nextInt();
                HashMap<Integer, String>[][] h = createHashMapArray(n, n);

                String ans = null;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (a[i][j] >= '0' && a[i][j] <= '9') {
                            int v = a[i][j] - '0';
                            h[i][j].put(v, "" + a[i][j]);
                            if (v == p) {
                                ans = "" + a[i][j];
                            }
                        }
                    }
                }

                int[] dx = new int[]{0, 1, 0, -1};
                int[] dy = new int[]{1, 0, -1, 0};

                for (int s = 0; ans == null; s++) {
//                    System.err.println(s);
                    HashMap<Integer, String>[][] nh = createHashMapArray(n, n);
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            for (Integer v : h[i][j].keySet()) {
                                for (int d = 0; d < 4; d++) {
                                    int ni = i + dx[d];
                                    int nj = j + dy[d];
                                    if (!(ni >= 0 && ni < n && nj >= 0 && nj < n)) {
                                        continue;
                                    }
                                    char sgc = a[ni][nj];
                                    int sg = sgc == '+' ? 1 : -1;
                                    for (int e = 0; e < 4; e++) {
                                        ni = i + dx[d] + dx[e];
                                        nj = j + dy[d] + dy[e];
                                        if (!(ni >= 0 && ni < n && nj >= 0 && nj < n)) {
                                            continue;
                                        }
                                        int nv = v + sg * (a[ni][nj] - '0');
                                        String r = h[i][j].get(v) + sgc + a[ni][nj];
                                        if (nh[ni][nj].containsKey(nv)) {
                                            String or = nh[ni][nj].get(nv);
                                            if (r.compareTo(or) < 0) {
                                                nh[ni][nj].put(nv, r);
                                            }
                                        } else {
                                            nh[ni][nj].put(nv, r);
                                        }
                                        if (nv == p) {
                                            if (ans == null || r.compareTo(ans) < 0) {
                                                ans = r;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    h = nh;
                }
                out.println(ans);
            }

        }

        in.close();
        out.close();
    }

    public void run() {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        new Thread(new C1()).start();
    }
}