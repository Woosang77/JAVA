package Practice.Lesson.LambdaPart.consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class ConsumerExample {
	
	/*
	 * Consumer �Լ��� �������̽��� �Ű����� ������ Ÿ���� ������ � Consumer�� ����ϴ����� ���� �޶�����. 
	 * Consumer�� accept()�޼ҵ带 ���� �Ű����� �ް�, ���ϰ����� ������ �Ѵ�.
	 */
	
	public static void main(String[] args) {
		//consumer�� acccept()���� �Ķ���ͷ� t�� �ް�, ���ϰ����� �Һ� �Ѵ�.(t�� Ÿ���� ���׸����� ������ Ÿ���̴�.)
		Consumer<String> consumer = t -> System.out.println(t + "8");
		consumer.accept("Java");
		
		//�ΰ��� ��ü�� �޴´�.
		BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t + u);
		biConsumer.accept("hi ", "java");		//��� : hi java
		
		DoubleConsumer doubleConsumer = d -> System.out.println("java" + d);
		doubleConsumer.accept(8.0);
		
		
		//t�� ���׸����� ������ Ÿ���̰�, i�� int�� �����Ǿ��ִ�.
		ObjIntConsumer<String> objIntConsumer = (t, i) ->  System.out.println(t + i);
		objIntConsumer.accept("java",  8);
	}

}
