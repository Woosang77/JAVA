package Practice.Lesson.LambdaPart.operator;

import java.util.function.IntBinaryOperator;

public class OperatorExample {
	
	private static int[] scores = {92, 95,87};
	
	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.applyAsInt(result, score);	//2. .applyAsInt �Լ��� �������̽��� �޼ҵ� �߻�
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
		
		int min = maxOrMin(		//1. maxOrMin����
				(a, b) -> {		//3. �߻��� �޼ҵ�� �� ���ٽ��� ���� ���ϰ� ���
					if (a <= b) return a;
					else return b;
				}
			);
			System.out.println(min);
			
	//���� �޼ҵ忡�� �����ϴٰ� ���̴� ���ٽ��� ���ٸ� ���� �����ϴ� ���� �ƴ϶� 
	//���ٸ� ��� �ִ� �޼ҵ带 �����Ų ��, �Ķ���ͷ� ������ �Լ��� �������̽��� �޼ҵ� �߻��� �޼ҵ��� ������ �Ʒ��� ���ٿ� ���� ó���ϴ� ���̴�. 
	//��������� ���ִ� ���ٽ��� ���ٽ��� ������ �Լ��� �������̽��� �Ķ���ͷ� �ϴ� �޼ҵ��� ���࿡�� �������̽��� �޼ҵ� �߻��� ó���� �����̴�. 
	}

}
