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
				new Student("장우상", 80, Sex.MALE, City.Seoul),
				new Student("최우상", 95, Sex.FEMALE, City.Pusan),
				new Student("정우상", 70, Sex.MALE, City.Pusan),
				new Student("김우상", 60, Sex.FEMALE, City.Seoul)
		);
		
		//성을 키로 , 학생 평균점수값을 얻기
		
		//원리
		Stream<Student> mainStream = studentList.stream();	//메인 스트림 만들기
		Function<Student, Student.Sex> function = Student :: getSex;	//큰 구분기준 만들기
		
		//큰 구분기준으로 구분된 요소들에서 원하는 부분 추려내기
		//추려내는 기준
		ToDoubleFunction<Student> doubleFunction = Student :: getScore;
		//들어온 Student타입요소는 doubleFunction의 기준으로 추려내서 .averagingDouble메소드를 통해 Double타입으로 리턴
		Collector<Student, ?, Double> collector = Collectors.averagingDouble(doubleFunction);
		
		Collector<Student, ?, Map<Student.Sex, Double>> collector2 = Collectors.groupingBy(function, collector);
		Map<Student.Sex, Double> mapBySex = mainStream.collect(collector2);
		
		//간소화
//		Map<Student.Sex, Double> map = studentList.stream()
//				.collect(
//					Collectors.groupingBy(
//						Student :: getSex,
//						Collectors.averagingDouble(
//						Student :: getScore)
//					)
//				);
		
		//성을 키로, 쉼표로 구분된 학생 이름 문자열을 값으로 갖는 Map
		
		//원리
		Stream<Student> fullStream = studentList.stream();
		
		Function<Student, Student.Sex> classifier = s -> s.getSex();
		
		Function<Student, String> mapper = s -> s.getName();
		Collector<CharSequence, ?, String> join = Collectors.joining(",");
		Collector<Student, ?, String> collector3 = Collectors.mapping(mapper, join);
		
		Collector<Student, ?, Map<Student.Sex, String>> collector4 = Collectors.groupingBy(classifier, collector3);
		
		Map<Student.Sex, String> finalCollector = fullStream.collect(collector4);
	
		//간소화
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
