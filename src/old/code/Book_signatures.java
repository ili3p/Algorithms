package old.code;

import java.io.*;
class Book_signatures {

	public static String getIt(String input)
	{
		String [] mn = new String[2];
		mn = input.split(";");
		Integer pages = new Integer(mn[0]);
		Integer sheets = new Integer(mn[1]);
		int i,signatures=0;
		for(i=pages, pages=0; pages < i; pages+=4*sheets, ++signatures);
		int pPerSig = pages/signatures;
		String r = "";
		int curPage = 0;
		for(int m=0; m < signatures; ++m)
		{
			r += "signature "+(m+1)+"\n";
			int [] str = new int[4];
			int tmk =0;
			for(int k=0; k < sheets; ++k)
			{
				str[0] = curPage +1 + k*2;
				str[1] = str[0] +1;
				str[3] = curPage + pPerSig - k*2;
				if(k==0)tmk = str[3];
				str[2] = str[3]-1;
				
				r+=" sheet "+(k+1)+": pages "+str[1]+" and "+str[2]+" (front); pages "+str[3]+" and "+str[0]+" (back)\n";
			}
			curPage = tmk;
		}
		r+="\n";
		return r;
	}
	public static int main(String[] args) throws IOException{
	InputStreamReader isr = new InputStreamReader(System.in);
     BufferedReader br = new BufferedReader(isr);

     String in;
     while(br.readLine().charAt(0) > '0' && br.readLine().charAt(0) < '9')
     {
        in = br.readLine();
        
        String out = getIt(in);
        System.out.write(out.getBytes());
        
     }
     return 0;
	}
	
	}
