package Practice.Lesson.ThreadPart.Function;

import java.awt.Toolkit;

public class E01_sleep {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 10	; i++) {
			toolkit.beep();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

//Thread.sleep(1000);   :   main 스레드를 1000millis 동안 일시정지 상태로 만들고,
//시간이 끝나면 다시 실행 대기 상태로 돌린다.