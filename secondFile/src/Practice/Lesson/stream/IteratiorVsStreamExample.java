package Practice.Lesson.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class IteratiorVsStreamExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동","신용권","감자바");
		
		//자바7 이전  Iterator 이용
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
		}
		 
		//자바8 Stream 이용
		Stream<String> stream = list.stream();
		stream.forEach(name -> System.out.println(name));
		
		
		/*
		 * 스트림(Stream)은 배열을 포함한 컬렉션(List, Set, Map)의 저장된 요소를 하나씩 참조해서 람다식을 이용해 처리할 수 있도록 해주는 반복자이다.
		 * 즉, 정리하자면 컬렉션들 안에 있는 요소를 알아서 돌아가면서 처리해주는데, 처리 방식을 람다식으로 정한다는 것이다.
		 */
	}
}
