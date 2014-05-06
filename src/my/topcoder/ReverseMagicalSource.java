package my.topcoder;

public class ReverseMagicalSource {

	public int find(int source, int A) {
		
		int s=source;
		if(source>A)return source;
		else{
			
			while(source<(A+1)){
				source+=s*10;
				System.out.println(source);
				s=s*10;
				System.out.println(s);
			}
		}
		return source;
	}
public static void main(String[] args) {
	char m = Character.forDigit(12, 16);
	System.out.println(m);
}
}
