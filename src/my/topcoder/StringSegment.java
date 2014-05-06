package my.topcoder;

public class StringSegment {

	public double average(String s) {
		
		int count =1;

		char x = s.charAt(0);
		for(int i=1;i<s.length(); ++i){
			char tmp = s.charAt(i); 
			if(tmp != x){
				count++;
			}
			x = tmp;
		}
		return s.length()/(double)count;
	}

}
