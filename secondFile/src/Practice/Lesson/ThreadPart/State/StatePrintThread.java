package Practice.Lesson.ThreadPart.State;

public class StatePrintThread extends Thread{
	//상태를 조사할 스레드 targetThread 인스턴스 생성
	private Thread targetThread;
	
	public StatePrintThread(Thread targetThread	) {
		this.targetThread = targetThread;
	}
	
	@Override
	public void run() {
		while (true) {
			Thread.State state = targetThread.getState();
			System.out.println("타겟 스레드 상태 : " + state);
			
			if (state == Thread.State.NEW) {
				targetThread.start();
			}
			if (state == Thread.State.TERMINATED) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (Exception e) {}
			
		}
	}
	
}
