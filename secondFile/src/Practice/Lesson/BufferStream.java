package Practice.Lesson;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferStream {

	public static void main(String[] args) throws Exception{
		//한글파일
		File file = new File("C:/Temp/file.txt");
		
		FileInputStream fis = new FileInputStream(file);
		Reader reader = new InputStreamReader(fis, "UTF-8");
		int readCharNo;
		char[] cbuf = new char [100];
		 
		while ((readCharNo = reader.read(cbuf)) != -1) {
			String data = new String(cbuf, 0, readCharNo);
			System.out.println(data);
		}
		
		
//		InputStream is = System.in;
//		Reader reader = new InputStreamReader(is);
//		System.out.println();
//		int readCharNo;
//		char[] cbuf = new char [100];
//		while ((readCharNo = reader.read(cbuf)) != -1) {
//			String data = new String(cbuf, 0, readCharNo);
//			System.out.println(data);
//		}
//		
//		reader.close();
	}

}
