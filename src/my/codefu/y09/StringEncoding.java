package my.codefu.y09;

public class StringEncoding {
	@SuppressWarnings("unused")
	public String encode(String s) {
		char [] c = s.toCharArray();
		
		char[][] c2 = new char[1000][1000];
		char temp = c[0];
		int m = 0;
		char [] s1 = new char [s.length()];
		
		boolean st = true;
		int num = 0;int j=1;
		s1[0] = c[0];
		
		for(int i=0;i<c.length;++i)
		{
			if(temp == c[i]){++num;
				if(num == 2)s1[j++] = temp;}
			else {if (num>1){ s1[j++]=Integer.toString(num).toCharArray()[0];}temp=c[i];num=1;}
			
		}
		s1[j++]=Integer.toString(num).toCharArray()[0];
		char []ms = new char[ j];
		ms = s1;
			String s2 = new String(ms);
			
			return s2;
		}
	public static void main(String[] args) {
		StringEncoding s = new StringEncoding();
		System.out.print(s.  encode("aaabbcbbaaa") );

	}

}
