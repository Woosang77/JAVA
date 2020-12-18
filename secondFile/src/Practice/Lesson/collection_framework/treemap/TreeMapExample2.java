package Practice.Lesson.collection_framework.treemap;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample2 {
	public static void main(String[] args) {
		TreeMap<Integer, String> scores = new TreeMap<>();
		scores.put(87, "홍길동");
		scores.put(98, "이동수");
		scores.put(75, "박길순");
		scores.put(95, "신용권");
		scores.put(80, "김자바");
		
		NavigableMap<Integer, String> descendingMap = scores.descendingMap();
		//descendingMap() key를 가지고 내림차순으로 정렬된 NavigableMap을 만든다.
		Set<Map.Entry<Integer, String>> descendingEntrySet = descendingMap.entrySet();
		//Map의 메소드인 .entrySet을 통해 key와 value로 구성된 Map.entry 타입객체들이 Set으로 저장된다.
		for (Map.Entry<Integer, String> entry : descendingEntrySet) {
			System.out.println(entry.getKey() + "  " + entry.getValue());
		}
		//		98  이동수
		//		95  신용권
		//		87  홍길동
		//		80  김자바
		//		75  박길순
	}
}
