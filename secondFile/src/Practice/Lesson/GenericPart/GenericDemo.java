package Practice.Lesson.GenericPart;
class EmployeeInfo {
	public int rank;
	EmployeeInfo(int rank) {this.rank = rank;}
}
class Person <T, S> {
	public T info;
	public S id;
	Person(T info, S id) {
		this.info = info;
		this.id = id;
	}
	public <U> void printInfo (U info) {
		System.out.println(info);
	}
	//���׸��� �޼ҵ忡���� ����� �� �ְ� ���� ���� �޼ҵ��� �Ķ���͸� ������ �� �ִ�.
}
public class GenericDemo {
	public static void main(String[] args) {
		EmployeeInfo e = new EmployeeInfo(1);
		Integer i = new Integer(1);
		//	Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(e, i);
		//	�ڹٿ����� �������� �Ű������� ���� 	���������� ����ϴ� ������Ÿ���� ������� �ʾƵ� Ȯ���� �� �ִ�.																											
		Person p1 = new Person(e, i);	
	//���׸� �޼ҵ带 ����� ���� p1.<EmployeeInfo>printInfo(e);�� ���� ���׸��� ������� �ʾƵ� �ȴ�.
		p1.printInfo(e);
	//	Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(new EmployeeInfo(1), id);		---->   �Ķ���� new EmployeeInfo(1)�� person�� this.info�� Ÿ���� EmployeeInfo�̴ϱ�  EmployeeInfo info = new EmployeeInfo(1)�� ���� ������ �ȴ�.
	}
}
