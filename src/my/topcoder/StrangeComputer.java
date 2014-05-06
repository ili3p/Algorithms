package my.topcoder;


public class StrangeComputer {
	public int setMemory(String mem) {

		int changes = 0;
		char x = '0';
		for (int i = 0; i < mem.length(); ++i) {

			if (x != mem.charAt(i)) {

				++changes;
				x = mem.charAt(i);
			}
		}
		return changes;
	}
}
