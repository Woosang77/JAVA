package Practice.Lesson.LambdaPart.method_references;

import java.util.function.IntBinaryOperator;

public class MethodReferencesExample {

	public static void main(String[] args) {
		IntBinaryOperator operator;
		//두개의 int를 받고 연산 후 int를 리턴하기 때문에 적합하다.
		
		//정적 메소드 참조 : 정적 메소드 참조의 형태는 "클래스명" :: 정적 메소드;
		operator = (x,y) -> Calculator.staticMethod(x, y);
		//이 람다식은 단순히 (x,y)를 전달하는 역할만 하고 직접적인 실행은 메소드가 한다면, 메소드 참조를 이용한다.
		System.out.println("결과 1 :" + operator.applyAsInt(3, 4));

		
		operator = Calculator :: staticMethod;
		System.out.println("결과 2 :" + operator.applyAsInt(3, 4));
		
		
		//인스턴스 메소드 참조 : 인스턴스 메소드 참조의 형태는  정적 메소드처럼 클래스명을 이용하는 것이 아니다
		//참조변수명 :: 인스턴스 메소드;
		Calculator calculator = new Calculator();
		
		operator = (x,y) -> calculator.instanceMethod(x, y);
		System.out.println("결과 1 :" + operator.applyAsInt(4, 4));
		
		operator = calculator :: instanceMethod;
		System.out.println("결과 2 :" + operator.applyAsInt(4, 4));
	}

}
