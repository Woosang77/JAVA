package Practice.Lesson.LambdaPart.and_or_negate_isequal;

import java.util.function.Predicate;

public class PredicateIsEqualExample {

	public static void main(String[] args) {
		Predicate<String> predicate;
		
		//null - null
		predicate = Predicate.isEqual(null);
		System.out.println(predicate.test(null));
		
		//null - Java8
		predicate = Predicate.isEqual("Java8");
		System.out.println(predicate.test(null));
		
		//Java8 - null
		predicate = Predicate.isEqual(null);
		System.out.println(predicate.test("Java8"));
		
		//Java8 - Java8
		predicate = Predicate.isEqual("Java8");
		System.out.println(predicate.test("Java8"));
		
		/*
		 * 	true
		 * false
		 * false
		 * true
		 */
	}

}
