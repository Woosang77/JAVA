package Practice.Lesson.GenericPart.bounded_type;

public class Util {
	public static <T extends Number> int compare(T t1, T t2) {		//넘버가 오거나 넘버의 자식 클래스가 올 수 있다.
		double v1 = t1.doubleValue();		//t1이 쓸 수 있는 메소드는 Number의 메소드 만이다. 자식객체의 매소드를 부모객체가 가지고 있지 않기 때문이다.
		double v2 = t2.doubleValue();	
		return Double.compare(v1, v2);	//v1이 크면 1, 작으면 -1을 리턴한다.
	}
}
