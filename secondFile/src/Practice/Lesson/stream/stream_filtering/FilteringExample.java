package Practice.Lesson.stream.stream_filtering;

import java.util.Arrays;
import java.util.List;

public class FilteringExample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동", "장우상", "감자바", "장우상" , "감자바", "감우지");
		
		//중복제거
		list.stream()
		.distinct()
		.forEach(n -> System.out.println(n));
		//홍길동
		//장우상
		//감자바
		System.out.println();
		
		//감씨 성 만 출력
		list.stream()
		.filter(n -> n.startsWith("감"))
		.forEach(n -> System.out.println(n));
		//		감자바
		//		감자바
		//		감우지
		System.out.println();
		
		//감씨 중에서 중복제거
		list.stream()
		.filter(n -> n.startsWith("감"))
		.distinct()
		.forEach(n -> System.out.println(n));
		//		감자바
		//		감우지
		
	}

}
