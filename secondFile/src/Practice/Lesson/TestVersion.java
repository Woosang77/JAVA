package Practice.Lesson;

import java.util.Calendar;

public class TestVersion {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		int week = now.get(Calendar.DAY_OF_WEEK);
		System.out.println(week);
		System.out.println(Calendar.SUNDAY);
		/*String strweek = null;
		switch (week) {
		case Calendar.MONDAY:
			
			break;

		default:
			break;
		}*/
	}
}
