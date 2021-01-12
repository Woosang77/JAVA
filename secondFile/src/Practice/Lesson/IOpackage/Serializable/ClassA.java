package Practice.Lesson.IOpackage.Serializable;

import java.io.Serializable;

public class ClassA implements Serializable	{
	/*
	 * 사용자가 객체를 정의하여 사용할 경우 모든 객체들이 직렬화가 되어 바이트로 출력되는 것이 아니다.
	 *	Serializable 인터페이스는 빈 인터페이스이지만, 구현한 객체는 private를 포함한 모든 필드를 바이트를 반환하지만,
	 *	static이나 transient가 붙은 필드는 직렬화가 되지 않는다.
	 */
	int field1;
	ClassB field2 = new ClassB();
	static int field3;
	transient int field4;
	
}
