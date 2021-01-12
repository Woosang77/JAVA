package Practice.Lesson.IOpackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStreamExample {

	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(new Integer(100));
		oos.writeObject(new Double(3.14));
		oos.writeObject(new int[ ] {1,2,3,4});
		oos.writeObject(new String("장우상"));
		
		oos.flush(); oos.close(); fos.close();
		
		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Integer obj1 = (Integer)ois.readObject();
		Double obj2 = (Double)ois.readObject();
		int[] obj3 = (int [])ois.readObject();
		String obj4 = (String)ois.readObject();
		
		ois.close(); fis.close();
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3[0] + ", " + obj3[1] + ", " + obj3[2]	+ ", " + obj3[3] );
		System.out.println(obj4);
		
		//복수의 객체를 저장할 경우 반드시 저장한 순서와 동일한 순서로 객체를 읽어야 한다.
		
		
	}

}
