package my.practice;
//ne ja znam
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class EggDrop {

	public static String solve(String F, String D, String B) {

long floors = Integer.parseInt(F);
		int drop = Integer.parseInt(D);
		int br = Integer.parseInt(B);
		BigInteger f = BigInteger.valueOf(1);
		BigInteger val = BigInteger.valueOf(2);
		int b = 1, d;
		if (drop != br)
			for (int i = 1; i <= drop - br; ++i) {
				
				f = f.add(val.pow(drop - i));
				
				if(f.compareTo(BigInteger.valueOf(floors)) >= 0){
					b = i;
				}
			}
		else {
			f = val.pow(drop);
			f = f.subtract(BigInteger.valueOf(1));
		}
		
		if (f.compareTo(new BigInteger("4294967296")) >= 0) {
			f = BigInteger.valueOf(-1);
		}
		d =(int)Math.ceil(( Math.log(floors)/Math.log(2)));
		
		String result =f+" "+d+" "+b;
		return result;
	}

	public static void main(String[] args) {

		String problem = "C";
//		String inFName = "resource/" + problem + "-small-practice.in";
		 String inFName = "resource/"+problem+"-large-practice.in";
		// String inFName = "resource/"+problem+"-small.in";
		// String inFName = "resource/"+problem+"-large.in";
		String outFName = "resource/A.out";

		try {
			BufferedReader in = new BufferedReader(new FileReader(inFName));
			PrintWriter out = new PrintWriter(new File(outFName));

			int testCases = Integer.parseInt(in.readLine());

			for (int testCase = 1; testCase <= testCases; ++testCase) {

				String result = "No result.";

				String[] line = in.readLine().split(" ");
				

				result = solve(line[0], line[1], line[2]);

				System.out.println("Case #" + testCase + ": " + result);
				out.println("Case #" + testCase + ": " + result);
			}

			in.close();
			out.flush();
			out.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
