package Practice.Lesson.stream.stream_match;

import java.util.Arrays;

public class MatchExample {

	public static void main(String[] args) {
		int[] arr = {2,4,6};
		
		//��� Stream��Ұ� predicate���ǿ� �����ؾ��ϴ� .allMatch()
		boolean result = Arrays.stream(arr).allMatch(n -> n % 2 == 0);
		System.out.println(result);		//true
		
		//�ϳ��� Stream��Ҷ� predicate���ǿ� �����ϸ� �Ǵ� .anyMatch()
		result = Arrays.stream(arr).anyMatch(n -> n % 3 == 0);
		System.out.println(result);		//true
		
		//��� Stream��Ұ� predicate���ǿ� �����ϸ� �ȵǴ� .noneMatch()
		result = Arrays.stream(arr).noneMatch(n -> n % 3 == 0);
		System.out.println(result);		//false
	}

}
