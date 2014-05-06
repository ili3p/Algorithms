package my.code;
//mnogu dosadna!!
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LCDdisplay {
	public static void main(String[] args) throws IOException {

		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		String line;

		int i = 1;

		while ((line = reader.readLine()) != null) {

			int lines = Integer.parseInt(line.split(" ")[0]);
			if (lines == 0)
				break;

			Solver solve = new Solver();

			System.out.println(solve.getResult(lines, line.split(" ")[1]));
			++i;
		}
	}

	public static class Solver {

		public String getResult(int size, String number) {

			StringBuilder sb = new StringBuilder();

			for (int rows = 0; rows < 2 * size + 3; ++rows) {
			
				for (int k = 0; k < number.length(); ++k) {
					char c = number.charAt(k);
					switch(c){
					case '0': {
						sb.append(" ");
						for(int m=0;m<size;++m)
							sb.append("-");
						sb.append(" ");
						break;
					}
					case '1': {
						sb.append(" ");
						for(int m=0;m<size;++m)
							sb.append(" ");
						sb.append(" ");
						break;
							
					}
					case '2': {
						
					}
						
					}
				if(k+1!=number.length())sb.append(" ");
				}
			}

			return null;
		}

	}
}
