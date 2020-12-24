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
				new Student("ȫ�浿", 10, Student.Sex.MALE),
				new Student("�����", 6, Student.Sex.FEMALE),
				new Student("����", 10, Student.Sex.MALE),
				new Student("�����", 6, Student.Sex.FEMALE)
			);
		Stream<Student> totalStream = totalList.stream();

		//������ ���� : Student���� getSex�� ���� �������� Ű�� �����Ѵ�.
		Function<Student, Student.Sex> classifier = Student :: getSex;
	
		 Collector<Student, ?, Map<Student.Sex, List<Student>>> collector = Collectors.groupingBy(classifier);
		
		
		//Map���� Student.sex���� Ű�� ����, value�� List<Student>�� ���´�.
		Map<Student.Sex, List<Student>> mapBySex = totalStream.collect(collector);
		
		List<Student> students = mapBySex.get(Student.Sex.MALE);
		System.out.println(students.size());
		System.out.println(students.get(0).getName());
		System.out.println(mapBySex.get(Student.Sex.FEMALE).get(1).getName());
	
	}
}
