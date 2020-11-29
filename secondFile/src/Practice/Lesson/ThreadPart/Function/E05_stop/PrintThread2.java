package Practice.Lesson.ThreadPart.Function.E05_stop;

public class PrintThread2 extends Thread{
	@Override
	public void run() {
//		try {
//			while(true) {
//				System.out.println("실행 중");
//			//	Thread.sleep(1);		//main 스레드 1초 일시정지 후 .interrupt()메소드 실행시 InterruptedException 발생
//			//Thread.sleep(1);처럼 강제로 일시정지를 만드는 것을 좋지 않다.
//			}
//		} catch (InterruptedException e) {
//		}
		
		while (true) {
			System.out.println("실행 중");
			if (Thread.interrupted()) {	//.interrupted()는 해당 스레드의 interrupt() 호출여부를 boolean으로 리턴한다.
				break;								//Thread(정적 스레드)는 .interrupted()
			}											//인스턴스 스레드는 .isInterrupted()
		}
		System.out.println("자원 정리");
		System.out.println("종료");
	}
}
