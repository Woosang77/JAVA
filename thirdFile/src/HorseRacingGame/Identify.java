package HorseRacingGame;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Identify {
	
	private int money = 1000;
	private String name;
	private String sex;
	private String age;
	private String id;
	private int pin;
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public  String showPin() {
		String strpin = "" + (pin / 1000) + "***";
		return strpin;
	}

	public  int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	
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
	
	public void getAllInfo() {
		System.out.println("조회하신 ID 정보입니다." 
				+ "\n ID : " + getId()
				+ "\n User Name : " + getName()
				+ "\n Age : " + getAge()
				+ "\n Sex : " + getSex()
				+ "\n Money : " + getMoney() + "원");
	}

	public void setAge(String age) throws IllegalAgeException{
		Calendar cal1 = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String temp = age;
		Date birth = null;
		try {
			 birth = sdf.parse(temp);
		} catch (ParseException e) {e.getStackTrace();}
		cal1.setTime(birth);
		int today = Calendar.YEAR;
		now.add(today, -19);
		if (cal1.after(now)) {
			throw new IllegalAgeException(sdf.format(now.getTime())
					+ " 이후 태생인 사용자는 19세 미만이므로 서비스 이용이 불가능 합니다.");
		}
		this.age = age;
	}
	
	//1982-12-02 이후 태생인 사용자는 19세 미만이므로 서비스 이용이 불가능 합니다.
	//날짜의 기준이 19년씩 줄어든것이 복구가 안됨.
	//오류잡기
	//		now.add(Calendar.YEAR, -19); 수정필요
	

}




