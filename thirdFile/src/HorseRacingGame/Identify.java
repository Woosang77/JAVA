package HorseRacingGame;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Identify implements Cloneable{
	
	private int money = 1000;
	private String name;
	private String sex;
	private String age;
	private String id;
	private int pin;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
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
		if(!(sex.equals("��" )|| sex.equals("��"))) {
			throw new SexUnclearException("������ �߸� �Է��ϼ̽��ϴ�. : " + sex);
		}
		this.sex = sex;
		
	}

	public String getAge() {
		return age;
	}
	
	public void getAllInfo() {
		System.out.println(" 1. ID : " + getId()
				+ "\n 2. User Name : " + getName()
				+ "\n 3. Age : " + getAge()
				+ "\n 4. Sex : " + getSex()
				+ "\n 5. Money : " + getMoney() + "��");
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
					+ " ���� �»��� ����ڴ� 19�� �̸��̹Ƿ� ���� �̿��� �Ұ��� �մϴ�.");
		}
		this.age = age;
	}
}




