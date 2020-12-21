package Practice.Lesson.stream.stream_mapping;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample {

	public static void main(String[] args) {
		//�� ��ҿ� �ִ� �ܾ���� ��ҷ� ������ ���ο� �߰� ��Ʈ��
		List<String> inputList = Arrays.asList("Java8 lambda", "stream mapping"); 
		
		inputList.stream()
			.flatMap(data -> Arrays.stream(data.split(" ")))
			.forEach(word -> System.out.println(word));
			//		Java8
			//		lambda
			//		stream
			//		mapping
		
		//�� ���� ���ڰ� ����ִ� �� ��ҵ��� �޾Ƽ� "," �������� �ڸ���, ������ ������ ���� int�� ��ȯ�Ͽ� ���
		List<String> inputList2 = Arrays.asList("10, 20, 30", "40, 50, 60"); 
		
		//�������� ��Ʈ��
		inputList2.stream()
		
		//�߰� ��Ʈ��(��� ���� ��ȯ�ϴ� ����)
		.flatMapToInt(data -> {		//.flatMapToInt = ��ü�� �޾Ƽ� IntStream���� �ѱ��.
			String[] strArray = data.split(",");
			int[] intArr = new int[strArray.length];
			for (int i = 0; i < strArray.length; i++) {
				intArr[i] = Integer.parseInt(strArray[i].trim());	//trim()�� ���ڿ����� ������ �����Ѵ�.
			}
			return Arrays.stream(intArr);
		})
		
		//������
		.forEach(number -> System.out.print(number + " "));
		//   10 20 30 40 50 60 

	}

}
