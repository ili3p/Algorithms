/**
 * 
 */
package my.codefu.y10.online2;

/**
 * @author Ilija Ilievski
 * 
 */
public class SumOfConsecutiveNumbers {

	public static int largestN(int S) {

		int sum = 0;
		int max = 0;
		int count = 0;

		
		if (S % 2 == 1) { // neparen
			
			count = 3;
			
			
		} else {
			count = 2;
			int start = (S / count)-count;
			
			while (start > 0) {
				
				while (sum < S) {
					for(int i=0;i<count;++i,++start){
						
						sum += start;
					}
				}

				if (sum == S && max < count) {
					max = count;
				}
				count+=2;
				sum=0;
				
			}

		}
		
		return max;
	}

	public static void main(String[] args) {
		System.out.println(largestN(15));
	}
}