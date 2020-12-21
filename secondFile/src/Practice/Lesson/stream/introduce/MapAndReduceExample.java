package Practice.Lesson.stream.introduce;

import java.util.Arrays;
import java.util.List;

public class MapAndReduceExample {

	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("홍길동", 10),
				new Student("신용권", 20),
				new Student("유미선", 30)
		);
		//중간처리 : 학생의 점수만 매핑
		//studentList.stream().mapToInt(s -> s.getScore());
		
		double avg = studentList.stream()	// --> 오리지날 스트림 : studentList에 저장된 Student객체를 요소로가지는 스트림
				
				.mapToInt(Student :: getScore)	// --> mapToInt가 리턴하는 IntStream은 Student를 점수로 매핑한, 점수가 요소인 스트림
																	//파라미터 타입이 ToIntFunction이기 때문에 Int가 리턴되는 메소드어야한다.
		//최종처리 : 점수의 평균값 출력				
				.average()		// 점수 스트림을 이용해서 평균값을 리턴 옵셔널 더블 
				.getAsDouble();
		
		System.out.println(avg); 
	}
 
}
