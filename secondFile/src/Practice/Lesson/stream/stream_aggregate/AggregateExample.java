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
				.average()			//����ó���� OptionalXXX�� Ÿ������ ���ϵǴ� �޼ҵ�� getXXX�޼ҵ带 ���� ��� ������ ������ Ÿ������ �����ؾ��Ѵ�.
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
