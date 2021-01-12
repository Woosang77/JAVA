package Practice.Lesson.IOpackage.Serializable.Serialversion;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SerialVersionUIDExample2 implements Serializable{

	public static void main(String[] args) throws Exception{
		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ClassC v = (ClassC)ois.readObject();
		System.out.println("field1 : "  + v.field1);
		System.out.println("field2 : "  + v.field2);
		System.out.println("field3 : "  + v.field3);
		ois.close(); fis.close();
	}
	
	//ClassC파일에 field1만 저장했을 때 결과   -    field1 : 1
	//ClassC파일에 field2를 추가하고 컴파일 후 결과	-	Exception in thread "main" java.io.InvalidClassException
	//serialVersionUID가 다르기 때문에 반영할 수 없다.
	/*
	 * 새로 컴파일을 할 때마다 serialVersionUID가 바뀐다. 직렬화할 때와 역직렬화할 때의 사용된 클래스가 서로 다르기 때문이다.
	 * 직렬화할때는 ClassC에는 field1밖에 없었고, ClassC에 field2를 추가하고 역직렬화를 하면 오류가 발생한다.
	 * 
	 * 자주 수정되는 클래스를 소스로 사용한다면 명시적으로 serialVersionUID를 선언하면 된다.
	 */

}
