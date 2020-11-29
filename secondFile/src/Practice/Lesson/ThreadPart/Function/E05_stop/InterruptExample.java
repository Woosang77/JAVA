package Practice.Lesson.ThreadPart.Function.E05_stop;

public class InterruptExample {

	public static void main(String[] args) {
		Thread thread = new PrintThread2();
		thread.start();
		
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		
		thread.interrupt();
		//.interrupt()메소드가 실행되면 thread가 실행대기, 실행 상태에 있을 때 예외가 발생하지 않고,
		//스레드가 미래에 일시정지상태가 되면 예외를 발생시킨다.
		//.interrupt()가 실행되면 대상 메소드가 그 후에도 일시정지 상태가 되는지 지켜본다는 뜻인가
		
	}

}
