package my.topcoder;
public class DirectionBoard {

    public int getMinimum(String[] board) {
        return 0;
    }

    public static void main(String[] args) {
        char[] c = new char[] { 'L', 'R', 'U', 'D' };
//        for (int i = 0; i < 15; ++i) {
//            System.out.print("\"");
//            for (int k = 0; k < 15; ++k) {
//                int d = (int) (Math.random() * c.length);
//                System.out.print(c[d]);
//            }
//            System.out.println("\",");
//        }

        String[] board = new String[] {"UDUDUUDUDUDUDUR",
                "LLLLDUUDRDLUDRU",
                "DLLDLDURDURUDDL",
                "UDUDUUDUDUDUDUR",
                "LLLLDUUDRDLUDRU",
                "DLLDLDURDURUDDL",
                "UDUDUUDUDUDUDUR",
                "LLLLDUUUDDLUDRU",
                "DLLDLDURDURUDDL",
                "UDUDUUDUDUDUDUR",
                "LLLLDUUDRDLUDRU",
                "DLLDLDURDURUDDL",
                "UDUDUUDUDUDUDUR",
                "LLLLDUUDRDLUDRU",
                "RRRDLDURDURUDDR"};

        System.out.println(board.length);
        System.out.println(board[0].length());
    }

}
