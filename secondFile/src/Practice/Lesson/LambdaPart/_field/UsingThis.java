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
			//람다식에서 인스턴스들을 클래스 내,외부에서 정의된 필드를 사용한다면 
			//이름을 구분하여 사용할 수 있지만 이름이 같으면 정확하게 구분하기 위해
			//람다식 정의 클래스의 외부 클래스는 UsingThis.this.outterField와 같이 클래스의 이름과 this를 통해 나타낸다.
			fi.method();
		}
	}
}
