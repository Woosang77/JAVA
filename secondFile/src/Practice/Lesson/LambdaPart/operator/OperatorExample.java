package Practice.Lesson.LambdaPart.operator;

import java.util.function.IntBinaryOperator;

public class OperatorExample {
	
	private static int[] scores = {92, 95,87};
	
	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.applyAsInt(result, score);	//2. .applyAsInt 함수적 인터페이스의 메소드 발생
		}
		return result;
	}
	
	public static void main(String[] args) {
		int max = maxOrMin(
			(a, b) -> {
				if (a >= b) return a;
				else return b;
			}
		);
		System.out.println(max);
		
		int min = maxOrMin(		//1. maxOrMin실행
				(a, b) -> {		//3. 발생된 메소드는 이 람다식을 통해 리턴값 출력
					if (a <= b) return a;
					else return b;
				}
			);
			System.out.println(min);
			
	//메인 메소드에서 진행하다가 보이는 람다식은 람다를 먼저 실행하는 것이 아니라 
	//람다를 담고 있는 메소드를 실행시킨 후, 파라미터로 지정된 함수적 인터페이스의 메소드 발생시 메소드의 실행은 아래의 람다와 같이 처리하는 뜻이다. 
	//결론적으로 써있는 람다식은 람다식을 가지는 함수적 인터페이스를 파라미터로 하는 메소드의 실행에서 인터페이스의 메소드 발생시 처리할 설명서이다. 
	}

}
