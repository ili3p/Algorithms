/**
 * 
 */
package my.codejam.y10.qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ilija Ilievski
 * 
 */
public class ProblemB {

	static void runIt() throws IOException {

//		String inFName = "resource/B-small-attempt2.in";
		 String inFName = "resource/B-large.in";
//		String outFName = "resource/B-small.out";
		 String outFName = "resource/B-large.out";

		BufferedReader in = new BufferedReader(new FileReader(inFName));
		PrintWriter out = new PrintWriter(new File(outFName));

		int testCases = Integer.parseInt(in.readLine());

		for (int i = 0; i < testCases; ++i) {

			String line = in.readLine();
			System.out.println(line);
			StringBuilder output = new StringBuilder();
			output.append("Case #" + (i + 1) + ": ");
			String numbers[] = line.split(" ");

			List<BigInteger> events = new ArrayList<BigInteger>();
//			BigInteger prev = new BigInteger(numbers[1]);
//			events.add(prev);
//			BigInteger minDiff = prev.subtract(new BigInteger(numbers[2]));
//			prev = new BigInteger(numbers[2]);
//			events.add(prev);
			
			for (int k = 1; k < numbers.length; ++k) {
				
				
				BigInteger event = new BigInteger(numbers[k]);
//				BigInteger curDiff =(prev.subtract(event)); 
//				if(curDiff.compareTo(minDiff) < 0){
//					minDiff =curDiff;
//				}
				events.add(event);
//				prev = event;
			}
			Collections.sort(events);
			BigInteger prev = events.get(0);
			BigInteger minDiff = new BigInteger("-1");
			BigInteger T = new BigInteger("-1");
			for(int k=1; k < events.size(); k++){
			
				BigInteger currentNum = events.get(k);
				BigInteger curDiff =(currentNum.subtract(prev)).abs(); 
				
				if(curDiff.compareTo(new BigInteger("0")) != 0 && minDiff.compareTo(new BigInteger("-1")) == 0){					
					minDiff = curDiff;
				}
				if(minDiff.compareTo(new BigInteger("-1")) != 0){
					T = minDiff.gcd(curDiff);
					
					minDiff =curDiff;
				}
				
				prev = events.get(k);
			}
			if(T.compareTo(new BigInteger("0"))==0){
				
			}
			BigInteger sss = events.get(0).mod(T);
			BigInteger s = T.subtract(sss);
			BigInteger y = s.mod(T);
			
for (BigInteger bigInteger : events) {
	BigInteger m = (bigInteger.add(y)).mod(T);
	
	if(m.compareTo(new BigInteger("0")) != 0){
		System.out.println("EERRRRORO");
	}
}			
			output.append(y.toString());
			System.out.println(output);
			out.println(output);
		}

		in.close();
		out.flush();
		out.close();
	}

	public static void main(String[] args) {

		try {
			ProblemB.runIt();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}
}
