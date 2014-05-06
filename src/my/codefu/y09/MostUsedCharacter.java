package my.codefu.y09;
import java.util.*;
public class MostUsedCharacter {
	public static class chars
	{
		public int num;
		public char c;		
	}
	public static String mostUsed(String sentence)
	{
		String [] words = sentence.split(" ");
	
		int [] c = new int[30];
		int offset = 'a';
		for(int i=0; i< words.length; ++i)
			{ArrayList<Character> x =new ArrayList<Character>();
			for(int j=0; j < words[i].length(); ++j)
			{		
				char m =words[i].charAt(j);
				if(x.contains(m))continue;
				else
				{
				c[m-offset]++;
				x.add(m);
				}
				
			}}
		int max=0;
		int ind=0;
		for(int i=0;i<30;++i)
		{
			if(c[i] > max){
				max=c[i];
				ind = i;
			}
		}
	
		Character f = new Character((char)(offset + ind));
		
	
//		
		return f.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	System.out.println(  mostUsed("bbbbba")); 

	}

}
