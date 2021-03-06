package Practice.Lesson.ThreadPart.ThreadConstruct;

import java.awt.Toolkit;

public class BeepPrintExample2 {	
	//작성 의도 : Runnable 인터페이스를 구현하여 Thread직접 생성
	public static void main(String[] args) {
		
		/* how 1
		 * Runnable beepTask = new BeepTask();
		 * Thread thread = new Thread(beepTask);
		 * thread.start();
		 * 
		 * Runnable을 구현하는 객체를 동작을 하는 것이지, 실제 스레드 객체가 아니다.
		 * 그렇기 떄문에 Runnable을 구현하는 beepTask를 매개값으로 사용한 thread를 만들어야한다. 
		 * 그리고 start()메소드를 실행하면 Runnable구현객체에서 run()을 실행시킨다. 
		 */
		
		//how2
		//Runnable을 구현하는 객체를 만들고 new Thread()의 매개값으로 객체를 넘기는 것이 아니고,
		// new Runnable() 익명자식 객체를 생성(how 1의 beepTask와 같다.)하고 자체적으로 Override를 하는 것.
		/*Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				//비프음을 5번 반복해서 소리나게하는 작업
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i = 0; i < 5; i++) {
					toolkit.beep();
					try {Thread.sleep(500);} catch (Exception e) {}
				}
			}
		});
		thread.start();*/
		
		//how3 람다식을 사용하는 것
		Thread thread = new Thread( () -> {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			for(int i = 0; i < 5; i++) {
				toolkit.beep();
				try {Thread.sleep(500);} catch (Exception e) {}
			}
		});
		thread.start();
		
		//"띵"문자열을 5번 출력하는 작업
		for(int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
		}
		/*
		 * 순차적으로 실행하는 것이면, thread.start();이후에 "띵"문자가 출력하는것은 아니다.
		 * main스레드에서는 thread.start();의 동작을 기다리는 것이아니고 바로 다음 동작을 실행한다.
		 * 그렇기 때문에 동시에 작동한다.
		 * 또한 thread.start();는 한번 실행하면 같은 스레드를 다시 실행할 수 없다.
		 */
	}
}
