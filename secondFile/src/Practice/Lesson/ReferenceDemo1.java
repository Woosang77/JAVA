package Practice.Lesson;

class A {
	public int id;
	A (int id) {
		this.id = id;
	}
}


public class ReferenceDemo1 {

	public static void runValue() {
		int a = 1;	//�⺻�� ������Ÿ��			1(�⺻�� ������Ÿ��)�� ����(�ڽ�)a�� ��´�. 
		int b = a;								//		a�� ���� b�� ��� ��ó�� ��������, a�� ����� 1�� �����Ͽ� b�� ��� ���̴�. 
		b = 2;									// 	1�� ����� b������ ���� 2�� �����Ѵ�.
		System.out.println("runValue : " + a);				//	a�� ����ϸ� �翬�� 1�� ���´�.
	}
	
	public static void runReference() {
		A a = new A(1);		//������ ������Ÿ��		A�ν��Ͻ��� ������ ����(�ּ�)���� a������ ��´�.
		A b = a;										// 	b = a�� a�� ������ �ּҰ��� b�� ��Ƽ� b ���� ���� �ν��Ͻ��� �ּҰ��� ����Ų��.
		b.id = 2;									//		A�ν��Ͻ��� id�� 2�� �����Ѵ�.
		System.out.println("runReference : " + a.id);			//a.id�� ȣ���ϴ� ���� A�ν��Ͻ��� id(2)�� ȣ���ϴ� ���̱� ������ 2�� ���´�.
	}
	
	public static void main(String[] args) {	
		runValue();					//��� : runValue : 1				�⺻���� ���纻���� ����
		runReference();				// ��� : runReference : 2		�������� �ٷΰ��� ���� ����
										//�������� �⺻���� ���� ��� ��ĺ��� �ٸ��� ������ ������ ���� ���� ���̳���.
	}

}
