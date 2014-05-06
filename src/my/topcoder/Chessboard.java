package my.topcoder;

public class Chessboard {
	public static String changeNotation(String cell) {

		char[] xy = cell.toCharArray();
		String result = null;
		if (Character.isLetter(xy[0])) {
			int pos = Integer.parseInt(String.valueOf(xy[1]));
			int let =  xy[ 0] - 'a'+1;
			int res = ( pos- 1) * 8 + let;
			
			result = String.valueOf(res);
		}else{
			
			int res = Integer.parseInt(cell);
			int let = res/8+1;
			int pos = res%8;
			char x = (char) ('a'+pos-1);
			result = String.valueOf(x)+String.valueOf(let);
		}

		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(changeNotation("2"));
	}
}
