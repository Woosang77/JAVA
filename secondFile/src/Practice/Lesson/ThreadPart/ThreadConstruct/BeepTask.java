package Practice.Lesson.ThreadPart.ThreadConstruct;

import java.awt.Toolkit;

public class BeepTask implements Runnable {
	/*Runnable : 작업 스레드가 실행할 수 있는 코드를 가지고 있는 객체 , 
	 * 하나뿐인 run()을 반드시 재정의 시켜야하고, 메소드안에 스레드가 실행할 코드를 작성한다.
	*/
	@Override
	public void run() {
		//비프음을 5번 반복해서 소리나게하는 작업
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0; i < 5; i++) {
			toolkit.beep();
			try {Thread.sleep(500);} catch (Exception e) {}
		}
	}
}
