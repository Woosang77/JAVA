package Practice.Lesson.CountTxt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadChar {

	public static void countChar(String[] args) {	
		int charChar = 0;
		int charCnt = 0;
		int spaceCnt = 0;
		
		try {
			FileReader filereader = new FileReader("C:\\Users\\wooju\\OneDrive\\���� ȭ��\\Test.txt");
			while ((charChar = filereader.read()) != -1) {
				if (charChar == 32) {spaceCnt++;}
				if (charChar != 32) {charCnt++;}
			}
			filereader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("�߸��� ������Դϴ�.");
		}
		System.out.println("\r ���� �� ���� ���ڴ� : " +spaceCnt );
		System.out.println("\r ���� �� ������ ������ ������ ���ڴ� : " + charCnt);
		System.out.println("\r ���� �� ������ ������ ������ ���ڴ� : " + (spaceCnt + charCnt));
	}

}
