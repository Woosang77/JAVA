package Practice.Lesson.stream.stream_kind;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FromArrayExample {
	public static void main(String[] args) {
		String[] strArray = {"È«±æµ¿", "Àå¿ì»ó", "±è¹Ì³ª"};
		Stream<String> strStream = Arrays.stream(strArray);
		strStream.forEach(a -> System.out.println(a));
		
		int[]	intArray = {1,2,3,4,5};
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(a -> System.out.println(a));
	}
}
