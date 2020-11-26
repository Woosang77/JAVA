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
			FileReader filereader = new FileReader("C:\\Users\\wooju\\OneDrive\\바탕 화면\\Test.txt");
			while ((charChar = filereader.read()) != -1) {
				if (charChar == 32) {spaceCnt++;}
				if (charChar != 32) {charCnt++;}
			}
			filereader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("잘못된 입출력입니다.");
		}
		System.out.println("\r 파일 속 공백 숫자는 : " +spaceCnt );
		System.out.println("\r 파일 속 공백을 제외한 문자의 숫자는 : " + charCnt);
		System.out.println("\r 파일 속 공백을 포함한 문자의 숫자는 : " + (spaceCnt + charCnt));
	}

}
