package Practice.Lesson.LambdaPart.andthen_compose;

import java.util.function.Function;

public class FunctionAndthenComposeExample {

	public static void main(String[] args) {
		Function<Member, Address> functionA;
		Function< Address, String> functionB;
		Function<Member, String> functionAB;		//�ᱹ ���� ����ϴ� AB�� Member�� �ް� String�� ����ϱ� ������ �߰��� B�������̽��� �߰����� ���Ҹ� �Ѵ�.
		
		functionA = (m) -> m.getAddress();
		functionB = (a) -> a.getCity();
		//�Լ��� �������̽����� ���ٽ��� �ش� �Լ��� ȣ��޼ҵ带 ���� ȣ��Ǿ��� ��, �����ϴ� ���๮�� �Է��� ���̴�.
		//.andThen()
		functionAB = functionA.andThen(functionB);
		String city = functionAB.apply(new Member("ȫ�浿", "hong", new Address("�ѱ�",  "Seoul")));
		//.apply�� ȣ��Ǹ� Member��ü�� ������ A�� ���ٽĿ� ����� �°� ��µǰ�,
		//�� ��°��� �ٽ� B�� �Է°����� �� �Ŀ� ��µ� ���� AB�� ������� �ȴ�.
		System.out.println(city);
		
		
		//.compose()
		functionAB = functionB.compose(functionA);
		city = functionAB.apply(new Member("ȫ�浿", "hong", new Address("�ѱ�",  "Seoul")));
		System.out.println(city);
	}

}
