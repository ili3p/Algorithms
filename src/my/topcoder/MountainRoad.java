package my.topcoder;


public class MountainRoad {

	public static double findDistance(int[] start, int[] finish) {

		double result = 0.0;

		result = 2 * Math.abs(finish[0] - start[0]) / Math.sqrt(2);
		int prevFinish = finish[0];
		for (int i = 1; i < start.length; ++i) {
boolean pass = false;
			for(int f: finish){
				if(finish[i]<=f){
					pass = true;
					break;
				}
			}
			if (pass) {
				continue;
			} else {
				if (prevFinish > start[i]) {
					result -= 2 * Math.abs(start[i] - prevFinish)
							/ Math.sqrt(2);
				}
				result += 2 * Math.abs(finish[i] - start[i]) / Math.sqrt(2);

			}
			prevFinish = finish[i];
		}

		return result;
	}

	public static void main(String[] args) {

		int[] start ={1,4,5,6,-10};
		
		int[] finish = {101,102,101,100,99};
		System.out.println(findDistance(start, finish));
	}
}
