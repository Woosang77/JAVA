package Practice.Lesson.IOpackage.Serializable;

import java.io.Serializable;

public class ClassA implements Serializable	{
	/*
	 * ����ڰ� ��ü�� �����Ͽ� ����� ��� ��� ��ü���� ����ȭ�� �Ǿ� ����Ʈ�� ��µǴ� ���� �ƴϴ�.
	 *	Serializable �������̽��� �� �������̽�������, ������ ��ü�� private�� ������ ��� �ʵ带 ����Ʈ�� ��ȯ������,
	 *	static�̳� transient�� ���� �ʵ�� ����ȭ�� ���� �ʴ´�.
	 */
	int field1;
	ClassB field2 = new ClassB();
	static int field3;
	transient int field4;
	
}
