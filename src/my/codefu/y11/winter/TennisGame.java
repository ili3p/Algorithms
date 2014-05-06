package my.codefu.y11.winter;

public class TennisGame {
	public static String finalScore(String points) {

		int p1PTS = 0, p2PTS = 0, p1GAM = 0, p2GAM = 0;
		StringBuilder result = new StringBuilder(12);
		boolean add = false;
		for (char point : points.toCharArray()) {
			if (point == '1') {
				++p1PTS;
			} else {
				++p2PTS;
			}
			if (p1PTS > 3 && p1PTS > p2PTS + 1) {
				++p1GAM;
				p1PTS = 0;
				p2PTS = 0;
			}
			if (p2PTS > 3 && p2PTS > p1PTS + 1) {
				++p2GAM;
				p1PTS = 0;
				p2PTS = 0;
			}
			if ((p1GAM > 5 & p1GAM > p2GAM + 1) || (p2GAM > 5 & p2GAM > p1GAM + 1)) {
				if (add) {
					result.append("-");
				}
				result.append(p1GAM + ":" + p2GAM);
				add = true;
				p1GAM = 0;
				p2GAM = 0;
			}
		}
		return new String(result);
	}

	public static void main(String[] args) {
		System.out.println(finalScore("111111111111111111111111111111111111111111111111"));
	}
}
