package Practice.Lesson.stream.understand;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Practice.Lesson.stream.understand.Student.City;
import Practice.Lesson.stream.understand.Student.Sex;

public class StreamUnderstand4 {

	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("����", 80, Sex.MALE, City.Seoul),
				new Student("�ֿ��", 95, Sex.FEMALE, City.Pusan),
				new Student("�����", 70, Sex.MALE, City.Pusan),
				new Student("����", 60, Sex.FEMALE, City.Seoul)
		);
		
		//���� Ű�� , �л� ����������� ���
		
		//����
		Stream<Student> mainStream = studentList.stream();	//���� ��Ʈ�� �����
		Function<Student, Student.Sex> function = Student :: getSex;	//ū ���б��� �����
		
		//ū ���б������� ���е� ��ҵ鿡�� ���ϴ� �κ� �߷�����
		//�߷����� ����
		ToDoubleFunction<Student> doubleFunction = Student :: getScore;
		//���� StudentŸ�Կ�Ҵ� doubleFunction�� �������� �߷����� .averagingDouble�޼ҵ带 ���� DoubleŸ������ ����
		Collector<Student, ?, Double> collector = Collectors.averagingDouble(doubleFunction);
		
		Collector<Student, ?, Map<Student.Sex, Double>> collector2 = Collectors.groupingBy(function, collector);
		Map<Student.Sex, Double> mapBySex = mainStream.collect(collector2);
		
		//����ȭ
//		Map<Student.Sex, Double> map = studentList.stream()
//				.collect(
//					Collectors.groupingBy(
//						Student :: getSex,
//						Collectors.averagingDouble(
//						Student :: getScore)
//					)
//				);
		
		//���� Ű��, ��ǥ�� ���е� �л� �̸� ���ڿ��� ������ ���� Map
		
		//����
		Stream<Student> fullStream = studentList.stream();
		
		Function<Student, Student.Sex> classifier = s -> s.getSex();
		
		Function<Student, String> mapper = s -> s.getName();
		Collector<CharSequence, ?, String> join = Collectors.joining(",");
		Collector<Student, ?, String> collector3 = Collectors.mapping(mapper, join);
		
		Collector<Student, ?, Map<Student.Sex, String>> collector4 = Collectors.groupingBy(classifier, collector3);
		
		Map<Student.Sex, String> finalCollector = fullStream.collect(collector4);
	
		//����ȭ
//		Map<Student.Sex, String> mapByName = studentList.stream()
//			.collect(
//				Collectors.groupingBy(
//					Student :: getSex, 
//					Collectors.mapping(
//						Student :: getName, 
//						Collectors.joining(",")
//					)
//				)
//			);
			
				
				
	}

}
