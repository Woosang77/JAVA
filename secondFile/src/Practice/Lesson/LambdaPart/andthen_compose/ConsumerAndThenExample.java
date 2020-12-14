package Practice.Lesson.LambdaPart.andthen_compose;

import java.util.function.Consumer;

public class ConsumerAndThenExample {

	public static void main(String[] args) {
		Consumer<Member> consumerA = (m) -> {
			System.out.println("consumerA : " + m.getName());
		};
		
		Consumer<Member> consumerB= (m) -> {
			System.out.println("consumerB : " + m.getId());
		};
		
		Consumer<Member> consumerAB = consumerA.andThen(consumerB);
		consumerAB.accept(new Member("홍길동", "hong", null));								//결과 : consumerA : 홍길동
																																//		   consumerB : hong
		
		/*
		 * 만약 andThen에서 consumerA가 리턴값이 있는 함수적 인터페이스였다면, consumerA의 리턴값을 consumerB의 파라미터로 넣음 
		 * 하지만 지금은 실행순서만 결정함
		 */
	}

} 
