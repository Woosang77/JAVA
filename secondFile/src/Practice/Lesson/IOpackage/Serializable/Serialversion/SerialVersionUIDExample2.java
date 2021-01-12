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
	
	//ClassC���Ͽ� field1�� �������� �� ���   -    field1 : 1
	//ClassC���Ͽ� field2�� �߰��ϰ� ������ �� ���	-	Exception in thread "main" java.io.InvalidClassException
	//serialVersionUID�� �ٸ��� ������ �ݿ��� �� ����.
	/*
	 * ���� �������� �� ������ serialVersionUID�� �ٲ��. ����ȭ�� ���� ������ȭ�� ���� ���� Ŭ������ ���� �ٸ��� �����̴�.
	 * ����ȭ�Ҷ��� ClassC���� field1�ۿ� ������, ClassC�� field2�� �߰��ϰ� ������ȭ�� �ϸ� ������ �߻��Ѵ�.
	 * 
	 * ���� �����Ǵ� Ŭ������ �ҽ��� ����Ѵٸ� ��������� serialVersionUID�� �����ϸ� �ȴ�.
	 */

}
