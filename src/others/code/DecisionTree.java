package others.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

class DecisionTree implements Runnable {
    class Tree {
        double p;

        Tree(double p) {
            this.p = p;
        }

        String feature;
        Tree yes;
        Tree no;

        double count(Set<String> s) {
            if (feature == null) {
                return p;
            } else {
                return p * (s.contains(feature) ? yes.count(s) : no.count(s));
            }
        }
    }

    String d;
    int p;

    String nextToken() {
//        System.err.println(d.substring(0, p) + ">" + d.substring(p));
        while (d.charAt(p) == ' ') {
            p++;
        }
        if (d.charAt(p) == '(') {
            return "" + d.charAt(p++);
        }
        if (d.charAt(p) == ')') {
            return "" + d.charAt(p++);
        }
        if (d.charAt(p) == '$') {
            return "" + d.charAt(p++);
        }
        String r = "";
        while (d.charAt(p) != ' ' && d.charAt(p) != '(' && d.charAt(p) != ')' && d.charAt(p) != '$') {
            r = r + d.charAt(p++);
        }
        return r;
    }

    Tree parse() {
        nextToken();
        double p = Double.parseDouble(nextToken());
        Tree r = new Tree(p);
        String q = nextToken();
        if (q.equals(")")) {
            return r;
        }
        r.feature = q;
        r.yes = parse();
        r.no = parse();
        nextToken();
        return r;
    }

    public void solve() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("A-small-attempt0.in"));
        PrintWriter out = new PrintWriter(new File("A-small-attempt0.out"));

        int testn = Integer.parseInt(in.readLine());
        for (int test = 0; test < testn; test++) {
            int l = Integer.parseInt(in.readLine());
            d = "";
            for (int i = 0; i < l; i++) {
                d = d + " " + in.readLine();
            }
            d = d + "$";
            p = 0;

            Tree t = parse();

            out.println("Case #" + (test + 1) + ":");
            int n = Integer.parseInt(in.readLine());
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
               st.nextToken();
                int m = Integer.parseInt(st.nextToken());
                Set<String> f = new HashSet<String>();
                for (int i = 0; i < m; i++) {
                    f.add(st.nextToken());
                }
                out.printf("%.6f\n", t.count(f));
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
        Locale.setDefault(Locale.US);
        new Thread(new DecisionTree()).start();
    }
}