package Practice.Lesson.stream.stream_kind;

import java.util.stream.IntStream;

public class FromIntRangeExample {

	public static int sum;

	public static void main(String[] args) {
		
		IntStream stream = IntStream.rangeClosed(1, 100);	//rangeClosed�� ���� ������ ���ڸ� �����Ѵ�. range()�� �������� �ʴ´�.
		stream.forEach(a -> sum += a);
		// Stream�ݺ��ڰ� ������ ��µȴ�.
		System.out.println(sum);
	}

}
