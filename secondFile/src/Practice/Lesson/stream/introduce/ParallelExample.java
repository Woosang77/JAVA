package Practice.Lesson.stream.introduce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("ȫ�浿","�ſ��", "���ڹ�", "���ٽ�", "�ں���");
		
		//����ó��
		Stream<String> stream = list.stream();
		//stream.forEach(name -> print(name));
		stream.forEach(ParallelExample :: print); 	//�޼ҵ� ���� Ȱ��
		//		ȫ�浿: main
		//		�ſ��: main
		//		���ڹ�: main
		//		���ٽ�: main
		//		�ں���: main
		
		System.out.println();
		
		//����ó��
		Stream<String> parallelstream = list.parallelStream();
		parallelstream.forEach(ParallelExample :: print);
		//		���ڹ�: main
		//		���ٽ�: main
		//		ȫ�浿: main
		//		�ں���: ForkJoinPool.commonPool-worker-2
		//		�ſ��: ForkJoinPool.commonPool-worker-9
	}
	
	public static void print(String str) {
		System.out.println(str + ": " + Thread.currentThread().getName());

	}
}
