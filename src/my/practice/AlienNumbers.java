package my.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class AlienNumbers {

	public static String solve(String number, String source, String target) {

		BigInteger sum = BigInteger.ZERO;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < number.length(); ++i) {

			BigInteger val = BigInteger.valueOf(source.length());
			val = val.pow(number.length() - i-1);
			val = val.multiply(BigInteger.valueOf(source.indexOf(number
					.charAt(i))));

			sum = sum.add(val);
		}

		while (sum.compareTo(BigInteger.ZERO) > 0) {

			int index = sum.remainder(BigInteger.valueOf(target.length()))
					.intValue();
			sb.append(target.charAt(index));

			sum = sum.divide(BigInteger.valueOf(target.length()));
		}

		String result = new String(sb.reverse());

		return result;
	}

	public static void main(String[] args) {

		String problem = "A";
//		String inFName = "resource/"+problem+"-small-practice.in";
		 String inFName = "resource/"+problem+"-large-practice.in";
//		 String inFName = "resource/"+problem+"-small.in";
//		 String inFName = "resource/"+problem+"-large.in";
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
			
			new File(inFName).delete();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
