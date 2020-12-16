package Practice.Lesson.LambdaPart.comstructor_references;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReferencesExample {

	public static void main(String[] args) {
		Function<String, Member> function1 = Member :: new;
		//이 함수적 인터페이스는 Member객체를 리턴하는 기능을 하고, 매개변수로 String 한 개를 사용하기 때문에 그에 맞는 생성자를 사용
		Member member1 = function1.apply("angel");
		//결과 : Member(String id) 실행
		
		BiFunction<String, String, Member> function2 = Member :: new;
		//위와 코드는 같지만 함수적 인터페이스에서 받는 매개값의 타입이나, 갯수에 따라 다른 생성자를 생성하였다면, 그에 맞게 사용된다.
		Member member2 = function2.apply("angel", "천사");
		//결과 : Member(String name, String id) 실행
		
		//생성자 참조 코드는 같더라도 매개변수가 어떻게 제공되는지에 따라서 생성자의 제공이 달라짐
	}

}
