/**
 * 
 */
package my.codefu.y10.online2;

/**
 * @author Ilija Ilievski
 * 
 */
public class TextSimulator {

	public static String simulate(String input) {

		StringBuilder print = new StringBuilder();

		int position = 'a';
		int caseDiff = 'a' - 'A';

		char[] chars = input.toCharArray();

		for (int index = 0; index < chars.length; ++index) {

			char currentChar = chars[index];

			switch (currentChar) {

			case '*': {
				char toBePrinted = (char) position;

				print.append(toBePrinted);
				break;
			}
			case '^': {

				int firstLow = 'a';

				if (position >= firstLow) {
					position -= caseDiff;
				} else {
					position += caseDiff;
				}
				break;
			}
			case '=': {

				if (position >= 'a') {
					position = 'a';
				} else {
					position = 'A';
				}
				break;
			}
			case '+': {
				int k = 0;
				char ch;
				StringBuilder num = new StringBuilder();
				while(true){
					++k;
					if(index+k<chars.length){
					ch = chars[index + k];
					if(Character.isDigit(ch)){
						num.append(ch);
					}else{
					break;}
					}else{
						break;
					}
				}

				index +=(k-1);
				
				int offset = Integer.parseInt(String.valueOf(num));
				position += offset;

				char toBePrinted = (char) position;

				print.append(toBePrinted);

				break;
			}

			case '-': {
				int k = 0;
				char ch;
				StringBuilder num = new StringBuilder();
				while(true){
					++k;
					if(index+k<chars.length){
					ch = chars[index + k];
					if(Character.isDigit(ch)){
						num.append(ch);
					}else{
					break;}
					}else{
						break;
					}
				}

				index +=(k-1);
				
				int offset = Integer.parseInt(String.valueOf(num));
				position -= offset;

				char toBePrinted = (char) position;

				print.append(toBePrinted);

				break;
			}
			}
		}
		return new String(print);
	}

	public static void main(String[] args) {
		System.out.println(  simulate("+14^+10-11-10+7^+11-8^-3=^+16-9=") );
	}
}