package Practice.Lesson.stream.stream_collect;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ToListExample {
	
	/*
	 * 수집(Collect)는 필터링과 매핑등으로 나온 최종 처리 요소들을 수집하여 컬렉션에 저장한다.
	 * 사용법은 스트림에서 .collect(Collector)을 사용하면된다.
	 *  매개값 타입인 Collector는 Collector의 구현 객체인 Collectors의 정적메소드를 사용한다.  
	 */
	public static void main(String[] args) {
		List<Student> totalList = Arrays.asList(
			new Student("홍길동", 10, Student.Sex.MALE),
			new Student("김수애", 6, Student.Sex.FEMALE),
			new Student("장우상", 10, Student.Sex.MALE),
			new Student("김수희", 6, Student.Sex.FEMALE)
		);
		
		//남학생들만 묶어 List 생성
		List<Student> maleList = totalList.stream()
			.filter(s -> s.getSex() == Student.Sex.MALE)
			.collect(Collectors.toList());
		maleList.stream()
			.forEach(n -> System.out.println(n.getName()));
		
		//여학생들만 묶어 List 생성
		Set<Student> femaleSet= totalList.stream()
			.filter(s -> s.getSex() == Student.Sex.FEMALE)
			.collect(Collectors.toCollection(HashSet::new));
		femaleSet.stream()
			.forEach(n->System.out.println(n.getName()));
	}
}
