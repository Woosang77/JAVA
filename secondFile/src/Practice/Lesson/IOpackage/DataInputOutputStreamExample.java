package Practice.Lesson.IOpackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamExample {

	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("C:/Temp/primitive.dat");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF("����");
		dos.writeDouble(95.5);
		dos.writeInt(1);
		
		dos.flush();	dos.close();	fos.close();
		
		FileInputStream fis = new FileInputStream("C:/Temp/primitive.dat");
		DataInputStream dis = new DataInputStream(fis);
		
		//DataOutputStream���� ����ߴ� �����͸� �ٽ� DataInputStream���� ���������� ����� ������ ������ ������ �о�� �Ѵ�.
		//UTF - Double - int ����
		
		String name = dis.readUTF();
		double score = dis.readDouble();
		int num = dis.readInt();
		System.out.println(name + " : " + num + " : " + score);
		
		dis.close();  fis.close();
	}

}
