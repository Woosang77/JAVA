package Practice.Lesson.stream.understand;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Practice.Lesson.stream.stream_collect.Student;

public class StreamUnderstand2 {
	public static void main(String[] args) {
		List<Student> totalList = Arrays.asList(
				new Student("홍길동", 10, Student.Sex.MALE),
				new Student("김수애", 6, Student.Sex.FEMALE),
				new Student("장우상", 10, Student.Sex.MALE),
				new Student("김수희", 6, Student.Sex.FEMALE)
			);
		Stream<Student> totalStream = totalList.stream();

		//구분자 생성 : Student에서 getSex의 값을 기준으로 키를 구성한다.
		Function<Student, Student.Sex> classifier = Student :: getSex;
	
		 Collector<Student, ?, Map<Student.Sex, List<Student>>> collector = Collectors.groupingBy(classifier);
		
		
		//Map인테 Student.sex으로 키를 갖고, value로 List<Student>를 갖는다.
		Map<Student.Sex, List<Student>> mapBySex = totalStream.collect(collector);
		
		List<Student> students = mapBySex.get(Student.Sex.MALE);
		System.out.println(students.size());
		System.out.println(students.get(0).getName());
		System.out.println(mapBySex.get(Student.Sex.FEMALE).get(1).getName());
	
	}
}
