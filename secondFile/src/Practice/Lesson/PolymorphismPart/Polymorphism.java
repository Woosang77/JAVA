package Practice.Lesson.PolymorphismPart;

class O {

	public void a (int param) {		//overloading
		System.out.println("숫자출력");
		System.out.println(param);
	}
	
	public void a(String param) {		//overloading
		System.out.println("문자출력");
		System.out.println(param);
	}
}

//overloading울 통한 polymorphism 의 예시

public class Polymorphism {
	public static void main(String[] args) {
		O o = new O();
		o.a(1);
		o.a("one");
	}
}
