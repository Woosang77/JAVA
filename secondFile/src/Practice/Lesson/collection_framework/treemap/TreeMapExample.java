package Practice.Lesson.collection_framework.treemap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
	public static void main(String[] args) {
		TreeMap<Integer, String> scores = new TreeMap<>();
		//TreeMap은 키 값의 대소 비교를 통해 노드객체를 배치한다.
		//메소드 자체에 대한 사용법이나 설명은 TreeSet과 동일하다.
		scores.put(87, "홍길동");
		scores.put(98, "이동수");
		scores.put(75, "박길순");
		scores.put(95, "신용권");
		scores.put(80, "김자바");
		
		Map.Entry<Integer, String> entry = null;
		
		entry = scores.firstEntry();
		System.out.println(entry.getKey() + " " + entry.getValue());	//		75 박길순
		
		entry = scores.lastEntry();
		System.out.println(entry.getKey() + " " + entry.getValue());	//		98 이동수
		
		entry = scores.lowerEntry(95);
		System.out.println(entry + " ");	// 87=홍길동 
		
		entry = scores.higherEntry(95);
		System.out.println(entry + " ");	// 98=이동수 
		
		entry = scores.floorEntry(95);
		System.out.println(entry + " ");	// 95=신용권
		
		entry = scores.ceilingEntry(95);
		System.out.println(entry + " ");	// 95=신용권  
		
		
		while (!scores.isEmpty()) {
			entry = scores.pollFirstEntry();
			System.out.println(entry.getKey() + "  " + entry.getValue() + "  " + scores.size());
			//			75  박길순  4
			//			80  김자바  3
			//			87  홍길동  2
			//			95  신용권  1
			//			98  이동수  0
		}
	}
}
