package Practice.Lesson.PolymorphismPart;

class A {
	public String x() {return "A.x";}
}

class	 B extends A {
	public String x() {return "B.x";}		//Ŭ���� A�� x�� overriding , A.x ���� �켱������ ����
	public String y() {return "y";}
}

class B2 extends A {
	public String x() {return "B2.x";}
}

public class PorlymorphismDemo1 {

	public static void main(String[] args) {
		
		A obj = new B();		// obj�� BŬ������ ������� A�� �༼�� �ϱ⶧���� y�� ������ �ȵǰ� AŬ������ X�� �ȴ�. 
		A obj2 = new B2();
		
		//��Ӱ����� �ν��Ͻ��� ���� �� �ν��Ͻ��� ����Ŭ������ ���� �ְ�, �θ� Ŭ���� �ϼ��� �ִ�.		
		//AŬ������ �༼�� �ϱ� ������ AŬ������ �������̵� �޼ҵ带 ����� �� �ְ�, ���� Ŭ�������� ���Ӱ� ������ �޼ҵ带 ����� �� ����.
		//������, ���� Ŭ�������� Overriding�� �̷�����ٸ�, Overriding �޼ҵ�� ȣ��ȴ�,(�켱������ ����.)
		
		System.out.println(obj.x());			//B.x�� ���� ���� : ���� Ŭ������ �������̵��̰� �켱������ ����. 
	
		System.out.println(obj2.x());
		
		//obj.x();	 ���� �۵�
		// obj.y();  ���� �߻�
	}

}
