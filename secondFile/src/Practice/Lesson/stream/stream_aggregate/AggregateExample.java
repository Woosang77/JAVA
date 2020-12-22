package Practice.Lesson.stream.stream_aggregate;

import java.util.Arrays;

public class AggregateExample {

	public static void main(String[] args) {
		long count = Arrays.stream(new int[] {1,2,3,4,5})
				.filter(n -> n%2 == 0)
				.count();
		System.out.println(count);		//2
		
		long sum = Arrays.stream(new int[] {1,2,3,4,5})
				.filter(n -> n %2 == 0)
				.sum();
		System.out.println(sum);	//6
		
		double avg = Arrays.stream(new int[] {1,2,3,4,5})
				.filter(n -> n%2 == 0)
				.average()			//최종처리가 OptionalXXX의 타입으로 리턴되는 메소드는 getXXX메소드를 통해 출력 가능한 데이터 타입으로 변경해야한다.
				.getAsDouble();
		System.out.println(avg);		//3.0
		
		int max = Arrays.stream(new int[] {1,2,3,4,5})
				.filter(n -> n%2 == 0)
				.max()
				.getAsInt();
		System.out.println(max); 	//4
		
		int min = Arrays.stream(new int[] {1,2,3,4,5})
				.filter(n -> n%2 == 0)
				.min()
				.getAsInt();
		System.out.println(min); 	//2
		
		int first = Arrays.stream(new int[] {1,2,3,4,5})
				.filter(n -> n%2 == 0)
				.findFirst()
				.getAsInt();
		System.out.println(first); 	//2
	}

}
