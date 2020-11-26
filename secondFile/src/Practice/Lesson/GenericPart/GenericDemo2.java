package Practice.Lesson.GenericPart;

abstract class Info {			//추상클래스(abstracr)가 아니어도 인터페이스를 사용해도 된다.
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
class Persons<T extends Info> {		//T가 Info클래스 이거나, 그 클래스의 자식들만 오도록 강제한다.   
	public T info;							//제네릭 맥락에서 extends는 상속의 의미가 아니라 부모가누구인지를 나타내는 의미이다. 
	Persons(T info) {							//그러므로 인터페이스여도 implements가 들어오면 안된다.
		this.info = info;
	}
}
public class GenericDemo2 {
	public static void main(String[] args) {
		Persons p1 = new Persons(new EmployeeInfos(1));			//EmployeeInfo는 Info의 자식이므로 통과된다.
	// Person<String> p2 = new Person<String>("부장");		Info클래스의 자식이 아니므로 에러가 발생한다.
	}

}
