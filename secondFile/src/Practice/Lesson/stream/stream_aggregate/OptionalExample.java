package Practice.Lesson.stream.stream_aggregate;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {
	public static void main(String[] args) {
		/*
		 * Optional 클래스는 값을 저장하는 값 기반 클래스이다.
		 * 기능으로는 
		 * - 집계(대량의 데이터를 가공해 축소하는 리덕션) 값을 저장
		 * - 집계 값이 없을 경우 디폴트 값 설정
		 * - 집계 값을 처리하는 Consumer 등록
		 */
		
		List<Integer> list = new ArrayList<>();
		//list에 요소가 없기 때문에 평균값도 없다. 
//		double avg = list.stream()
//			.mapToInt(Integer :: intValue)
//			.average()
//			.getAsDouble();
		//결과 : java.util.NoSuchElementException 발생 (요소가 없다)
		//처리하는 과정에서 최종처리를 통해 출력될 수 있는 요소가 중간 처리에서 다 걸러져서 없을 수 있다.
		//그렇기 때문에 출력 요소가 없어서 오류가 나면 안된다.
		
		//방법 1	 : IF문을 추가해서 조건에 어긋나면 강제로 0.0출력
		OptionalDouble optional = list.stream()
				.mapToInt(Integer :: intValue)
				.average();
		if (optional.isPresent()	) {
			System.out.println(optional.getAsDouble());
		}else {
			System.out.println(0.0);
		}
		
		//방법2	 : orelse() 메소드 사용 - 최종 값이 있다면 값을 내보내고, 없다면 매개값을 출력
		double avg = list.stream()
				.mapToInt(Integer :: intValue)
				.average()
				.orElse(0.0);
		//이전까지는 average를 통해 출력된 OptionalXXX를 getXXX으로 변환 후 출력했지만,
		//.orElse는 리턴도 avg값에 맞춰준다.
		System.out.println(avg);
		
		//방법3 : .ifPresent문 사용 - 최종 값이 있으면 람다식에  Consumer에 넣고 실행하고 없다면 조용히 넘어감
		list.stream()
		.mapToInt(Integer :: intValue)
		.average()
		.ifPresent(n -> System.out.println(n));
		
		
	}
}
