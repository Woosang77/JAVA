package Practice.Lesson.GenericPart.generic_method2;

public class Util {
	
	
					/*
					 * 이 자리에 <K,V>가 있는 이유는 Pair에서 정확히 어떤 객체가 들어올지 몰라 제네릭을 사용하였기 때문에, 
					 * 메소드를 선언할때 리턴타입앞에 써줘야한다. 
					 * 
					 */
	public static <K,V> boolean compare(Pair<K,V> p1 , Pair<K,V> p2) {
		
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		return keyCompare && valueCompare;
	}
}
