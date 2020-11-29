package Practice.Lesson.ThreadPart.Function.E05_stop;

class A implements Runnable {
	
	
	@Override
	public void run() {
//		try {
//			while (!Thread.currentThread().isInterrupted()) {
//				System.out.println("스레드 동작");
//				Thread.sleep(100);
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} finally {
//			System.out.println("\n종료");
//		}
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println("스레드 동작");
		}
		System.out.println("종료");
	}
	
	void process() {
		Runnable interruptThread = new A();
		Thread thread = new Thread(interruptThread);
		thread.start();
		try {
			Thread.sleep(2000); //이 문장에서의 Thread는 process()메소드가 진행중인 main 스레드이고 메인 스레드를 2초간 멈추면서 thread.interrupt();를 대기한다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}
}

public class InterruptedThread {

	public static void main(String[] args) {
		System.out.println("시작");
		A ATest = new A();
		ATest.process();
	}

}
