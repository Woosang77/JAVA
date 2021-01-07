package Practice.Lesson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Write {

	public static void main(String[] args) throws Exception{
		File dir = new File("C:/Temp");
		File file = new File("C:/Temp/file.txt");
		File file2 = new File("C:/Temp/file2.txt");
		
		if (file.exists() == false) {file.createNewFile();}
		if (file2.exists() == false) {file2.createNewFile();}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		File[] contents = dir.listFiles();
		for (File file3 : contents) {
			System.out.println(sdf.format(new Date(file3.lastModified())));
		}
		
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(file2, true);
		
		int fileRead = 0;
		byte[] fileByte = new byte[50];
		while ((fileRead = fis.read(fileByte)) != -1) {
			System.out.write(fileByte, 0, fileRead);
		}
		
		fis.close();
		String text = "Hello, nice to meet you too Woo-sang\n";
		byte[] textByte = text.getBytes();
		fos.write(textByte);
		fos.flush();
		
		
		
		fos.close();
		
		
		
	}

}
