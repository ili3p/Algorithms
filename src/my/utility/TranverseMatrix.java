/**
 * 
 */
package my.utility;

/**
 * @author Ilija Ilievski
 *
 */
public class TranverseMatrix {

	public static void tranverse(char [][] map){
		
		int X = map.length;
		int Y = map[0].length;
		int [] moves = {-1,0,1};
		
		int x =1, y=1; // current position
		
		for (int dx : moves) {
			for (int dy : moves) {
				
				if (dx == 0 && dy == 0) //jump the current position
					continue;
				
				if (x + dx > -1 && x + dx < X && y + dy > -1 && y + dy < Y){

					//Do something...
				}
			}
		}
	}
}
