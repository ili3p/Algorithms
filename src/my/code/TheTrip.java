package my.code;
//double rounding problem
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class TheTrip {
	public static void main(String[] args) throws IOException {

		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		String line;

		int i = 1;

		while ((line = reader.readLine()) != null) {

			int lines = Integer.parseInt(line.split(" ")[0]);
			if (lines == 0)
				break;
			String[] field = new String[lines];

			for (int k = 0; k < lines; ++k) {
				field[k] = reader.readLine();
			}

			Solver solve = new Solver();

			double dollars = solve.getResult(field);
			
			DecimalFormat df = new DecimalFormat("#.##");
			System.out.println(dollars);
			System.out.println("$"+df.format(dollars));
			++i;
		}
	}

	public static class Solver {

		public double getResult(String[] field) {

			DecimalFormat df = new DecimalFormat("#.##");
			double result = (float) 0.0;
			double avg =0.0;
			for(String e:field){
				avg+=Double.parseDouble(e);
			}
			
			avg/=field.length;
			
			avg = Double.parseDouble(df.format(avg).replaceAll(",", "."));
			for(String e:field){
				double current = Double.parseDouble(e);
				double dif = avg-current;
				result += Double.parseDouble(df.format(Math.abs(dif)).replaceAll(",", "."));
				
			}

			return result/2;
		}

		
	}
}
