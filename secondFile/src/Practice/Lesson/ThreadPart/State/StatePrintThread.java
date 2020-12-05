package Practice.Lesson.ThreadPart.State;

public class StatePrintThread extends Thread{
	//���¸� ������ ������ targetThread �ν��Ͻ� ����
	private Thread targetThread;
	
	public StatePrintThread(Thread targetThread	) {
		this.targetThread = targetThread;
	}
	
	@Override
	public void run() {
		while (true) {
			Thread.State state = targetThread.getState();
			System.out.println("Ÿ�� ������ ���� : " + state);
			
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