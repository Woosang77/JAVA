package Practice.Lesson.IOpackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamExample {

	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("C:/Temp/primitive.dat");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF("장우상");
		dos.writeDouble(95.5);
		dos.writeInt(1);
		
		dos.flush();	dos.close();	fos.close();
		
		FileInputStream fis = new FileInputStream("C:/Temp/primitive.dat");
		DataInputStream dis = new DataInputStream(fis);
		
		//DataOutputStream으로 출력했던 데이터를 다시 DataInputStream으로 가져오려면 출력한 순서와 동일한 순서로 읽어야 한다.
		//UTF - Double - int 순서
		
		String name = dis.readUTF();
		double score = dis.readDouble();
		int num = dis.readInt();
		System.out.println(name + " : " + num + " : " + score);
		
		dis.close();  fis.close();
	}

}
