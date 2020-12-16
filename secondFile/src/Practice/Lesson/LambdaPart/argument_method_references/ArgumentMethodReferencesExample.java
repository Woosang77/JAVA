package Practice.Lesson.LambdaPart.argument_method_references;

import java.util.function.ToIntBiFunction;

public class ArgumentMethodReferencesExample {

	public static void main(String[] args) {
		ToIntBiFunction<String, String> function;
		
		function = (a,b) -> a.compareToIgnoreCase(b);
		//a가 b보다 사전순으로 비교했을 때 먼저오면 음수, 같으면 0, 뒤에 오면 양수를 리턴
		//문자열 두개를 비교하고 int로 리턴하는 것이 ToIntBiFunction<String, String>와 코드가 일치한다.
		print(function.applyAsInt("자바8", "자바8"));
		
		function = String :: compareToIgnoreCase;
		//a의 타겟 타입을 작성(String)하고, 인스턴스 메소드인 compareToIgnoreCase 작성
		print(function.applyAsInt("자바8", "자바8"));
		//자바는 메소드가 a의 인스턴스메소드임을 확인 후 맞다면, 매개값으로 b를 대입해서 결과를 리턴한다.
		
	
	}
	
	public static void print(int order) {
		if (order<0) {System.out.println("사전순으로 먼저옵니다.");}
		else if (order == 0) {System.out.println("동일한 문자열입니다.");}
		else {System.out.println("사전순으로 나중에 옵니다.");}
	}

}
