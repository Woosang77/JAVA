package Practice.Lesson.LambdaPart.local_variable;

public class UsingLocalVariable {
	 void method(int arg) {
		 int localVar = 40;
		 
		 //	arg = 31;		
		 //	localVar = 51;
		 //���ٽĿ��� �Ű������� ���ú����� �а� ����ϱ� ������, ���� �� ������ finalƯ���� ���� ������ ������ ������ �� ����.
		 //�� ������ final�� ���� ������ �ص� �Ǵµ�, ���ص� �Ϲ������� final�� ��޵ȴ�.
		 MyFunctionalInterface fi = () -> {
			 System.out.println("arg : " + arg);
			 System.out.println("localVar : " + localVar);
		 };
		 
		 fi.method();
	 }
}
