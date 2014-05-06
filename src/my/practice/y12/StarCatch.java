package my.practice.y12;
import java.util.Scanner;

public class StarCatch {
	public int numberOfPoints(String moves) {
		Scanner s = new Scanner(moves);
		String lastStr = "";
		int same = 1;
		int sum = 0;
		while (s.hasNext()) {
			String str = s.next();
			if (str.equals("REDSTAR") || str.equals("BLUESTAR")) {
				if (str.equals(lastStr)) {
					++same;
				} else {
					same = 1;
				}
				lastStr = str;
			} else if (lastStr.equals("REDSTAR") || lastStr.equals("BLUESTAR")) {
				sum += Integer.parseInt(str) * same;
			}
			System.out.println(str);

		}

		return sum;
	}

	public static void main(String[] args) {
		// System.out.println(new
		// StarCatch().numberOfPoints("33 REDSTAR 45 BLUESTAR 46 REDSTAR BLUESTAR 5 21 4 REDSTAR 40 REDSTAR BLUESTAR REDSTAR BLUESTAR REDSTAR 68 REDSTAR REDSTAR"));
		// System.out.println(new
		// StarCatch().numberOfPoints("33 BLUESTAR BLUESTAR 83 5 BLUESTAR BLUESTAR"));
		System.out
				.println(new StarCatch()
						.numberOfPoints("BLUESTAR REDSTAR BLUESTAR BLUESTAR BLUESTAR 68 REDSTAR REDSTAR REDSTAR 35 REDSTAR 28 50 BLUESTAR 37 BLUESTAR REDSTAR BLUESTAR REDSTAR REDSTAR REDSTAR REDSTAR REDSTAR 9 REDSTAR BLUESTAR REDSTAR 96 BLUESTAR REDSTAR REDSTAR REDSTAR BLUESTAR BLUESTAR REDSTAR REDSTAR BLUESTAR BLUESTAR 15 BLUESTAR 3 BLUESTAR REDSTAR BLUESTAR REDSTAR BLUESTAR REDSTAR 96 BLUESTAR BLUESTAR"));
	}
}
