package Practice.Lesson.stream.stream_collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingExample {

	public static void main(String[] args) {
		List<Student> totalList = Arrays.asList(
				new Student("홍길동", 10, Student.Sex.MALE, Student.City.Pusan),
				new Student("김수애", 6, Student.Sex.FEMALE, Student.City.Seoul),
				new Student("장우상", 10, Student.Sex.MALE, Student.City.Seoul),
				new Student("김수희", 6, Student.Sex.FEMALE, Student.City.Pusan)
		);
		
		Map<Student.Sex, List<Student>> mapBySex = totalList.stream()
				.collect(Collectors.groupingBy(Student :: getSex));
		
		System.out.println("[남학생]");
		mapBySex.get(Student.Sex.MALE).stream().forEach(s -> System.out.println(s.getName()));
		System.out.println();
		
		System.out.println("[여학생]");
		mapBySex.get(Student.Sex.FEMALE).stream().forEach(s -> System.out.println(s.getName()));
		System.out.println();
		
		
		Map<Student.City, List<String>>mapByCity = totalList.stream()
				.collect(
					Collectors.groupingBy(
						Student :: getCity,
						Collectors.mapping(Student::getName, Collectors.toList())
					)
				);
		
		System.out.println("[서울]");
		mapByCity.get(Student.City.Seoul).stream()
			.forEach(name -> System.out.println(name));
		
		System.out.println();
		
		System.out.println("[부산]");
		mapByCity.get(Student.City.Pusan).stream()
			.forEach(name -> System.out.println(name));
	}

}
