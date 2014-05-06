package my.codefu.y11.online1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class HumanitarianAction {
    private static final int X = 0;
    private static final int Y = 1;
    private static final int COST = 2;
    private static final int NAME = 3;

    public static String taken(String[] map, String dropouts) {

        int xLength = map[0].length();
        int yLength = map.length;

        Queue<Integer[]> queue = new LinkedList<Integer[]>();
        Map<String, String> valueMap = new HashMap<String, String>(xLength * yLength);

        for (int i = 0; i < yLength; i++) {
            char[] line = map[i].toCharArray();
            for (int j = 0; j < xLength; j++) {
                char field = line[j];
                System.out.print(field);
                if (Character.isDigit(field)) {
                    queue.add(new Integer[] { i, j, 0, Integer.valueOf(String.valueOf(field)) });
                    valueMap.put(j + "," + i, "0," + field);
                }
            }
            System.out.println();
        }
        System.out.println();
        while (queue.size() > 0) {
            Integer[] v = queue.poll();
            System.out.println("Mover: " + v[NAME]);
            int cost = v[COST] + 1;
            int[][] toMove = new int[][] { { v[Y], v[X] - 1 }, { v[Y], v[X] + 1 }, { v[Y] - 1, v[X] }, { v[Y] + 1, v[X] } };
            for (int i = 0; i < toMove.length; i++) {
                int[] move = toMove[i];
                if (move[0] > -1 && move[0] < xLength && move[1] > -1 && move[1] < yLength) {

                    char field = map[move[1]].charAt(move[0]);
                    System.out.println("field: " + field);
                    String moveString = move[0] + "," + move[1];
                    String prev = valueMap.get(moveString);
                    if (field != '#') {
                        if (prev == null) {
                            valueMap.put(moveString, cost + "," + v[NAME]);
                            System.out.println("1: " + moveString + "  ," + cost + "," + v[NAME]);
                            queue.add(new Integer[] { move[1], move[0], cost, v[NAME] });
                        } else {
                            String[] t = prev.split(",");
                            int prevCost = Integer.parseInt(t[0]);
                            if (prevCost > cost) {
                                valueMap.put(moveString, cost + "," + v[NAME]);
                                System.out.println("2: " + moveString + "  ," + cost + "," + v[NAME]);
                                queue.add(new Integer[] { move[1], move[0], cost, v[NAME] });
                            }
                            if (prevCost == cost) {

                                valueMap.put(moveString, cost + "," + (t[1].equalsIgnoreCase(""+v[NAME])?v[NAME]:"?"));
                                System.out.println("3: " + moveString + "  ," + cost + "," + v[NAME]);
                                queue.add(new Integer[] { move[1], move[0], cost, v[NAME] });
                            }
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        String[] dropings = dropouts.split(";");
        for (String drop : dropings) {
            sb.append((valueMap.get(drop) == null) ? "*" : valueMap.get(drop).split(",")[1]);
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        System.out.println(taken(new String[] {
            "#   ##",
            "# ####",
            "    ##",
            "#  # #",
            " # # #",
            "   3 0",
            "   1#2",
            "# #  #",
            "  #  #",
            "#### #",
            "######",
            "## ## " }, "2,7;0,10;4,11;1,0;1,11"));

    }
}
