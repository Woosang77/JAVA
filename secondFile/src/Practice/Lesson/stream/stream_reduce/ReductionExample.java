package Practice.Lesson.stream.stream_reduce;

import java.util.Arrays;
import java.util.List;

public class ReductionExample {
	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("홍길동", 90),
				new Student("신용권", 92),
				new Student("감자바", 95)
		);
		
		int sum1= studentList.stream()
				.mapToInt(Student :: getScore)
				.sum();
		System.out.println(sum1);
		
		int sum2= studentList.stream()
				.mapToInt(Student :: getScore)
				.reduce((a, b) -> a + b)		
				/*
				 * .reduce() 는 IntBinaryOperator를 매개값으로 한다.두 개의 Int를 받고 연산(람다식)을 한 후 리턴
				 * 리턴은 Optional<T>로 하기 때문에  getAsInt를 통해 출력 타입으로 변경해야한다.
				 * .reduce()의 큰 단점은 스트림에 요소가 없을 경우, 에러가 발생한다.
				 */
				.getAsInt();
		System.out.println(sum2);
		
		
		int sum3= studentList.stream()
				.mapToInt(Student :: getScore)
				.reduce(0, (a, b) -> a + b);
				/*
				 * .reduce(int identity, IntBinaryOperator)는 위에와 다르게 두 개의 매개값을 받는다.
				 * IntBinaryOperator는 위에 메소드와 똑같지만, 에러 발생의 단점을 보완해주기 위해 identity가 있다.
				 * 최종 요소가 없을 경우를 설정하고, 실행중에 없다면 identity가 출력된다.
				 * 리턴은 Optional<T>가 아닌 바로 T로 되기때문에 getXXX()을 사용할 필요가 없다.
				 */
		System.out.println(sum3);
	}
}
