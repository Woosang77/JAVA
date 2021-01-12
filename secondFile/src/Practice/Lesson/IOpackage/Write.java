package Practice.Lesson.IOpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Write {

	public static void main(String[] args) throws Exception{
		File dir = new File("C:/Temp");
		File file = new File("C:/Temp/file.txt");
		File file2 = new File("C:/Temp/file2.txt");
		File picFile = new File("C:/Temp/wallpapertip_wallpaper-fotos_815432.jpg");
		File picFile2 = new File("C:/Temp/picFile.jpg");
		
		if (file.exists() == false) {file.createNewFile();}
		if (file2.exists() == false) {file2.createNewFile();}
		if (picFile.exists() == false) {picFile.createNewFile();}
		if (picFile2.exists() == false) {picFile2.createNewFile();}
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
//		File[] contents = dir.listFiles();
//		for (File file3 : contents) {
//			System.out.println(sdf.format(new Date(file3.lastModified())));
//		}
		
		FileInputStream fis = new FileInputStream(picFile);
		FileOutputStream fos = new FileOutputStream(picFile2);
		FileReader fr = new FileReader(file);
		FileWriter fw = new FileWriter(file2, true);
		
		int fileRead = 0;
		char[] charArr = new char[50];
		while ((fileRead = fr.read(charArr)) != -1) {
			String data = new String(charArr, 0, fileRead);
			System.out.println(data);
		}
		fr.close();
		
		String text = "Hello, nice to meet you too Woo-sang\n";
		fw.write(text);
		fw.flush();
		fw.close();
		
		byte[] byteArr = new byte[50];
		while ((fileRead = fis.read(byteArr)) != -1) {
			fos.write(byteArr, 0, fileRead);
		}
		fos.flush();
		fos.close();
		
	}

}
