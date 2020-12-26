package Practice.Lesson.stream.understand;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Practice.Lesson.stream.understand.Student.City;
import Practice.Lesson.stream.understand.Student.Sex;

public class StreamUnderstand3 {

	public static void main(String[] args) {
		//컬렉션
		List<Student> studentList = Arrays.asList(
				new Student("장우상", 80, Sex.MALE, City.Seoul),
				new Student("최우상", 95, Sex.FEMALE, City.Pusan),
				new Student("정우상", 70, Sex.MALE, City.Pusan),
				new Student("김우상", 60, Sex.FEMALE, City.Seoul)
		);
		//오리지널 스트림
		Stream<Student> totalStream = studentList.stream(); 	//Student타입 요소가 이동하는 totalStream
//		Function<Student, Student.City> classifier = s -> s.getCity();
//		
//		Function<Student, String> mapper = s -> s.getName();
//		Collector<String, ?, List<String>> downstream = Collectors.toList();
//		Collector<Student, ?, List<String>> collector = Collectors.mapping(mapper, downstream);
//		
//		Collector<Student, ?, Map<Student.City, List<String>>> collector2 = Collectors.groupingBy(classifier, collector);
//		
//		Map<Student.City, List<String>> mapByCity = totalStream.collect(collector2);
		
		//간소화
		Map<Student.City, List<String>> mapByCity = totalStream
				.collect(Collectors.groupingBy(Student :: getCity, 
						Collectors.mapping(Student :: getName, Collectors.toList())));
	}

}
