package my.codefu.y09;



public class SumOfPowers {

	public int lastDigit(int N) {
		double r,r1;
		@SuppressWarnings("unused")
		int [] num = new int[1000001];
		double m = 0;
		int x=0;
		for(double n=1.0;n<N+1;++n)
		{ r1 = (1.0 + n)*Math.log10(n);
		 //  r1 %=1;
		//m= (int)r1/1;
		//r1 %=1;
		
		  r = Math.pow(10,r1);
		 // double x =Math.pow(10,m);
		  //r = Math.round(r);
		  if(m>0)r %= 10;
		  
		 // double x=0;
		  //x = Math.pow(10,m-1);
		   //  r%= x;
		x+=r;
		if(x>9)x%=10;
		}
		
		/*for(int i=1;i<N+1;++i)
		{
			x+=num[i];
			while(x>10)x%=10;
		}
	*/
		return x;
		}
	public static void main(String[] args) {
		SumOfPowers s = new SumOfPowers();
		System.out.print(s.lastDigit(100));
	}

}
