package others.code;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CrazyRows {

	public static void main(String[] args) throws Exception {
		int i,j,k,p;
		int T,N;
		int temp;
		String line;
		
		BufferedReader br = new BufferedReader(new FileReader("resource/A-small.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("A-large.out")));
		
		StringTokenizer st;
		line = br.readLine();
		st = new StringTokenizer(line);
		T = Integer.parseInt(st.nextToken());
		
		
		for (k=1;k<=T;k++) {
			line = br.readLine();
			st = new StringTokenizer(line);
			N = Integer.parseInt(st.nextToken());
			
			int m[] = new int[N];
			
			
			for (i=0;i<N;i++) {
				line = br.readLine();
				
				for (j=0;j<N;j++) {
					if (line.charAt(j) == '1') {
						m[i] = j;
					}
				}
				
			}
			
			int res = 0;
			
			for (i=0;i<N;i++) {
				
				// we are looking for a result for the i-th row
				// here we need last one to be <= i
				
				for (p=i;p<N;p++) {
					if (m[p] <= i) break;
				}
				
				for (j=p;j>i;j--) {
					temp = m[j];
					m[j] = m[j-1];
					m[j-1] = temp;
					res++;
				}
				
			}
			
			System.out.println("Case #"+k+": "+res);
			out.println("Case #"+k+": "+res);
			
		}
		
		out.close();
		System.exit(0);	
		
	}

}
