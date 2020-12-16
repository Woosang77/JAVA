package Practice.Lesson.LambdaPart.minby_maxby;

import java.util.function.BinaryOperator;

public class OperatorMinByMaxByExample {

	public static void main(String[] args) {
		BinaryOperator<Fruit> binaryOperator;
		Fruit fruit;
		
		//minBy
		binaryOperator = BinaryOperator.minBy((f1, f2) -> Integer.compare(f1.price, f2.price));		//comparator의 익명 구현 객체(람다식으로 작성)
		fruit = binaryOperator.apply(new Fruit("딸기",  6000), new Fruit("수박", 10000));
		System.out.println(fruit.name);		//딸기
		
		//maxBy
		binaryOperator = BinaryOperator.maxBy((f1, f2) -> Integer.compare(f1.price, f2.price));		
		fruit = binaryOperator.apply(new Fruit("딸기",  6000), new Fruit("수박", 10000));
		System.out.println(fruit.name);		//수박
		  
	}

}
