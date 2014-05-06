package my.topcoder;
import java.util.*;

public class KingSort {

    class King implements Comparable<King> {
        String name;
        String whole;
        Integer number;

        public King(String whole) {
            this.whole = whole;
            
            String[] arg = whole.split(" ");
            name = arg[0];
            number = getRoman(arg[1]);
        }

        private Integer getRoman(String string) {

            return romanToDecimal(string);
        }

        public int compareTo(King o) {
            int k = name.compareTo(o.name);

            if (k == 0) {
                k = number.compareTo(o.number);
            }

            return k;
        }

    }

    public static Integer romanToDecimal(java.lang.String romanNumber) {
        Integer decimal = 0;
        int lastNumber = 0;
        String romanNumeral = romanNumber.toUpperCase();
        /*
         * operation to be performed on upper cases even if user enters roman
         * values in lower case chars
         */
        for (int x = romanNumeral.length() - 1; x >= 0; x--) {
            char convertToDecimal = romanNumeral.charAt(x);

            switch (convertToDecimal) {
            case 'M':
                decimal = processDecimal(1000, lastNumber, decimal);
                lastNumber = 1000;
                break;

            case 'D':
                decimal = processDecimal(500, lastNumber, decimal);
                lastNumber = 500;
                break;

            case 'C':
                decimal = processDecimal(100, lastNumber, decimal);
                lastNumber = 100;
                break;

            case 'L':
                decimal = processDecimal(50, lastNumber, decimal);
                lastNumber = 50;
                break;

            case 'X':
                decimal = processDecimal(10, lastNumber, decimal);
                lastNumber = 10;
                break;

            case 'V':
                decimal = processDecimal(5, lastNumber, decimal);
                lastNumber = 5;
                break;

            case 'I':
                decimal = processDecimal(1, lastNumber, decimal);
                lastNumber = 1;
                break;
            }
        }
        return decimal;
    }

    public static int processDecimal(int decimal, int lastNumber,
            int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }

    public String[] getSortedList(String[] kings) {
        Arrays.sort(kings);
        List<King> list = new ArrayList<King>();
        
        for(String k:kings){
            list.add(new King(k));
        }
        Collections.sort(list);int i=0;
        for(King k:list){
            kings[i++] = k.whole;
        }
        
        return kings;
    }

}
