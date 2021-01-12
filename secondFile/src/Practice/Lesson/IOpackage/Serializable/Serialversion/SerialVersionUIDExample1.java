package Practice.Lesson.IOpackage.Serializable.Serialversion;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialVersionUIDExample1 implements Serializable {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		ObjectOutputStream	 oos = new ObjectOutputStream(fos);
		ClassC classC = new ClassC();
		classC.field1 = 1;
		classC.field2 = 2;
		classC.field3 = 3;
		oos.writeObject(classC);
		oos.flush(); oos.close(); fos.close();
	}

}
