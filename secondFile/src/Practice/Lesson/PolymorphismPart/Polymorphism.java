package Practice.Lesson.PolymorphismPart;

class O {

	public void a (int param) {		//overloading
		System.out.println("�������");
		System.out.println(param);
	}
	
	public void a(String param) {		//overloading
		System.out.println("�������");
		System.out.println(param);
	}
}

//overloading�� ���� polymorphism �� ����

public class Polymorphism {
	public static void main(String[] args) {
		O o = new O();
		o.a(1);
		o.a("one");
	}
}
