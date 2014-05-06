package my.topcoder;
import java.util.*;

public class PlasticNumbers {
	public int countSets(int number) {

		char[] num = String.valueOf(number).toCharArray();
		Arrays.sort(num);
		int[] c = new int[10];
		char o = '0';
		for (int i = 0; i < num.length; i++) {
			++c[num[i] - o];
		}
		c[6] += c[9];
		c[9] = 0;
		c[6]=(int) Math.ceil(c[6]/2.0);
		int max = -1;
		for(int i=0;i<c.length;++i){
			max =  Math.max(max, c[i]);
		}

		return max;
	}
	public static void main(String[] args) {
		PlasticNumbers p = new PlasticNumbers();
		System.out.println(p.countSets(666666666));
	}
	
}

