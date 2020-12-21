package Practice.Lesson.stream.stream_kind;

import java.util.stream.IntStream;

public class FromIntRangeExample {

	public static int sum;

	public static void main(String[] args) {
		
		IntStream stream = IntStream.rangeClosed(1, 100);	//rangeClosed는 범위 마지막 숫자를 포함한다. range()는 포함하지 않는다.
		stream.forEach(a -> sum += a);
		// Stream반복자가 끝나면 출력된다.
		System.out.println(sum);
	}

}
