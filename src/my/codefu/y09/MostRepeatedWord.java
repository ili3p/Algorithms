package my.codefu.y09;
import java.util.ArrayList;


public class MostRepeatedWord {
	
	public static String mostRepeated(String sentence)
	{
		sentence = sentence.toLowerCase();
		String [] words = sentence.split(" ");
		ArrayList<String> m = new ArrayList<String>();
		int [] num = new int[words.length];
		int max=0;
		int m1=0;
		for(int i=0; i< words.length;++i ){
			int x = 0;
			if((x=m.indexOf(words[i]))>-1){
				++num[x];
				if(num[x]>max){
					max = num[x];
					m1=i;
				}else if(num[x] == max){
					if(words[x].compareToIgnoreCase(words[max]) < 0){max = num[x];m1=i;}
				}
			}else
			{
				m.add(words[i]);
				if(num[i] == max){
					if(words[i].compareToIgnoreCase(words[max]) < 0){max = num[i];m1=i;}
				}
			}
		}
		
		return words[m1];
	}
		
	
	public static void main(String[] args) {
		System.out.println(mostRepeated("a a a a a a a a a a b b b b b b b b b b c c c c c c c c c c c b"));
	}

}
