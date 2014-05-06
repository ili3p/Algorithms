package my.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	StreamTokenizer in;
	PrintWriter out;

	int nextInt() throws IOException {
		in.nextToken();
		return (int) in.nval;
	}

	void run() throws IOException {
		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(
				System.in)));
		out = new PrintWriter(new OutputStreamWriter(System.out));
		solve();
		out.flush();
	}

	void solve() throws IOException {
		
		int a = nextInt();
		while(a!=42){
		out.print(a);
		a = nextInt();
		}
	}
}