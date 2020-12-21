package Practice.Lesson.stream.stream_looping;

import java.util.Arrays;

public class LoopingExample {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		//�������� peekȣ���� ���
		Arrays.stream(arr)
			.filter(a -> a % 2 == 0)
			.peek(n -> System.out.println(n));
			//�ƹ��͵� ��µ��� �ʴ´�. 
			//peek()�� �߰� �޼ҵ��̱� ������ �߰� �޼ҵ���� ����ó�� �޼ҵ尡 ������ �ƹ� ������ ���� �ʴ´�.

		//����ó�� �޼ҵ尡 �ִ� ���
		int total = Arrays.stream(arr)
			.filter(a -> a % 2 == 0)
			.peek(n -> System.out.println(n))
			.sum();	//������
		System.out.println();
		System.out.println(total);
		//		2
		//		4		peek()�� ����
		//
		//		6		total ���
	}

}
