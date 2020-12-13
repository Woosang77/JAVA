package Practice.Lesson.LambdaPart.no_arguments_no_return;

@FunctionalInterface
/*어노테이션은 해당 인터페이스가 하나의 추상메소드만을 가지는 함수적 인터페이스인지를 확인하고 
* 만약 추상 메소드가 두 개라면 에러를 내보낸다.
*/
public interface MyFunctionalInterface {
	public void method();
	
	//public void method2();
	//method2는 선언할 수 없다.
}
