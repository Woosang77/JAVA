package Practice.Lesson.stream.stream_filtering;

import java.util.Arrays;
import java.util.List;

public class FilteringExample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("ȫ�浿", "����", "���ڹ�", "����" , "���ڹ�", "������");
		
		//�ߺ�����
		list.stream()
		.distinct()
		.forEach(n -> System.out.println(n));
		//ȫ�浿
		//����
		//���ڹ�
		System.out.println();
		
		//���� �� �� ���
		list.stream()
		.filter(n -> n.startsWith("��"))
		.forEach(n -> System.out.println(n));
		//		���ڹ�
		//		���ڹ�
		//		������
		System.out.println();
		
		//���� �߿��� �ߺ�����
		list.stream()
		.filter(n -> n.startsWith("��"))
		.distinct()
		.forEach(n -> System.out.println(n));
		//		���ڹ�
		//		������
		
	}

}
