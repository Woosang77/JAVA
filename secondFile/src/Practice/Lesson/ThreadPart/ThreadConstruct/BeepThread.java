package Practice.Lesson.ThreadPart.ThreadConstruct;

import java.awt.Toolkit;
//Thread 하위 클래스를 통해 run() 메소드 오버라이딩 
public class BeepThread extends Thread{
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {Thread.sleep(500);} catch (Exception e) {}
		}
	}
}
