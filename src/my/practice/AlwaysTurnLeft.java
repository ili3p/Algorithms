package my.practice;
//WTF problem
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class AlwaysTurnLeft {
	
	public static void main(String[] args) {

		String problem = "B";
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

				
				/** PLACE YOUR CODE HERE  **/
				
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
