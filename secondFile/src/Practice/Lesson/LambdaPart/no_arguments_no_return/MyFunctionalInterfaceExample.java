package Practice.Lesson.LambdaPart.no_arguments_no_return;

public class MyFunctionalInterfaceExample {

	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		//MyFunctionalInterface를 살펴보면 메소드에 매개변수가 없기 때문에 소괄호 안을 비워놓는다.
		fi = () -> {
			String str = "method call1";
			System.out.println(str);
		};
		fi.method();
		
		//람다식에서 실행부가 하나라면 중괄호를 삭제해도 상관없다.
		fi = () -> System.out.println("method call2"); 
		fi.method();
		
		
		
		//위의 method call1, 2는 결국 method call3를 출력하는 익명객체와 동일하다.
		fi = new MyFunctionalInterface() {
			@Override
			public void method() {
				System.out.println("method call3"); 
			}
		};
		
		
	}
}
