package old.code;


public class FallingRocks {
	public int lines(int[] rocks) {
		int [] x = new int[10];
		//for(int i=0; i<10;++i)x[i]=-1;
		for(int i:rocks)
		{
		if(i==0 && x[0] == x[1] ){++x[0];continue;}
		else if(i==0 && x[0]> x[1]) {++x[1];continue;}
		else if(i==0 && x[0]<x[1]){++x[0];continue;}
		if(i==9 && x[8] == x[9]) {++x[9];continue;}
		else if(i==9 && x[9]>x[8]){ ++x[8];continue;}
		else if(i==9 && x[9]<x[8]){++x[9];continue;}
		if(x[i]>x[i-1] && x[i]<=x[i+1]){++x[i-1];continue;}
		if(x[i]>x[i+1]){++x[i+1];continue;}
		if(x[i]<= x[i+1] && x[i] <= x[i-1]){++x[i];continue;}
		
		}
		int r=21;
		for(int i=0;i<10;i++)
		{
			if(x[i]<r)r=x[i];
		}
		if(r<0)r=0;
		return r;
		}
	

	public static void main(String[] args) {
		FallingRocks ff = new FallingRocks();
		int [] rocks ={8,5,2,7,5,3,2,3,2,7,7,7,1,3,7,3,6,1,1};
		int x = ff.lines(rocks);
		System.out.print(x);

	}

}
