package my.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import my.codejam.y09.round1.BribeThePrisoners;

public class BribeThePrisonners {
	@SuppressWarnings("unused")
	public static void runIt() throws IOException {

		String inFName = "C-large.in";
		String outFName = "C-large.out";

		BufferedReader in = new BufferedReader(new FileReader(inFName));
		PrintWriter out = new PrintWriter(new File(outFName));

		int testCases = Integer.parseInt(in.readLine());

		for (int i = 0; i < testCases; ++i) {

			String line = in.readLine();
			String[] pQ = line.split(" ");
			int pris = Integer.parseInt(pQ[0]);
			
			int questions = Integer.parseInt(pQ[1]);
			line = in.readLine();
			String [] releases = line.split(" ");
			int result = 0;
			int n=releases.length;
			
			int [][] dp = new int[n][n];
			
			int h,j,k;
			for(k=0;k<n;)
			for(h=0;h<n;++h)
				for(j=0;j<n;++j){
					dp[h][j]=Integer.parseInt(releases[k]);
					++k;
				}
			
			
			out.println("Case #" + (i + 1) + ": " + result);
		}

		in.close();
		out.flush();
		out.close();
	}

	public static void main(String[] args) {

		try {
			BribeThePrisoners.runIt();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}

}
