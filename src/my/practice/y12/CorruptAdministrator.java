package my.practice.y12;

public class CorruptAdministrator {
	public String getNewSchedule(String schedule, int[] choices) {

		String res = "";
		for (int i = 0; i < choices.length; i++) {
			res = res.substring(0, choices[i]) + schedule.charAt(i) + res.substring(choices[i]);

		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(new CorruptAdministrator().getNewSchedule("LM", new int[] { 0, 1 }));
	}
}