/**
 * 
 */
package my.codefu.y10.online2;

/**
 * @author Ilija Ilievski
 *
 */
public class BestLocals {
	public static String getLocalBest(int[] points, String[] names, int start, int end) {

		int max = 0;
		int maxI=-1;
		for(int i=start; i<=end;++i){
			if(points[i]>max){
				max = points[i];
				 maxI = i;
			}
		}
			
		
	    return names[maxI];
	  }
	
	public static void main(String[] args) {
		int [] points = {47,18,43,9,50};
		String[] names = {"B","Y","if","Lft","UXe"};
		System.out.println(getLocalBest(points,names , 0, 2));
	}
}
