package my.practice.y12;

import java.text.DecimalFormat;
import java.util.Arrays;

public class TimeRiver {
	public String getPercentage(String curDateTime) {
		curDateTime = curDateTime.replace(",", "");
		String[] date = curDateTime.split(" ");
		int month = Arrays.binarySearch(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
				"November", "December" }, date[0]);
		int day = Integer.parseInt(date[1]);
		int year = Integer.parseInt(date[2]);
		int daysInYear = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? 366 : 365;
		int minutesInYear = daysInYear * 60 * 24;
		int daysSoFar = 0;
		for (int i = 0; i <= month; i++) {
			switch (i) {
			case 0:
				daysSoFar += 31;
			case 1:
				daysSoFar += daysInYear == 366 ? 29 : 28;
			case 2:
				daysSoFar += 31;
			case 3:
				daysSoFar += 30;
			case 4:
				daysSoFar += 31;
			case 5:
				daysSoFar += 30;
			case 6:
				daysSoFar += 31;
			case 7:
				daysSoFar += 31;
			case 8:
				daysSoFar += 30;
			case 9:
				daysSoFar += 31;
			case 10:
				daysSoFar += 30;
			case 11:
				daysSoFar += 31;
			}
		}

		double percentage = 10000 * 100 * daysSoFar * 60 * 24 / minutesInYear;

		return new DecimalFormat("0.####").format(Math.round(percentage) / 10000.0);
	}

	public static void main(String[] args) {
		// = "28.3765"
		System.out.println(new TimeRiver().getPercentage("April 14, 1694 13:47"));
	}
}
