package my.topcoder;


public class TheBlackJackDivTwo {
public int score(String[] cards){
	String face ="TJQK";
	String  num = "23456789";
	int sum = 0;
	for(String card:cards){
		String c = card.substring(0,1);
		if(num.contains(c))sum+=Integer.parseInt(c);
		else if(face.contains(c)) sum+=10;
		else if(c.equalsIgnoreCase("A")) sum+=11;
	}
	return sum;
}

}
