package Practice.Lesson.ObjectClassPart;

class ToStringLesson{	// extends Object 
	int a, b;
	public void one(int a, int b) {
		this.a = a;
		this.b = b;
	}
	//ObjectŬ������ toString�޼ҵ忡 ���� �������̵�
	public String toString() {
		return "left : " + this.a + " , " + "right : " + this.b;
	}
}

public class ObjectClassDemo {
	public static void main(String[] args) {
		ToStringLesson biga = new ToStringLesson();
		biga.one(10, 20);
		System.out.println(biga);		//�������̵� ���� : Practice.Lesson.ToStringLesson@7852e922		/	�������̵� ���� : left : 10 , right : 20
		System.out.println(biga.toString());		//�������̵� ���� : Practice.Lesson.ToStringLesson@7852e	922		/	�������̵� ���� : left : 10 , right : 20
		
		//�츮�� �ν��Ͻ��� System.out.println�� ���ڷ� �����ϸ�, toString�� ��������� ȣ������ �������� �ұ��ϰ� toString�� ���� ���� ���´�.	
		//���� toString�޼ҵ��� Ŭ������ Object���� �ش� ������� �����ϴ� ���ε� 
		//��� Ŭ�������� ������� �ʴ��� extends Object�� �����ϱ� ������ �������̵��� �Ͽ� �츮�� ���ϴ� ������ ȣ�Ⱚ�� �ٲܼ� �ִ�.		(12 ~14���� �ָ�)
		//�⺻������ �����ϴ� (String �̸� = "����")���� ������ �ν��Ͻ��� �ƴ� �̻� �������̵��� ���� ����������
	}

}
