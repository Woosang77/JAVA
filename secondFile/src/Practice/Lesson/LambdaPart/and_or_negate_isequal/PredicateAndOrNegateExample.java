package Practice.Lesson.LambdaPart.and_or_negate_isequal;

import java.util.function.IntPredicate;

public class PredicateAndOrNegateExample {

	public static void main(String[] args) {
		//2�� ����� �˻�
		IntPredicate predicateA = a -> a % 2 == 0;
		
		//3�� ��� �˻�
		IntPredicate predicateB = b-> b % 3 == 0;
		
		IntPredicate predicateAB;
		boolean result;
		
		//and()
		predicateAB = predicateA.and(predicateB);
		result = predicateAB.test(9);
		System.out.println(result);
		
		//or()
		predicateAB = predicateA.or(predicateB);
		result = predicateAB.test(9);
		System.out.println(result);
		
		//negate()
		predicateAB = predicateA.negate();
		result = predicateAB.test(9);
		System.out.println(result);
	}

}
