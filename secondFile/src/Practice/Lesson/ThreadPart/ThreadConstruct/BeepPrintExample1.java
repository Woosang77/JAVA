package Practice.Lesson.ThreadPart.ThreadConstruct;

import java.awt.Toolkit;

public class BeepPrintExample1 {
	//작성 의도 : "띵"글자와 함께 소리가 5번 동시에 나는것.
	//싱글스레드는 위에서 순차적으로 실행되기 때문에 Beep소리가 끝나고 난 후에 "띵"이 반복됨
	
	public static void main(String[] args) {
		//비프음을 5번 반복해서 소리나게하는 작업
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
		}
		//"띵"문자열을 5번 출력하는 작업
		for(int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
		}
	}
}
