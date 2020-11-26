package Practice.Lesson.ObjectClassPart;

class Student {
	String name;
	Student(String name) {
		this.name = name;
	}
	//�������̵��� ���� equals �޼ҵ� ������
	public boolean  equals(Object obj) {		//�������̵� equal()�޼ҵ忡�� �Ķ���� ���� ���� �� ��� ������ Ÿ���� ������ �� �ִ� Object�� ����ϴ� ���̴�.
		Student _obj = (Student)obj;
		return name == _obj.name;
	}
}

public class ObjectClassDemo2 {
	public static void main(String[] args) {
		//equals()�� ����ȭ �������̵��� �����ϴ� String�� ����
		String student1 = "���"; 
		String student2 = "���";
		System.out.println(student1.equals(student2));		//True
		
		//���� ���� ��ü���� ����
		Student s1 = new Student("����");		
		Student s2 = new Student("����");
		System.out.println(s1.equals(s2));			//False
		/*
		 * .equals(s2)���� s2�� �������̵��� ���� Object obj = s2�� �ȴ�. StudentŬ�������� s2�� �������� ���� ����Ŭ������ ObjectŬ������ ��ȯ���״�.
		 * ������ �������� ���� Object�� �Ǿ����� ����Ŭ������ name�� ������� ���ϱ⶧���� 10������ ���ٽ���(Student)�� ���� ���� ����ȯ�� �����־���.
		 */
		//�⺻������ equal�� object�� �޼ҵ�μ� ���ǵ� ������ ==�� ��ġ�ϴ�."��ü�� �񱳿���"�̴�. 
		//�׷��� ������ �� ��ü�� ���ϴ� ��� ���ϱ� ���ؼ��� �������̵��� �ؾ��Ѵ�. 
		//������ equals() �޼ҵ��� ���������� �ɸ°� String�� equals()�� �Ϻ��ϰ� �������̵��ؼ� �����ϰ� �ֱ� ������ ������ ���̴�.
	}

}
