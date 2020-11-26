package Practice.Lesson.ObjectClassPart;

class ToStringLesson{	// extends Object 
	int a, b;
	public void one(int a, int b) {
		this.a = a;
		this.b = b;
	}
	//Object클래스의 toString메소드에 대한 오버라이딩
	public String toString() {
		return "left : " + this.a + " , " + "right : " + this.b;
	}
}

public class ObjectClassDemo {
	public static void main(String[] args) {
		ToStringLesson biga = new ToStringLesson();
		biga.one(10, 20);
		System.out.println(biga);		//오버라이딩 이전 : Practice.Lesson.ToStringLesson@7852e922		/	오버라이딩 이후 : left : 10 , right : 20
		System.out.println(biga.toString());		//오버라이딩 이전 : Practice.Lesson.ToStringLesson@7852e	922		/	오버라이딩 이후 : left : 10 , right : 20
		
		//우리가 인스턴스를 System.out.println의 인자로 전달하면, toString을 명시적으로 호출하지 않음에도 불구하고 toString과 같은 값이 나온다.	
		//현재 toString메소드의 클래스인 Object에서 해당 결과들을 정의하는 것인데 
		//모든 클래스들은 명시하지 않더라도 extends Object를 포함하기 때문에 오버라이딩을 하여 우리가 원하는 값으로 호출값을 바꿀수 있다.		(12 ~14번줄 주목)
		//기본적으로 제공하는 (String 이름 = "내용")으로 정의한 인스턴스가 아닌 이상 오버라이딩을 통해 재정의하자
	}

}
