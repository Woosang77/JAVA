package Practice.Lesson.LambdaPart.minby_maxby;

import java.util.function.BinaryOperator;

public class OperatorMinByMaxByExample {

	public static void main(String[] args) {
		BinaryOperator<Fruit> binaryOperator;
		Fruit fruit;
		
		//minBy
		binaryOperator = BinaryOperator.minBy((f1, f2) -> Integer.compare(f1.price, f2.price));		//comparator�� �͸� ���� ��ü(���ٽ����� �ۼ�)
		fruit = binaryOperator.apply(new Fruit("����",  6000), new Fruit("����", 10000));
		System.out.println(fruit.name);		//����
		
		//maxBy
		binaryOperator = BinaryOperator.maxBy((f1, f2) -> Integer.compare(f1.price, f2.price));		
		fruit = binaryOperator.apply(new Fruit("����",  6000), new Fruit("����", 10000));
		System.out.println(fruit.name);		//����
		  
	}

}
