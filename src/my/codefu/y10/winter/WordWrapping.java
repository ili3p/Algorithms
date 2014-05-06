package my.codefu.y10.winter;

public class WordWrapping {
	public static String wordWrap(String text, int width, int rows) {
String s = "d "+text;
		String[] words = s.split(" ");
		StringBuilder out = new StringBuilder();

		for (int ind = 1, row = 1, cur = width; ind < words.length
				&& row <= rows;) {

			String word = words[ind];

			if (word.length() <= cur) {
				if (cur != width) // not first word in row
				{
					out.append(" ");

				}
				out.append(word);
				cur -= word.length() + 1;
				++ind;

			} else if (word.length() <= width) // is needed to be split?
			{
				++row;
				if(row<=rows)
				out.append("|"); // add new line
				else
					break;
				cur = width;
			} else {

				String wPart1 = words[ind].substring(0, width);
				String wPart2 = words[ind]
						.substring(width, words[ind].length());
				words[ind - 1] = wPart1;
				words[ind] = wPart2;
				--ind;
			}

		}
		return new String(out);
	}

	public static void main(String[] args) {
		System.out.println(wordWrap(
				"The quick brown fox jumps over the lazy dog",  2, 4));
	}
}
