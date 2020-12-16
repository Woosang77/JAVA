package Practice.Lesson.LambdaPart.method_references;

import java.util.function.IntBinaryOperator;

public class MethodReferencesExample {

	public static void main(String[] args) {
		IntBinaryOperator operator;
		//�ΰ��� int�� �ް� ���� �� int�� �����ϱ� ������ �����ϴ�.
		
		//���� �޼ҵ� ���� : ���� �޼ҵ� ������ ���´� "Ŭ������" :: ���� �޼ҵ�;
		operator = (x,y) -> Calculator.staticMethod(x, y);
		//�� ���ٽ��� �ܼ��� (x,y)�� �����ϴ� ���Ҹ� �ϰ� �������� ������ �޼ҵ尡 �Ѵٸ�, �޼ҵ� ������ �̿��Ѵ�.
		System.out.println("��� 1 :" + operator.applyAsInt(3, 4));

		
		operator = Calculator :: staticMethod;
		System.out.println("��� 2 :" + operator.applyAsInt(3, 4));
		
		
		//�ν��Ͻ� �޼ҵ� ���� : �ν��Ͻ� �޼ҵ� ������ ���´�  ���� �޼ҵ�ó�� Ŭ�������� �̿��ϴ� ���� �ƴϴ�
		//���������� :: �ν��Ͻ� �޼ҵ�;
		Calculator calculator = new Calculator();
		
		operator = (x,y) -> calculator.instanceMethod(x, y);
		System.out.println("��� 1 :" + operator.applyAsInt(4, 4));
		
		operator = calculator :: instanceMethod;
		System.out.println("��� 2 :" + operator.applyAsInt(4, 4));
	}

}
