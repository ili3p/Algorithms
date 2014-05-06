package my.topcoder;

import java.util.Arrays;

public class CollectingUsualPostmarks {

	public int numberOfPostmarks(int[] prices, int[] have) {
		int sum = 0;
		for (int i : have) {
			sum+=prices[i];
		}
		Arrays.sort(prices);
		int c=0;
		for(int k:prices){
			sum-=k;
			if(sum>=0){
			++c;
			}else{
				break;
			}
		}
		return c+1;
	}

}
