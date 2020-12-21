package Practice.Lesson.stream.stream_match;

import java.util.Arrays;

public class MatchExample {

	public static void main(String[] args) {
		int[] arr = {2,4,6};
		
		//모든 Stream요소가 predicate조건에 만족해야하는 .allMatch()
		boolean result = Arrays.stream(arr).allMatch(n -> n % 2 == 0);
		System.out.println(result);		//true
		
		//하나의 Stream요소라도 predicate조건에 만족하면 되는 .anyMatch()
		result = Arrays.stream(arr).anyMatch(n -> n % 3 == 0);
		System.out.println(result);		//true
		
		//모든 Stream요소가 predicate조건에 만족하면 안되는 .noneMatch()
		result = Arrays.stream(arr).noneMatch(n -> n % 3 == 0);
		System.out.println(result);		//false
	}

}
