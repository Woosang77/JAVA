package kookbi;

public class Students {
	
	private String name;
	private int age;
	private int number;
	private static int Fnum;			//정적변수 static은 동적변수들이 언제든지 초기화가 되더라도 정적변수는 초기화가 되지 않는다.
	
	//기본 생성자
	public Students() {
	}

	public Students(String name, int age) {
		this.name = name;
		this.age = age;
		this.number = ++Fnum;
	}
	
	
	public String getName() {				//getter 와 setter을 사용하는 이유 : 클래스들이 서로 연계되어있을 때 변수를 실수로 초기화 시키는 것과
		return name;							//	 변수의 접근의 암묵적으로 제어하기 위해 사용한다. 다른 사람이 getter 와 setter를 사용하면서 주의하자는 의미이다.
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	void show () {
		System.out.println("번호 : "+ this.number + " 이름 : " + this.name + " 나이 : " + age + "살");
	}
	
	
}
