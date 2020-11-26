package Practice.Lesson.PolymorphismPart;

class A {
	public String x() {return "A.x";}
}

class	 B extends A {
	public String x() {return "B.x";}		//클래스 A의 x를 overriding , A.x 보다 우선순위가 높음
	public String y() {return "y";}
}

class B2 extends A {
	public String x() {return "B2.x";}
}

public class PorlymorphismDemo1 {

	public static void main(String[] args) {
		
		A obj = new B();		// obj에 B클래스를 담았지만 A의 행세를 하기때문에 y는 실행이 안되고 A클래스의 X는 된다. 
		A obj2 = new B2();
		
		//상속관계의 인스턴스를 만들 때 인스턴스는 하위클래스일 수도 있고, 부모 클래스 일수도 있다.		
		//A클래스의 행세를 하기 때문에 A클래스의 오버라이딩 메소드를 사용할 수 있고, 하위 클래스에서 새롭게 생성한 메소드를 사용할 수 없다.
		//하지만, 하위 클래스에서 Overriding이 이루어졌다면, Overriding 메소드로 호출된다,(우선순위가 높다.)
		
		System.out.println(obj.x());			//B.x가 나온 이유 : 하위 클래스의 오버라이딩이고 우선순위가 높다. 
	
		System.out.println(obj2.x());
		
		//obj.x();	 정상 작동
		// obj.y();  오류 발생
	}

}
