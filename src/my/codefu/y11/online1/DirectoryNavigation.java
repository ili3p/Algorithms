package my.codefu.y11.online1;

import java.util.Set;
import java.util.TreeSet;

public class DirectoryNavigation {
//    public static int min(String[] directories) {
//
//        Set<String> dirSet = new TreeSet<String>();
//        int lngsPath = 0;
//        for (int i = 0; i < directories.length; i++) {
//            String[] t = directories[i].split("/");
//            for (int j = 0; j < t.length; j++) {
//                String dir = t[j];
//                if (t.length > lngsPath) {
//                    lngsPath = t.length;
//                }
//                if (dir.length() > 0 && !(dirSet.contains(dir))) {
//                    dirSet.add(dir +"#%%#"+ String.valueOf(j));
//                }
//            }
//        }
//
//        return dirSet.size() * 2 - lngsPath + 1;
//    }

    public static int min(String[]directories) {
        
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(min(new String[] {
            "/yrokksu/l/tevr/awdvgakk/tevr/iivg/l/yrokksu/wom/awdvgakk/dij/yrokksu/dij/dij/wom/awdvgakk/l",
            "/jq/awdvgakk/dij/yrokksu/yrokksu/yrokksu/tnulh/yrokksu/tevr/yrokksu/iivg/tnulh/awdvgakk/tevr/yrokksu/yrokksu/awdvgakk",
            "/iivg/l/yrokksu/yrokksu/yrokksu/tnulh/dij/tnulh/iivg/tnulh/e/wom/yrokksu/tnulh/tnulh/tevr/iivg/wom/yrokksu/jq",
            "/l/e/e/dij/tnulh/tevr/tnulh/iivg/yrokksu/l/jq/wom/dij",
            "/jq/yrokksu/tnulh/jq/l/dij/jq/e/yrokksu/yrokksu/iivg/tevr/e" }));

    }
}
