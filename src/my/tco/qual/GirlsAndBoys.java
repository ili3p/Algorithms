package my.tco.qual;

public class GirlsAndBoys {
	@SuppressWarnings("unused")
	public int sortThem(String row) {

		char[] students = row.toCharArray();

		int size = students.length;
		char currentChar;
		char prevChar;
		int lastGirl = -1;
		int lastBoy = -1;
		int movesR = 0;
		int movesL = 0;
		int numGirls = 0;

		for (int index = 0; index < size; ++index) {

			currentChar = students[index];

			if (currentChar == 'G') {

				movesL += index - numGirls;
				numGirls++;
			}
		}
		numGirls = 0;
		for (int index = 0; index < size; ++index) {

			currentChar = students[index];

			if (currentChar == 'B') {

				movesR += index - numGirls;
				numGirls++;
			}
		}
		// int prevIndex = index - 1;
		// prevChar = students[index - 1];
		// currentChar = students[index];
		//
		// if (prevChar != currentChar) {
		//
		// int goLeft = Math.abs(prevIndex - lastGirl);
		// int goRight = Math.abs(prevIndex - lastBoy);
		//
		// if (goLeft > goRight) {
		//
		// moves = goRight;
		// --lastBoy;
		// }else{
		// moves = goLeft;
		// ++lastGirl;
		// }
		// }

		return Math.min(movesR, movesL);
	}

}
