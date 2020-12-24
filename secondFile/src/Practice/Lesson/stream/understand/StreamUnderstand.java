package Practice.Lesson.stream.understand;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//요소 
class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}

public class StreamUnderstand {
	
	/*
	 * Stream은 Collection 자료 구조에서 데이터 처리 연산을 지원하도록 추출된 연속된 요소이다.
	 * 큰 단계는 세 가지가 있다.
	 * 1) 자료구조로부터 스트림 생성
	 * 2) 중간 연산
	 * 3) 최종 연산
	 */
	public static void main(String[] args) {
		//리스트 자료구조 생성
		List<Person> list = Arrays.asList(
				new Person("장우상", 22),
				new Person("김우상", 19),
				new Person("최우상", 9)
		);
		//1) 자료구조로부터 스트림 생성 (오리지널 스트림)
		Stream<Person> mainStream = list.stream();
		
		/*
		 * 2) 중간 연산 - filter, map, sort, loop등이 있고 서로 연결되어 파이프라인을 "형성"한다.
		 * 중간 연상에서는 형성할 뿐 실행되지는 않는다(lazy).
		 */
		Stream<Person> filterStream = mainStream.filter(p -> (p.getAge() - 10) > 1);
		Stream<String> mapStream = filterStream.map(Person :: getName);
		
		/*
		 * 3) 최종 연산 : 형성된 스트림 파이프라인을 실행, 결과도출 후 닫는다. 최종 연산에는 크게 두가지 부류가 있다.
		 * 
		 * 첫 번째, 집계(reduce) : 결과를 기본 타입(int, long, double 등) 또는 Optional class로 리턴한다.
		 * 		Optional<T> : 값의 존재, 부재 여부를 표현하는 컨테이너 클래스 - 값이 있다면 출력, 중간 연산을 통해 값이 없어졌을 때 에러발생을 피하기 위해 디폴트값 설정
		 * 			.method : isPresent()(값 존재여부 불린리턴) / orElse(...) (없다면 ...실행) / ifPresent(...)(있으면...실행 , 없으면 지나감)
		 * 
		 * 두 번째, collect : 집계는 큰 범위 내에서 결과를 출력하고 종료한다. 하지만 collect는 중간 연산을 하고 추려진 요소들을 컬렉션으로 담을 수 있다.
		 * 		.collect(Collector collector);
		 * 			Collector는 기본적으로 구현 객체인 Collectors의 정적 메소드를 이용한 리턴값이 Collector타입이기 때문에 그렇게 넣는다.
		 * 			예를 들어, .collect(Collectors.toList())로 나오는 Collecter타입의 리턴값은 Collector<T,?,List<T>>이다.
		 * 			Collector <T,A,R>에서 T는 요소의 타입, A는 누적기, R은 요소 저장 컬렉션 타입이다.
		 * 
		 */
		//첫 번째, 집계 (기본타입)
		Long count = mapStream.count();	
		System.out.println(count);		//결과 2
		
		//첫 번째 집계(Optional<T>)
		Optional<String> firstName = mapStream.findFirst();
		String name = firstName.get();
		System.out.println(name);
		// 결과 : 장우상
		
		//두 번쨰, collect
		//collect쓸 것이기 때문에 Collector 타입을 리턴 받아야한다. 
		Supplier<HashSet<String>> supplier = HashSet :: new;
		Collector<String, ?, HashSet<String>> nameSet = Collectors.toCollection(supplier);
		//toCollection(Supplier<Collection<T>>)메소드는 T를 Supplier에서 제공한 컬렉션에 저장
		Set<String> set = mapStream.collect(nameSet);
		set.forEach(s -> System.out.println(s));
		// 	결과
		//		장우상
		//		김우상


		
		
		
		
	}

}
