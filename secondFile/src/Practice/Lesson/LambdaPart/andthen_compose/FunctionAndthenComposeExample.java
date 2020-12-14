package Practice.Lesson.LambdaPart.andthen_compose;

import java.util.function.Function;

public class FunctionAndthenComposeExample {

	public static void main(String[] args) {
		Function<Member, Address> functionA;
		Function< Address, String> functionB;
		Function<Member, String> functionAB;		//결국 값을 출력하는 AB는 Member를 받고 String을 출력하기 때문에 중간의 B인터페이스는 중간자의 역할만 한다.
		
		functionA = (m) -> m.getAddress();
		functionB = (a) -> a.getCity();
		//함수적 인터페이스에서 람다식은 해당 함수가 호출메소드를 통해 호출되었을 때, 실행하는 실행문을 입력한 것이다.
		//.andThen()
		functionAB = functionA.andThen(functionB);
		String city = functionAB.apply(new Member("홍길동", "hong", new Address("한국",  "Seoul")));
		//.apply가 호출되면 Member객체의 값들이 A에 람다식에 결과에 맞게 출력되고,
		//그 출력값은 다시 B에 입력값으로 들어간 후에 출력된 값이 AB에 결과값이 된다.
		System.out.println(city);
		
		
		//.compose()
		functionAB = functionB.compose(functionA);
		city = functionAB.apply(new Member("홍길동", "hong", new Address("한국",  "Seoul")));
		System.out.println(city);
	}

}
