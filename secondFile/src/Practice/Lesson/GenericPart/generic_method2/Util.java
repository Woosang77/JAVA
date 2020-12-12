package Practice.Lesson.GenericPart.generic_method2;

public class Util {
	
	
					/*
					 * �� �ڸ��� <K,V>�� �ִ� ������ Pair���� ��Ȯ�� � ��ü�� ������ ���� ���׸��� ����Ͽ��� ������, 
					 * �޼ҵ带 �����Ҷ� ����Ÿ�Ծտ� ������Ѵ�. 
					 * 
					 */
	public static <K,V> boolean compare(Pair<K,V> p1 , Pair<K,V> p2) {
		
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		return keyCompare && valueCompare;
	}
}
