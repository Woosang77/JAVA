package Practice.Lesson.GenericPart.generic_method;

public class Util {
	
//����������, �����޼ҵ�, �޼ҵ忡�� ����� Ÿ��, ���� Ÿ��<���� ��ü���� ������ Ÿ��>, �޼ҵ��(�޼ҵ� �Ķ���� Ÿ��)
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<>();
		box.set(t);
		return box;
	}
		
}
