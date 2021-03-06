package Practice.Lesson.ThreadPart.ThreadConstruct;

import java.awt.Toolkit;

public class BeepPrintExample3 {	
	//작성 의도 : Thread Class를 상속받아 하위클래스를 통해 Thread 생성
	/*
	 * 스레드를 만드는 방법은 이와 같이 두 가지가 있지만 인터페이스활용을 통한 스레드 생성을 많이한다.
	 * 다중 상속이 안되기 때문에 스레드를 상속한 클래스는 사용이 제한적이기 때문이다.
	 */
	public static void main(String[] args) {
		
		//how1 - 하위 객체를 미리 정의 후 갖다 쓰기
		/*Thread thread = new BeepThread();
		thread.start();*/
		
		//how2 - 다른 클래스에 객체를 정의 하는 것이 아니라 부모(Thread)클래스의 익명의 자식객체를 내부에서 오버라이딩하는 것.
		Thread thread = new Thread() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					try {Thread.sleep(500);} catch (Exception e) {}
				}
			}
		};
		thread.start();
		
		//"띵"문자열을 5번 출력하는 작업
		for(int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
		}
	}
}
