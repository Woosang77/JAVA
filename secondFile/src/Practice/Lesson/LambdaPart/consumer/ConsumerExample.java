package Practice.Lesson.LambdaPart.consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class ConsumerExample {
	
	/*
	 * Consumer 함수적 인터페이스는 매개값이 갯수와 타입의 종류는 어떤 Consumer를 사용하는지에 따라 달라진다. 
	 * Consumer는 accept()메소드를 통해 매개값을 받고, 리턴값없이 실행을 한다.
	 */
	
	public static void main(String[] args) {
		//consumer는 acccept()에서 파라미터로 t를 받고, 리턴값없이 소비를 한다.(t의 타입은 제네릭으로 지정한 타입이다.)
		Consumer<String> consumer = t -> System.out.println(t + "8");
		consumer.accept("Java");
		
		//두개의 객체를 받는다.
		BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t + u);
		biConsumer.accept("hi ", "java");		//출력 : hi java
		
		DoubleConsumer doubleConsumer = d -> System.out.println("java" + d);
		doubleConsumer.accept(8.0);
		
		
		//t는 제네릭으로 지정한 타입이고, i는 int로 고정되어있다.
		ObjIntConsumer<String> objIntConsumer = (t, i) ->  System.out.println(t + i);
		objIntConsumer.accept("java",  8);
		
	}

}
