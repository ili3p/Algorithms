package old.code;

public class ErasedNumber {
	public int findErased(int N, int sum) {
		long sumata;
		int r=0;
		boolean br=false;
		sumata=0;
		for(int j=0;true;++j)
		{
			int f;
			int x=0;
			f=N+j;
			sumata =(long)((f*(f+1))/2 -(j*(j+1))/2);
						
			if(sumata>sum)
			{
			x=0;
			for(int i=j+1;x<N;i++)
				{
					sumata-=i;
					if(sumata == sum)
						{r=i;br=true; break;}
					else 
						sumata+=i;
					++x;
				}
			}
			sumata=0;			
		if(br)break;
		}
	return r;
}
	public static void main(String[] args) {
	ErasedNumber e = new ErasedNumber();
	
	System.out.print(e.         findErased(6, 2000) );

	}

}
