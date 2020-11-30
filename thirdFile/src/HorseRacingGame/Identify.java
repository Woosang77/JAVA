package HorseRacingGame;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Identify {
	
	private String name;
	private String sex;
	private int year;
	private int month;
	private int day;
	private int pin;

	Calendar now = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) throws SexUnclearException{
		if(sex != "남" || sex != "여") {
			throw new SexUnclearException("성별을 잘못 입력하셨습니다. :" + sex);
		}
		this.sex = sex;
	}

	public int getAge() {
		return year;
	}

	public void setAge(int[] age) throws IllegalAgeException{
		int year = age[0];
		int month = age[1];
		int day = age[2];
		if((now.get(Calendar.YEAR) - year) < 19) {
			throw new IllegalAgeException("만 19세 미만은 이용하실 수 없습니다.");
		}
		if((now.get(Calendar.YEAR) - year) == 19 && (now.get(Calendar.MONTH) + 1) < month) {
			throw new IllegalAgeException("만 19세 미만은 이용하실 수 없습니다.");
		}
	}
	

}
