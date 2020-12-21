package Practice.Lesson.stream.stream_looping;

import java.util.Arrays;

public class LoopingExample {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		//마지막에 peek호출한 경우
		Arrays.stream(arr)
			.filter(a -> a % 2 == 0)
			.peek(n -> System.out.println(n));
			//아무것도 출력되지 않는다. 
			//peek()는 중간 메소드이기 때문에 중간 메소드들은 최종처리 메소드가 없으면 아무 동작을 하지 않는다.

		//최종처리 메소드가 있는 경우
		int total = Arrays.stream(arr)
			.filter(a -> a % 2 == 0)
			.peek(n -> System.out.println(n))
			.sum();	//리덕션
		System.out.println();
		System.out.println(total);
		//		2
		//		4		peek()의 실행
		//
		//		6		total 출력
	}

}
