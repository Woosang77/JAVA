package Practice.Lesson.ObjectClassPart;

class Student {
	String name;
	Student(String name) {
		this.name = name;
	}
	//오버라이딩을 통한 equals 메소드 재정의
	public boolean  equals(Object obj) {		//오버라이딩 equal()메소드에서 파라미터 값을 받을 때 모든 데이터 타입을 수용할 수 있는 Object를 사용하는 것이다.
		Student _obj = (Student)obj;
		return name == _obj.name;
	}
}

public class ObjectClassDemo2 {
	public static void main(String[] args) {
		//equals()에 최적화 오버라이딩을 제공하는 String의 연산
		String student1 = "우상"; 
		String student2 = "우상";
		System.out.println(student1.equals(student2));		//True
		
		//새로 만든 객체간의 연산
		Student s1 = new Student("장우상");		
		Student s2 = new Student("장우상");
		System.out.println(s1.equals(s2));			//False
		/*
		 * .equals(s2)에서 s2는 오버라이딩을 보면 Object obj = s2가 된다. Student클래스였던 s2를 다형성을 통해 상위클래스인 Object클래스로 변환시켰다.
		 * 하지만 다형성을 통해 Object가 되었으면 하위클래스의 name을 사용하지 못하기때문에 10번줄을 보다시피(Student)를 통해 강제 형변환을 시켜주었다.
		 */
		//기본적으로 equal는 object의 메소드로서 정의된 내용은 ==와 일치하다."객체간 비교연산"이다. 
		//그렇기 때문에 각 객체를 원하는 대로 비교하기 위해서는 오버라이딩을 해야한다. 
		//하지만 equals() 메소드의 제공이유에 걸맞게 String은 equals()를 완벽하게 오버라이딩해서 제공하고 있기 때문에 가능한 것이다.
	}

}
