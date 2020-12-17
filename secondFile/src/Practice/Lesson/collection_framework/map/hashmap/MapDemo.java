package Practice.Lesson.collection_framework.map.hashmap;

import java.util.*;

public class MapDemo {

	public static void main(String[] args) {
		HashMap<String, Integer> a = new HashMap<>(); 	//List와 Set과 달리 제네릭이 두개이다.(key, value)
		
		a.put("one", 1);		//put은 map에서만 사용가능(파라미터는 두개/key, value)
		a.put("two", 2);
		a.put("three", 3);
		a.put("four", 4);
		
		System.out.println(a.get("one"));		//get은 key값을 통해 value를 가져온다.
		System.out.println(a.get("two"));
		System.out.println(a.get("three"));
		
		iteratorUsingForEach(a);
	}
	
	static void iteratorUsingForEach(HashMap map) {
		Set<Map.Entry<String, Integer>> entries = map.entrySet();		//map 인터페이스에는.entrySet()이 저장되어있는데, Set데이터타입 
		for (Map.Entry<String, Integer> entry : entries	 ) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}		//iteratorUsingForEach(a); 의 원리 설명 : HashMap타입의 a를 map의 파라미터로 넣고 
			//.entrySet메소드를 통해 key와 value로 구성된 엔트리들을 Map의 인터페이스인 Entry타입이고, key와 value를
			// String과 Integer로 제한하는 entries라는 이름의 집합(Set)에 담는다.
			//for문을 통해 Map.Entry<String, Integer>조건의 엔트리들을 entries에서 하나씩 꺼내어 entry에 담고 실행한다.
}
