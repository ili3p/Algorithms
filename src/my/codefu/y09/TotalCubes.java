package my.codefu.y09;

public class TotalCubes {

	public int howMany(int A, int B) {
		int sum = 0;
		for(int i=A;i<=B;++i)
		{
		double x1=0.3333333333333333;
		
		double r = Math.pow(i,x1);
		 r+=0.00000001;
		 double x=0.0;
		 x = r % 1;
		if(x < 0.0000001)++sum;
		}
		
		return sum;
		}
	public static void main(String[] args) {
		TotalCubes s = new TotalCubes();
		System.out.print(s.howMany(1, 63));

	}

}
