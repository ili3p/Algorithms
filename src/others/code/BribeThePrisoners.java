package others.code;

import java.util.Scanner;

public class BribeThePrisoners {
	
/*
		*//**
		 * @param args
		 *//*
		static int[] release; 
		static long[][] table;
		
		public static long solve(int s, int e) {
			//System.out.println("Solving "+s+" to "+e+": ");
			if (s > e) {
				return 0;
			}
			if (table[s][e] != -1) {
				return table[s][e]; 
			}
			if (s==e) { //base case
				table[s][e] = release[e+1]-release[s-1]-2; 
				return table[s][e];
			} else {
				long min = release.length*release[release.length-1];
				long temp;
				for (int i = s; i<=e; i++) {
					temp = solve(s,i-1)+solve(i+1,e)+release[e+1]-release[s-1]-2;
					if (temp<min) {
						min = temp;
					}
				}
				table[s][e] = min;
				//System.out.println(min);
				return min;
			}
		}
		
		public static long answer(Scanner in) {
		
			int p = in.nextInt();
			int q = in.nextInt();
			
			release = new int[q+2];
			
			release[0] = 0;
			for (int i = 1; i<=q; i++) {
				release[i] = in.nextInt();
			}
			release[q+1] = p+1;
			
			table= new long[q+1][q+1];
			
			for (int i=0;i<=q;i++) {
				for (int j=0; j <= q; j++) {
					table[i][j] = -1;
				}
			}
			return solve(1,q);
		}
		
		public static void main(String[] args) {
			try {
				Scanner infile = new Scanner(System.in);
				
				int t = infile.nextInt();
				infile.nextLine();
							
				for (int i = 0; i<t;i++) {
					
					System.out.print("Case #"+(i+1)+": ");
					System.out.println(answer(infile));
				}
				infile.close();

			} catch (Exception e) 
			{
				System.out.println("Exception occured, stacktrace to follow.");
				e.printStackTrace();
			}

		}

	}*/
	@SuppressWarnings("unused")
	public static void main(String[] argv) {

//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(BribeThePrisoners.class.getResourceAsStream("resource/C-large-practice.in"));
//		BufferedReader in = new BufferedReader(new FileReader(inFName));
//		PrintWriter out = new PrintWriter(new File(outFName));
		
		int tests = sc.nextInt();
		for (int t = 1; t <= tests; t++) {
			int p = sc.nextInt(), q = sc.nextInt();
			int[] cells = new int[q];
			for (int i = 0; i < q; i++) {
				cells[i] = sc.nextInt();
			}
			int[] nums = new int[q + 1];
			nums[0] = cells[0] - 1;
			for (int i = 1; i < q; i++) {
				nums[i] = cells[i] - cells[i - 1] - 1;
			}
			nums[q] = p - cells[q - 1];
			int[][] fromto = new int[q + 1][q + 1];

			for (int start = 0; start <= q; start++) {
				// fromto[start][start] = nums[start];
			}

			for (int d = 1; d <= q; d++) {
				for (int start = 0; start <= q - d; start++) {
					int min = p * p;
					int all = 0;
					for (int i = 0; i <= d; i++) {
						int num =nums[start + i]; 
						all += num;
					}
					int d1 =d-1;
					all += d1;
					for (int i = 0; i < d; i++) {
						int index = start;
						int mindex = start+i;						
						int startStartI = fromto[start][start + i];
						int index2 = start+i+1;
						
						int mindex2 = start+d;
						int startI1StartD =fromto[start + i + 1][start + d]; 
						int sum = 0; 
						sum = all + startStartI
								+ startI1StartD;
						
						if (sum < min) {
							min = sum;
						}
					}

					fromto[start][start + d] = min;
				}
			}
			for (int i = 0; i <= q; i++) {
				for (int j = i; j <= q; j++) {
					// System.err.printf("fromto[%d][%d] = %d\n", i, j,
					// fromto[i][j]);
				}
			}

			System.err.println(t);
			System.out.printf("Case #%d: %d\n", t, fromto[0][q]);
		}
	}
}


