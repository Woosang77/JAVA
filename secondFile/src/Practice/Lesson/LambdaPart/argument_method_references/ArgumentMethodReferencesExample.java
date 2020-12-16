package Practice.Lesson.LambdaPart.argument_method_references;

import java.util.function.ToIntBiFunction;

public class ArgumentMethodReferencesExample {

	public static void main(String[] args) {
		ToIntBiFunction<String, String> function;
		
		function = (a,b) -> a.compareToIgnoreCase(b);
		//a�� b���� ���������� ������ �� �������� ����, ������ 0, �ڿ� ���� ����� ����
		//���ڿ� �ΰ��� ���ϰ� int�� �����ϴ� ���� ToIntBiFunction<String, String>�� �ڵ尡 ��ġ�Ѵ�.
		print(function.applyAsInt("�ڹ�8", "�ڹ�8"));
		
		function = String :: compareToIgnoreCase;
		//a�� Ÿ�� Ÿ���� �ۼ�(String)�ϰ�, �ν��Ͻ� �޼ҵ��� compareToIgnoreCase �ۼ�
		print(function.applyAsInt("�ڹ�8", "�ڹ�8"));
		//�ڹٴ� �޼ҵ尡 a�� �ν��Ͻ��޼ҵ����� Ȯ�� �� �´ٸ�, �Ű������� b�� �����ؼ� ����� �����Ѵ�.
		
	
	}
	
	public static void print(int order) {
		if (order<0) {System.out.println("���������� �����ɴϴ�.");}
		else if (order == 0) {System.out.println("������ ���ڿ��Դϴ�.");}
		else {System.out.println("���������� ���߿� �ɴϴ�.");}
	}

}
