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
	//제네릭은 메소드에서도 사용할 수 있고 위와 같이 메소드의 파라미터를 정의할 수 있다.
}
public class GenericDemo {
	public static void main(String[] args) {
		EmployeeInfo e = new EmployeeInfo(1);
		Integer i = new Integer(1);
		//	Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(e, i);
		//	자바에서는 생성자의 매개변수를 통해 	내부적으로 사용하는 데이터타입을 명시하지 않아도 확인할 수 있다.																											
		Person p1 = new Person(e, i);	
	//제네릭 메소드를 사용할 때도 p1.<EmployeeInfo>printInfo(e);와 같이 제네릭을 명시하지 않아도 된다.
		p1.printInfo(e);
	//	Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(new EmployeeInfo(1), id);		---->   파라미터 new EmployeeInfo(1)는 person의 this.info의 타입이 EmployeeInfo이니까  EmployeeInfo info = new EmployeeInfo(1)와 같은 내용이 된다.
	}
}
