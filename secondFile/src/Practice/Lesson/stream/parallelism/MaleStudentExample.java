package Practice.Lesson.stream.parallelism;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MaleStudentExample {
	public static void main(String[] args) {
		List<Student> totalList = Arrays.asList(
				new Student("홍길동", 10, Student.Sex.MALE),
				new Student("김수애", 6, Student.Sex.FEMALE),
				new Student("장우상", 10, Student.Sex.MALE),
				new Student("김수희", 6, Student.Sex.FEMALE)
		);
		//원본
//		Stream<Student> totalStream = totalList.stream();
//		//오리지널 스트림 생성
//		
//		Stream<Student> maleStream = totalStream.filter(s -> s.getSex() == Student.Sex.MALE);
//		//오리지널 스트림에서 남자 필터링을 통해 남자스트림 생성
//		
//		Supplier<MaleStudent> supplier = () -> new MaleStudent();
//		//collect()를 위해 첫 번째 supplier 생성( 사용자 정의 컨테이너)
//		BiConsumer<MaleStudent, Student> accumulator = (r, t) -> r.accumulate(t);
//		//두 번째 Biconsumer를 위해 생성
//		BiConsumer<MaleStudent, MaleStudent> combiner = (r1, r2) -> r1.combine(r2);
//		//멀티 스레드에서 병렬작업시 여러 MaleStudent들을 한곳으로 모아주는 Bicomsumer
//		//싱글 스레드에서는 쓸모 없지만, 안 넣으면 실행이 안됨
//		
//		MaleStudent maleStudent2 = maleStream.collect(supplier, accumulator, combiner);
//		//세 가지 다 만들었으니까 실제 collect 실행 --> 사용자가 원하는 대로 컨테이너를 생성하고 요소를 수집했다.
//		
//		maleStudent2.getList().stream()
//		.forEach(s -> System.out.println(s.getName()));
//		
//		System.out.println();
//		
		
		//간소화
		MaleStudent maleStudent = totalList.parallelStream()
			.filter(s -> s.getSex() == Student.Sex.MALE)
			//사용자 컨테이너에 수집
			.collect(
					() -> new MaleStudent(),		//사용자 정의 컨테이너를 만드   는 Supplier(매개값 없고 리턴값있음)
					(r, t) -> r.accumulate(t),		//BiConsumer  r은 사용자 정의했던 컨테이너, t는 필터링된 요소 하나 r에 t를 누적시키겠다는 뜻
					(r1,r2) -> r1.combine(r2));	//병렬처리에서 컨테이너 두개를 결합
		maleStudent.getList().stream()
			.forEach(s -> System.out.println(s.getName()));
		
		
		//가장 간소화 하는 방법
//		MaleStudent maleStudent3 = totalList.stream()
//				.filter(s -> s.getSex() == Student.Sex.MALE)
//				.collect(MaleStudent :: new, MaleStudent :: accumulate, MaleStudent :: combine);
//		 
//		maleStudent3.getList().stream()
//			.forEach(s -> System.out.println(s.getName()));
		
		
		
	}
}
