package Practice.Lesson.GenericPart.bounded_type;

public class Util {
	public static <T extends Number> int compare(T t1, T t2) {		//�ѹ��� ���ų� �ѹ��� �ڽ� Ŭ������ �� �� �ִ�.
		double v1 = t1.doubleValue();		//t1�� �� �� �ִ� �޼ҵ�� Number�� �޼ҵ� ���̴�. �ڽİ�ü�� �żҵ带 �θ�ü�� ������ ���� �ʱ� �����̴�.
		double v2 = t2.doubleValue();	
		return Double.compare(v1, v2);	//v1�� ũ�� 1, ������ -1�� �����Ѵ�.
	}
}
