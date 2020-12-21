package Practice.Lesson.stream.stream_sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortingExample {
	public static void main(String[] args) {
		IntStream intStream = Arrays.stream(new int[] {5, 3, 2, 1, 4});
		intStream
			.sorted()
			.forEach(n -> System.out.println(n + ","));
		System.out.println();
		
		//객체
		List<Student> studentList = Arrays.asList(
				new Student("홍길동", 30),
				new Student("신용권", 10),
				new Student("유미선", 20)
		);
		
		studentList.stream()
			.sorted()		//기본정렬	(compareTo의 오버라이딩 내용)
			.forEach(s -> System.out.println(s.getScore()));
		System.out.println();
		//		10
		//		20
		//		30
		
		studentList.stream()
		.sorted(Comparator.reverseOrder())		//정반대 정렬
		.forEach(s -> System.out.println(s.getScore()));
	System.out.println();
		//		30
		//		20
		//		10
	}
}
