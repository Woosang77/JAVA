package Practice.Lesson.stream.stream_reduce;

import java.util.Arrays;
import java.util.List;

public class ReductionExample {
	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("ȫ�浿", 90),
				new Student("�ſ��", 92),
				new Student("���ڹ�", 95)
		);
		
		int sum1= studentList.stream()
				.mapToInt(Student :: getScore)
				.sum();
		System.out.println(sum1);
		
		int sum2= studentList.stream()
				.mapToInt(Student :: getScore)
				.reduce((a, b) -> a + b)		
				/*
				 * .reduce() �� IntBinaryOperator�� �Ű������� �Ѵ�.�� ���� Int�� �ް� ����(���ٽ�)�� �� �� ����
				 * ������ Optional<T>�� �ϱ� ������  getAsInt�� ���� ��� Ÿ������ �����ؾ��Ѵ�.
				 * .reduce()�� ū ������ ��Ʈ���� ��Ұ� ���� ���, ������ �߻��Ѵ�.
				 */
				.getAsInt();
		System.out.println(sum2);
		
		
		int sum3= studentList.stream()
				.mapToInt(Student :: getScore)
				.reduce(0, (a, b) -> a + b);
				/*
				 * .reduce(int identity, IntBinaryOperator)�� ������ �ٸ��� �� ���� �Ű����� �޴´�.
				 * IntBinaryOperator�� ���� �޼ҵ�� �Ȱ�����, ���� �߻��� ������ �������ֱ� ���� identity�� �ִ�.
				 * ���� ��Ұ� ���� ��츦 �����ϰ�, �����߿� ���ٸ� identity�� ��µȴ�.
				 * ������ Optional<T>�� �ƴ� �ٷ� T�� �Ǳ⶧���� getXXX()�� ����� �ʿ䰡 ����.
				 */
		System.out.println(sum3);
	}
}
