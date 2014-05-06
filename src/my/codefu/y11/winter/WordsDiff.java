package my.codefu.y11.winter;

public class WordsDiff {
	public static String getDiff(String first, String second) {

		StringBuilder result = new StringBuilder(100);
		boolean f = false;

		for (char cfirst : first.toCharArray()) {
			f = true;
			for (char csecond : second.toCharArray()) {
				if (cfirst == csecond) {
					f = false;
					break;
				}
			}
			if (f)
				result.append(cfirst);
		}

		for (char cfirst : second.toCharArray()) {
			f = true;
			for (char csecond : first.toCharArray()) {
				if (cfirst == csecond) {
					f = false;
					break;
				}
			}
			if (f)
				result.append(cfirst);
		}
		return new String(result);
	}

	public static void main(String[] args) {
		System.out.println(getDiff("something", "else"));
		System.out.println(getDiff("hello", "hi"));
	}
}