package Practice.Lesson.LambdaPart._field;

public class UsingThis {
	public int outterField = 10;
	
	class Inner {
		int innerField = 20;
		
		void method( ) {
			MyFunctionalInterface fi = () -> {
				System.out.println("outterField : " + outterField);
				System.out.println("outterField : " + UsingThis.this.outterField);
				System.out.println("innerField : " + this.innerField);
			};
			//���ٽĿ��� �ν��Ͻ����� Ŭ���� ��,�ܺο��� ���ǵ� �ʵ带 ����Ѵٸ� 
			//�̸��� �����Ͽ� ����� �� ������ �̸��� ������ ��Ȯ�ϰ� �����ϱ� ����
			//���ٽ� ���� Ŭ������ �ܺ� Ŭ������ UsingThis.this.outterField�� ���� Ŭ������ �̸��� this�� ���� ��Ÿ����.
			fi.method();
		}
	}
}
