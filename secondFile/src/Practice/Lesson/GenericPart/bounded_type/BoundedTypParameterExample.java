package Practice.Lesson.GenericPart.bounded_type;

public class BoundedTypParameterExample {

	public static void main(String[] args) {
		//int result1 = Util.compare("A", "B");  //Number의 자식클래스가 아니므로 오류가 발생
		int result1 = Util.compare(10,20); 
		System.out.println(result1);
		
		
		int result2 = Util.compare(4.5, 3); //double이던 int건 상관없이 Number타입의 자식이면 다 가능
		System.out.println(result2);
	}

}
