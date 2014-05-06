package my.codejam.y09.round1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FullHouse {

	public String hand(String[] cards) {
		String result = "NEITHER";
		List<String> hand = new ArrayList<String>();
		for (String e : cards) {
			String[] m = e.split(";");
			hand.add(m[0]);
		}
		Collections.sort(hand);
		
		Map<String, Integer> count = new TreeMap<String,Integer>();
		for(String e:hand){
			if(count.containsKey(e)){
				int v = count.get(e);
				
				++v;
				if(v == 4){
					result = "FOUR_OF_A_KIND";
					return result;
				}
				count.put(e,v);
				}else{
					count.put(e,1);
				}
		}
		if(count.size() == 2){
			return result = "FULL_HOUSE";
		}
		return result;
	}
}