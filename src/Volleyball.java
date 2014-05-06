public class Volleyball {
    public static String getResult(String games) {

        char[] map = games.toCharArray();

        int team1 = 0, team2 = 0, serve = 1;
        String[] sets = new String[3];
        int set = 0;
        for (char c : map) {

            if (c == '1') {

                if (serve == 1) {
                    ++team1;
                } else {
                    serve = 1;
                }

            } else if (c == '2') {
                if (serve == 2) {
                    ++team2;
                } else {
                    serve = 2;
                }
            }

            if (team1 >= 15 && team1 - team2 >= 2) {
                sets[set] = team1 + ":" + team2;
                team1 = 0;
                team2 = 0;
                serve = set % 2 == 1 ? 1 : 2;
                ++set;
            } else if (team2 >= 15 && team2 - team1 >= 2) {
                sets[set] = team1 + ":" + team2;
                team1 = 0;
                team2 = 0;
                serve = set % 2 == 1 ? 1 : 2;
                ++set;
            }

        }

        if (set == 3) {
            return sets[0] + "-" + sets[1] + "-" + sets[2];
        } else {
            return sets[0] + "-" + sets[1];
        }
    }

    public static void main(String[] args) {
        System.out.println("ex: \"15:0-0:15-15:0\"");
        System.out
                .println(getResult("111111111111111122222222222222221111111111111111"));
        // System.out
        // .print(getResult("11221122112211221122112211221122112211221122112211221122112211122222222222222222222222222222222"));
        // System.out.println("=  15:13-3:15-0:15");
        //
        // System.out
        // .println(getResult("1111111111111112222222222222222211111111111111122222222222222222")
        // + "= " + "15:0-0:15-14:16");
        //
        // System.out
        // .println(getResult("121212121222222222222222222222222222222222")
        // + "=" + "1:15-0:15");
    }
}
