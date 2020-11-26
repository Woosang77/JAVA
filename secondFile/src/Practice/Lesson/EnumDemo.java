package Practice.Lesson;
//열거형(enum)은 연관되어 있는 상수의 집합 (사실상 클래스) --- 생성자, 필드, 메소드를 저장할 수 있다.
public class EnumDemo {
/*	
class Fruit	{
	public static final Fruit APPLE = new Fruit(); 		데이터 타입은 Fruit으로 같지만 세 가지 과일을 각자 다른 값을 가지고 있다.
	public static final Fruit PEACH	= new Fruit();
	public static final Fruit BANANA = new Fruit();
}
*/		
	//위아래 클래스와 이넘은 서로 일치한다.
	
enum Fruit {				//
	APPLE("red"), PEACH("pink"), BANANA("yellow");	//		(  "매개변수"  )
	private	String color;
	
	public String getColor() {
		return this.color;
	}
	
	Fruit(String color) {
		System.out.println("Call Constructor" + this);
		this.color = color;
	}
	
}
/*													Call Constructor
		각각의 맴버를 단순히 실행결과		Call Constructor		-----이 뜻은 switch문에서 각각의 케이스를 하나씩 실행하면서 과일을 호출할 때 새로운 객체를 만들기 위한 생성자가 실행된다는 것이다.
													Call Constructor
													57kcal	
*/

enum Company {				//
	GOOGLE, APPLE, ORACLE
}
	
	public static void main(String[] args) {
		Fruit type = Fruit.APPLE;
		switch (type) {
		case APPLE:
			System.out.println(57 + "kcal, color " + Fruit.APPLE.getColor());
			break;
		case PEACH:
			System.out.println(34 + "kcal, color " + Fruit.PEACH.getColor());
			break;
		case BANANA:
			System.out.println(93 + "kcal, color " + Fruit.BANANA.getColor());
			break;
		}
		
		
		for (Fruit f : Fruit.values()) {		//열거형(enum)은 열거형이 가지고 있는 필드들을 values()를 사용해서 모두 확인할 수 있다.
			System.out.println(f);
		}
	}

}
