package Practice.Lesson.stream.stream_mapping;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample {

	public static void main(String[] args) {
		//각 요소에 있는 단어들을 요소로 가지는 새로운 중간 스트림
		List<String> inputList = Arrays.asList("Java8 lambda", "stream mapping"); 
		
		inputList.stream()
			.flatMap(data -> Arrays.stream(data.split(" ")))
			.forEach(word -> System.out.println(word));
			//		Java8
			//		lambda
			//		stream
			//		mapping
		
		//세 개의 숫자가 들어있는 각 요소들을 받아서 "," 기준으로 자르고, 공백을 제거한 다음 int로 변환하여 출력
		List<String> inputList2 = Arrays.asList("10, 20, 30", "40, 50, 60"); 
		
		//오리지널 스트림
		inputList2.stream()
		
		//중간 스트림(출력 전에 변환하는 과정)
		.flatMapToInt(data -> {		//.flatMapToInt = 객체를 받아서 IntStream으로 넘긴다.
			String[] strArray = data.split(",");
			int[] intArr = new int[strArray.length];
			for (int i = 0; i < strArray.length; i++) {
				intArr[i] = Integer.parseInt(strArray[i].trim());	//trim()은 문자열에서 공백을 제거한다.
			}
			return Arrays.stream(intArr);
		})
		
		//리덕션
		.forEach(number -> System.out.print(number + " "));
		//   10 20 30 40 50 60 

	}

}
