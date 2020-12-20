package Practice.Lesson.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class IteratiorVsStreamExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("ȫ�浿","�ſ��","���ڹ�");
		
		//�ڹ�7 ����  Iterator �̿�
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
		}
		 
		//�ڹ�8 Stream �̿�
		Stream<String> stream = list.stream();
		stream.forEach(name -> System.out.println(name));
		
		
		/*
		 * ��Ʈ��(Stream)�� �迭�� ������ �÷���(List, Set, Map)�� ����� ��Ҹ� �ϳ��� �����ؼ� ���ٽ��� �̿��� ó���� �� �ֵ��� ���ִ� �ݺ����̴�.
		 * ��, �������ڸ� �÷��ǵ� �ȿ� �ִ� ��Ҹ� �˾Ƽ� ���ư��鼭 ó�����ִµ�, ó�� ����� ���ٽ����� ���Ѵٴ� ���̴�.
		 */
	}
}
