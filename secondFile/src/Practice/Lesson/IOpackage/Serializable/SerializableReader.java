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
		System.out.println("field3 : " + v.field3);		//static, transient 필드 값은 직렬화되지 않는다.
		System.out.println("field4 : " + v.field4);
		
		//또한 클래스 내부에 필드값만 직렬화가 되어 바이트로 바뀌고, 메소드 및 생성자는 직렬화할 수 없다.
		ois.close(); fis.close();
		
		/*
		 * field1: 1
			field2.field1 : 2
			field3 : 0
			field4 : 0
		 */
	}

}
