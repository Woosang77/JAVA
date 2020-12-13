package Practice.Lesson.LambdaPart.no_arguments_no_return;

public class MyFunctionalInterfaceExample {

	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		//MyFunctionalInterface�� ���캸�� �޼ҵ忡 �Ű������� ���� ������ �Ұ�ȣ ���� ������´�.
		fi = () -> {
			String str = "method call1";
			System.out.println(str);
		};
		fi.method();
		
		//���ٽĿ��� ����ΰ� �ϳ���� �߰�ȣ�� �����ص� �������.
		fi = () -> System.out.println("method call2"); 
		fi.method();
		
		
		
		//���� method call1, 2�� �ᱹ method call3�� ����ϴ� �͸�ü�� �����ϴ�.
		fi = new MyFunctionalInterface() {
			@Override
			public void method() {
				System.out.println("method call3"); 
			}
		};
		
		
	}
}
