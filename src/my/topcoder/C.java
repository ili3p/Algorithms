package my.topcoder;

import java.util.regex.Pattern;

public class C {
	public static  void printIt(String txt){
		Pattern v = Pattern.compile("[\\s]");
		String words [] = v.split(txt);
		for(String e:words)
			System.out.println(e);
	}
	public static void main(String[] args) {
	
		String x = "> This is  a test <";
	fix(x);
	System.out.println(x);

	}
	private static void fix(String x) {
		 String t = x;
		 t = t.trim();
		 t = t.replace(" ", "_");
		 System.out.println(t);
		 x=t;
		
	}
}
