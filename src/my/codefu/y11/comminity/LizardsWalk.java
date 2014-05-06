package my.codefu.y11.comminity;

public class LizardsWalk {
    public static int getShortestWalk(String[] fieldMap) {

        int[] gPos = new int[2], kPos = new int[2];
        boolean[] moves = new boolean[4];
        int b = fieldMap.length - 1;
        char map[][] = new char[fieldMap.length][fieldMap.length];
        for (int i = 0; i < fieldMap.length; ++i) {
            map[i] = fieldMap[i].toCharArray();
        }

        int i = 0;
        int j = 0;
        for (; i < fieldMap.length; ++i) {
            for (j=0; j < fieldMap.length; ++j) {
                char c = map[i][j];
                if (c == 'G') {
                    gPos[0] = i;
                    gPos[1] = j;
                    if (i > 1) {
                        moves[0] = (map[i - 1][j] != '#');
                    }
                    if (i < b) {
                        moves[1] = (map[i + 1][j] != '#');
                    }
                    if (j > 1) {
                        moves[2] = (map[i][j - 1] != '#');
                    }
                    if (j < b) {
                        moves[3] = (map[i][j + 1] != '#');
                    }
                }
                if (c == 'K') {
                    kPos[0] = i;
                    kPos[1] = j;
                    if (i > 1) {
                        moves[0] = (map[i - 1][j] != '#');
                    }
                    if (i < b) {
                        moves[1] = (map[i + 1][j] != '#');
                    }
                    if (j > 1) {
                        moves[2] = (map[i][j - 1] != '#');
                    }
                    if (j < b) {
                        moves[3] = (map[i][j + 1] != '#');
                    }
                }
                System.out.print(c);
            }
            System.out.println();
        }
        int tur = 1;
        for (; tur < 1000000; ++tur) {
            if (moves[0]) {
                if (kPos[0] > 1) {
                    kPos[0]--;
                }
                if (gPos[0] > 1) {
                    gPos[0]--;
                }
            }
            if (moves[1]) {
                if (kPos[0] < b ) {
                    kPos[0]++;
                }
                if (gPos[0] < b) {
                    gPos[0]++;
                }
            }
            if (moves[2]) {
                if (kPos[1] > 1) {
                    kPos[1]--;
                }
                if (gPos[1] > 1) {
                    gPos[1]--;
                }
            }
            if (moves[3]) {
                if (kPos[1] < b ) {
                    kPos[1]++;
                }
                if (gPos[1] < b) {
                    gPos[1]++;
                }
            }
            
            if(kPos[0] == gPos[0] && kPos[1]==gPos[1]) {
                return tur;
            }
            
            i = gPos[0]; 
            j = gPos[1];
            if (i > 1) {
                moves[0] = (map[i - 1][j] != '#');
            }
            if (i < b) {
                moves[1] = (map[i + 1][j] != '#');
            }
            if (j > 1) {
                moves[2] = (map[i][j - 1] != '#');
            }
            if (j < b) {
                moves[3] = (map[i][j + 1] != '#');
            }
            
            i = kPos[0]; 
            j = kPos[1];
            if (i > 1) {
                moves[0] = (map[i - 1][j] != '#');
            }
            if (i < b) {
                moves[1] = (map[i + 1][j] != '#');
            }
            if (j > 1) {
                moves[2] = (map[i][j - 1] != '#');
            }
            if (j < b) {
                moves[3] = (map[i][j + 1] != '#');
            }
            
        }

        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(getShortestWalk(new String[]{"G#..","....","##.#","K..."}));
    }
}
