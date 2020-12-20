package Practice.Lesson.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동","신용권", "김자바", "람다식", "박병렬");
		
		//순차처리
		Stream<String> stream = list.stream();
		//stream.forEach(name -> print(name));
		stream.forEach(ParallelExample :: print); 	//메소드 참조 활용
		//		홍길동: main
		//		신용권: main
		//		김자바: main
		//		람다식: main
		//		박병렬: main
		
		System.out.println();
		
		//병렬처리
		Stream<String> parallelstream = list.parallelStream();
		parallelstream.forEach(ParallelExample :: print);
		//		김자바: main
		//		람다식: main
		//		홍길동: main
		//		박병렬: ForkJoinPool.commonPool-worker-2
		//		신용권: ForkJoinPool.commonPool-worker-9
	}
	
	public static void print(String str) {
		System.out.println(str + ": " + Thread.currentThread().getName());

	}
}
