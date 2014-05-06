package my.code;


public class CoinChange {
	public static void main(String[] args) {
		int []denoms = {1,3,5,6,10};
		int target = 13;
		int c = getOptimalChange(target, denoms);
	
			System.out.println(c);
	

	}

	public static int getOptimalChange(int target, int[] denoms) {

		int n = denoms.length-1;
		int m = target + 1;
		int[][] c = new int[n+1][m];

		for (int j = 0; j < m; ++j) {
			c[n][j] = j;
		}

		for (int i = n - 1; i >= 0; --i) {
			for (int j = 0; j < m; ++j) {
				
				if (denoms[i] > j || c[i + 1][j] < 1 + c[i][j - denoms[i]]) {
					c[i][j] = c[i + 1][j];
				} else {
					c[i][j] = 1 + c[i][j - denoms[i]];
				}

			}
		}
		int min = Integer.MAX_VALUE; 
		for(int i=0;i<n;++i)
			if(c[i][target]<min)min=c[i][target];
		
		return min;
	}
}
