package Practice.Lesson.IOpackage.Serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerializableReader {

	public static void main(String[] args) throws Exception{
		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ClassA v = (ClassA)ois.readObject();
		System.out.println("field1: " + v.field1);
		System.out.println("field2.field1 : " + v.field2.field1);
		System.out.println("field3 : " + v.field3);		//static, transient �ʵ� ���� ����ȭ���� �ʴ´�.
		System.out.println("field4 : " + v.field4);
		
		//���� Ŭ���� ���ο� �ʵ尪�� ����ȭ�� �Ǿ� ����Ʈ�� �ٲ��, �޼ҵ� �� �����ڴ� ����ȭ�� �� ����.
		ois.close(); fis.close();
		
		/*
		 * field1: 1
			field2.field1 : 2
			field3 : 0
			field4 : 0
		 */
	}

}
