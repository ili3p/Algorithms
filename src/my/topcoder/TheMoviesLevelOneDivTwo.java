package my.topcoder;
import java.util.*;

public class TheMoviesLevelOneDivTwo {

	static class Seat {
		int row;
		int seat;

		public Seat(int r, int s) {
			row = r;
			seat = s;
		}

		@Override
		public boolean equals(Object obj) {
			Seat s = (Seat) obj;
			return row == s.row && seat == s.seat;
		}

		@Override
		public int hashCode() {
			return this.toString().hashCode();
		}
		
		@Override
		public String toString() {

			return "Seat: " + row + "," + seat;
		}
	}

	public int find(int n, int m, int[] row, int[] seat) {

		Set<Seat> set = new HashSet<Seat>();

		for (int i = 0; i < seat.length; i++) {
			set.add(new Seat(row[i], seat[i]));

		}
		int c = 0;
		for (int i = 1; i <= n; ++i) {
			for (int j = 2; j <= m; ++j) {
				System.out.println("Seat: " + i + "," + j);
				Seat leftSeat = new Seat(i, j - 1);
				Seat rightSeat = new Seat(i, j);
				if ((!set.contains(leftSeat)) && (!set.contains(rightSeat))) {
					++c;
				}
			}
		}

		return c;
	}
}
