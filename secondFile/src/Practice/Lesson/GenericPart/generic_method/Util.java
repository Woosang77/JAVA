package Practice.Lesson.GenericPart.generic_method;

public class Util {
	
//접근제어자, 정적메소드, 메소드에서 사용할 타입, 리턴 타입<리턴 객체에서 가지는 타입>, 메소드명(메소드 파라미터 타입)
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<>();
		box.set(t);
		return box;
	}
		
}
