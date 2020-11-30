package HorseRacingGame;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Identify {
	
	private String name;
	private String sex;
	private String age;
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
		if(!(sex.equals("남" )|| sex.equals("여"))) {
			throw new SexUnclearException("성별을 잘못 입력하셨습니다. : " + sex);
		}
		this.sex = sex;
		
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) throws IllegalAgeException{
		String temp = age;
		Date birth = null;
		try {
			 birth = sdf.parse(temp);
		} catch (ParseException e) {e.getStackTrace();}
		cal1.setTime(birth);
		now.add(Calendar.YEAR, -19);
		if (cal1.after(now)) {
			throw new IllegalAgeException(sdf.format(now.getTime())
					+ " 이후 태생인 사용자는 19세 미만이므로 서비스 이용이 불가능 합니다.");
		}
		this.age = age;
	}

}

class Pin {
	private int pin;

	public Pin(int pin) {
		this.pin = pin;
	}
	
	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
}
