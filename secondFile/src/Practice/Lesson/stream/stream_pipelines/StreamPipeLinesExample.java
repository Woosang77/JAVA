package Practice.Lesson.stream.stream_pipelines;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Stream의 최종 목적은 여러개의 요소를 반복하면서 리덕션(최종처리)를 하는  것이다.
 * 하지만 한 번에 최종처리로 못 가는 경우가 대부분이다. 사용하는 요소들 중에 필요한 부분만 따로 사용하거나, 정렬, 필터링 등이 있다.
 * 이는 중간 처리에서 처리 후 최종 처리에서 마무리 한다.
 * 실행 과정에서는 최종 처리 단계가 시작되지 않았다면, 중간 단계로 넘어가지 않고 지연된다.
 * 예를 들어 파이프를 만들었어도, 수도꼭지를 만들기 전까지 물을 틀지 않는 느낌이다.
 */

public class StreamPipeLinesExample {
	public static void main(String[] args) {
		//스트림 소스 컬렉션 생성
		List<Member>	list = Arrays.asList(
				new Member("홍길동", Member.MALE,30),
				new Member("김나리", Member.FEMALE,20),
				new Member("장우상", Member.MALE,45),
				new Member("박수진", Member.FEMALE,27)
		);
		//기본
		Stream<Member> stream = list.stream();	//오리지널 스트림
		
		Stream<Member> mStream = stream.filter(m -> m.getSex() == Member.MALE);
		//중간 스트림 .filter메소드는 Predicate 함수적 인터페이스를 사용한다. 앞서 공부한 것처럼 Predicated는 불린형으로 리턴되는 것이다.
		
		IntStream intStream = mStream.mapToInt(a -> a.getAge());
		//중간 스트림 .mapToInt()는 매개값으로 받는 요소에서 int를 매핑하여 IntStream을 생성한다.

		OptionalDouble optionalDouble = intStream.average();
		//최종단계 .average()는 intStream의 평균 값을 OptionalDouble타입으로 리턴한다.
		
		double ageAverage = optionalDouble.getAsDouble();
		//OptionalDouble을 출력하기 위해 Double로 리턴  
		System.out.println(ageAverage);
		
		//간소화 실전
		double ageAvg = list.stream()
		.filter(m -> m.getSex() == Member.MALE)
		.mapToInt(a -> a.getAge())
		.average()
		.getAsDouble();
		
		System.out.println(ageAvg);
	}
}
