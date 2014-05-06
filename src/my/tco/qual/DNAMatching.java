package my.tco.qual;
import java.util.ArrayList;
import java.util.List;

public class DNAMatching {

	public int getMaxSize(String[] dna) {

		List<String> dnas = new ArrayList<String>();

		for (String string : dna) {
			dnas.add(string);
		}
		int count = 0;
		for (String element : dna) {
			String opp = getOpp(element);
			if(!element.equalsIgnoreCase(opp))dnas.remove(opp);
			if (dnas.contains(element)) {
				count++;
			}
		}
		
		return count;
	}

	/**
	 * @param element
	 * @return
	 */
	private String getOpp(String element) {

		StringBuilder sb = new StringBuilder(element);

		sb = sb.reverse();
		StringBuilder ss = new StringBuilder();
		for (int index = 0; index < sb.length(); ++index) {
			char c = sb.charAt(index);
			if (c == 'A') {
				ss.append('T');
			} else if (c == 'T') {
				ss.append('A');
			}else if(c== 'C'){
				ss.append('G');
			}else if(c== 'G'){
				ss.append('C');
			}else{
				ss.append(c);
			}

		}
		String opp = new String(ss);
		return opp;
	}
	public static void main(String[] args) {
		 String[] dna = new String[]{"ATTA", "ATCG", "CGAT", "ATCGCGAT", "CCCGGG"};
		 DNAMatching solution = new DNAMatching();
		 System.out.println(solution.getMaxSize(dna));
	}
}
