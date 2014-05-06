package old.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class broj{
	public int br;
	public int del;
	broj(int b,int d){br=b;del=d;}
	public void deli()
	{
		for(int i=1;i<br+1;++i)
			if(br%i==0)++del;
	}
}
public class DivisorSort {
	public int[] sort(int[] original) {
		List<broj> lis = new ArrayList<broj>();
		
		for(int i:original){
			broj b = new broj(i,0);
			b.deli();
			lis.add(b);
		}
		
		Collections.sort(lis, new Comparator<broj>(){
			public int compare(broj b1, broj b2){
				int m =b2.del - b1.del;
				if(m == 0)m=b1.br - b2.br; 
			return m;
			}
			});
		//broj [] b = new broj[lis.size()];
		
		int [] R = new int[original.length];
		for(int i=0;i<original.length;++i)
			R[i]=lis.get(i).br;
		
		return R;
		}
	
	public static void main(String[] args) {
		DivisorSort d=new DivisorSort();
		int [] original = {2, 3, 4, 5, 6, 12, 120, 991};
		System.out.print(d.sort(original));
	}

}
