/**
 * 
 */
package my.codefu.y10.online2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ilija Ilievski
 *
 */
public class FootballStickers {
	public static int getStartPoint(int[] stickers, int friends) {
		
//		friends = friends + 1; //+ me?
		int n = stickers.length;
		
		int k = n - (n%friends);
		
		int num = k/friends;
		int  repetitions =0;
		int []mRep = new int [friends];
		int startIndex;
		int min = Integer.MAX_VALUE;
		int minStart = Integer.MAX_VALUE;
		int sticker;
		for(startIndex=0;startIndex < friends;++startIndex)
		{
			int d = startIndex;
			
			
			for(int i=0;i<friends;++i){
				List<Integer> st = new ArrayList<Integer>();	
				for(int j=0;j<num;++j){
					
					sticker = stickers[d+j*friends];
					
					if(st.contains(sticker)) repetitions++;
					
					st.add(sticker);
				}
			}
			mRep[startIndex] = repetitions;
			
			if(min > repetitions){
				min = repetitions;
				minStart = startIndex;
			}
			repetitions = 0;
		}
		
		
	    return minStart;
	  }
	
	public static void main(String[] args) {
		
		int [] stickers = {1,2,4,2,2,0,0,4,4,3,1,2,1,0,2,4,2,1,2,3}	;
		
		System.out.println(getStartPoint(stickers, 4));
	}
}
