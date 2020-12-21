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
		
		//��ü
		List<Student> studentList = Arrays.asList(
				new Student("ȫ�浿", 30),
				new Student("�ſ��", 10),
				new Student("���̼�", 20)
		);
		
		studentList.stream()
			.sorted()		//�⺻����	(compareTo�� �������̵� ����)
			.forEach(s -> System.out.println(s.getScore()));
		System.out.println();
		//		10
		//		20
		//		30
		
		studentList.stream()
		.sorted(Comparator.reverseOrder())		//���ݴ� ����
		.forEach(s -> System.out.println(s.getScore()));
	System.out.println();
		//		30
		//		20
		//		10
	}
}
