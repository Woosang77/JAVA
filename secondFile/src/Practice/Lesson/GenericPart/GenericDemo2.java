package Practice.Lesson.GenericPart;

abstract class Info {			//�߻�Ŭ����(abstracr)�� �ƴϾ �������̽��� ����ص� �ȴ�.
	public abstract int getlevel();
}
class EmployeeInfos extends Info {		//inplements Info
	public int rank;
	EmployeeInfos(int rank) {
		this.rank = rank;
	}
	public int getlevel( ) {
		return this.rank;
	}
}
class Persons<T extends Info> {		//T�� InfoŬ���� �̰ų�, �� Ŭ������ �ڽĵ鸸 ������ �����Ѵ�.   
	public T info;							//���׸� �ƶ����� extends�� ����� �ǹ̰� �ƴ϶� �θ𰡴��������� ��Ÿ���� �ǹ��̴�. 
	Persons(T info) {							//�׷��Ƿ� �������̽����� implements�� ������ �ȵȴ�.
		this.info = info;
	}
}
public class GenericDemo2 {
	public static void main(String[] args) {
		Persons p1 = new Persons(new EmployeeInfos(1));			//EmployeeInfo�� Info�� �ڽ��̹Ƿ� ����ȴ�.
	// Person<String> p2 = new Person<String>("����");		InfoŬ������ �ڽ��� �ƴϹǷ� ������ �߻��Ѵ�.
	}

}
