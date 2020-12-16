package Practice.Lesson.LambdaPart.comstructor_references;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReferencesExample {

	public static void main(String[] args) {
		Function<String, Member> function1 = Member :: new;
		//�� �Լ��� �������̽��� Member��ü�� �����ϴ� ����� �ϰ�, �Ű������� String �� ���� ����ϱ� ������ �׿� �´� �����ڸ� ���
		Member member1 = function1.apply("angel");
		//��� : Member(String id) ����
		
		BiFunction<String, String, Member> function2 = Member :: new;
		//���� �ڵ�� ������ �Լ��� �������̽����� �޴� �Ű����� Ÿ���̳�, ������ ���� �ٸ� �����ڸ� �����Ͽ��ٸ�, �׿� �°� ���ȴ�.
		Member member2 = function2.apply("angel", "õ��");
		//��� : Member(String name, String id) ����
		
		//������ ���� �ڵ�� ������ �Ű������� ��� �����Ǵ����� ���� �������� ������ �޶���
	}

}
