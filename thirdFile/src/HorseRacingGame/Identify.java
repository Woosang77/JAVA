package HorseRacingGame;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Identify {
	
	private String name;
	private String sex;
	private int year;
	
	Calendar cal1 = Calendar.getInstance();
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
		if(sex != "남" && sex != "여") {
			throw new SexUnclearException("성별을 잘못 입력하셨습니다. :" + sex);
		}
		this.sex = sex;
	}

	public int getAge() {
		return year;
	}

	public void setAge(String age) throws IllegalAgeException{
		
		Date birth = null;
		try {
			 birth = sdf.parse(age);
		} catch (ParseException e) {e.getStackTrace();}
		cal1.setTime(birth);
		now.add(Calendar.YEAR, -19);
		if (cal1.after(now)) {
			throw new IllegalAgeException("만 19세 미만은 사용하실 수 없습니다.");
		}
		
	}
	

}
