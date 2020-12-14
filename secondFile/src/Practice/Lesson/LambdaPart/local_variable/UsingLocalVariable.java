package Practice.Lesson.LambdaPart.local_variable;

public class UsingLocalVariable {
	 void method(int arg) {
		 int localVar = 40;
		 
		 //	arg = 31;		
		 //	localVar = 51;
		 //람다식에서 매개변수와 로컬변수를 읽고 출력하기 때문에, 위의 두 변수는 final특성을 갖기 때문에 뱐수를 수정할 수 없다.
		 //두 변수를 final로 직접 지정을 해도 되는데, 안해도 암묵적으로 final로 취급된다.
		 MyFunctionalInterface fi = () -> {
			 System.out.println("arg : " + arg);
			 System.out.println("localVar : " + localVar);
		 };
		 
		 fi.method();
	 }
}
