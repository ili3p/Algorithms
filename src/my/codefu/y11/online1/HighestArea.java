package my.codefu.y11.online1;

public class HighestArea {
    public static int highest(String triangles) {
        String trinagle[] = triangles.split(";");
        double maxArea = 0;
        int maxInd = 0;

        for (int i = 0; i < trinagle.length; i++) {
            String elem = trinagle[i];
            String[] coor = elem.split(",");
            int[] c = new int[coor.length];
            for (int j = 0; j < coor.length; j++) {
                String string = coor[j];
                c[j] = Integer.parseInt(string);
            }
            int f = c[2] * c[1];
            int g= c[0] * c[3];
            int q = c[4] * c[3];
            int e = c[2] * c[5];
            int x = c[0] * c[5];
            int o = c[4] * c[1];
            
            double area = Math.abs(( f-g ) + (q - e) + (x -o )) / 2;
            if (area > maxArea) {
                maxArea = area;
                maxInd = i;
            }
        }

        return maxInd;
    }
    
    public static void main(String[] args) {
        System.out.println( highest("1,1,2,2,1,2;0,0,2,2,2,0"));
    }
}
