package my.tco.qual;
public class RobotSimulation {

	public static int cellsVisited2(String program, int times) {
		int r = 0;
		int t = times;
		int x = 500;
		int y = 500;
		int[][] v = new int[1000][1000];
		int[][] vv = new int[1000][1000];
		v[x][y] = vv[x][y] = 1;
		char[] p = program.toCharArray();
		int lt = 0;
		if (t >= 23) {
			lt = t - 23;
			t = 23;
		}
		for (int u = 0; u < t; ++u) {
			for (int i = 0; i < p.length; ++i) {
				if (p[i] == 'D') {
					--y;
				}
				if (p[i] == 'U') {
					++y;
				}

				if (p[i] == 'L') {
					--x;
				}

				if (p[i] == 'R') {
					++x;
				}
				v[x][y] = 1;
				vv[x][y] = 1;
			}
		}
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; ++j) {
				if (v[i][j] == 1)
					r++;
			}
		}

		int d = 0;
		for (int i = 0; i < p.length; ++i) {
			if (p[i] == 'D') {
				--y;
			}
			if (p[i] == 'U') {
				++y;
			}

			if (p[i] == 'L') {
				--x;
			}

			if (p[i] == 'R') {
				++x;
			}
			v[x][y] = 1;
		}
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; ++j) {
				if (v[i][j] != vv[i][j])
					d++;
			}
		}
		return r + lt * d;
	}
	
	public static void main(String[] args) {
		int s =200000000;
		System.out.println(cellsVisited("UDLLDRLLDRL", s));
		System.out.println(cellsVisited2("UDLLDRLLDRL", s));
	}
	public static int cellsVisited(String program, int times) {
	 char[] moves = program.toCharArray();
	 int result = 0;
	 int[][] map = new int[3000][3000];
	 for (int s = 0; s < 100; s++)
	 for (int d = 0; d < 100; d++) {
	 map[s][d] = 0;
	 }
	 int count[] = new int[100];
	 int x = 3000/2;
	 int y = 3000/2;
	 count[0] = 1;
	
	 map[x][y] = 1;
	 int j=0;
	 for (j = 0; j < 100 && j < times; ++j) {
	
	 for (int i = 0; i < moves.length; ++i) {
	
	 switch (moves[i]) {
	
	 case 'L':
	 --x;
	 break;
	
	 case 'R':
	 ++x;
	 break;
	
	 case 'U':
	 ++y;
	 break;
	
	 case 'D':
	 --y;
	 break;
	 }
	 if (map[x][y] == 0) {
	 count[j]++;
	 ++map[x][y];
	 }
	
	 }
	 result += count[j];
	 }
			
	 result += (times - j) * count[j-1];
	 return result;
	 }

}
