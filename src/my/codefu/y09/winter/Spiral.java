package my.codefu.y09.winter;

public class Spiral {
	public static int getKthNumber(int N, int K, String direction) {
		
		int r;
		if(direction.equalsIgnoreCase("ABOVE")){
			r=1;
		}else if(direction.equalsIgnoreCase("RIGHT")){
			r=7;
		}else if(direction.equalsIgnoreCase("BELOW")){
			r=5;
		}else{
			r=3;
		}
		int [] a= new int[K+1];
		a[0]=1;
		
		for(int i=1;i<=K;++i){
			a[i]=(a[i-1]%N) + (8*i%N)-r;
		}
		
	    return a[K]%N;
	  }
	public static void main(String[] args) {
		 System.out.println(getKthNumber(23456, 178754, "BELOW"));
	}
}
