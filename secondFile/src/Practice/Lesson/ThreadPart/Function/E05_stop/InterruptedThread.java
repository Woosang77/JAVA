package Practice.Lesson.ThreadPart.Function.E05_stop;

class A implements Runnable {
	
	
	@Override
	public void run() {
//		try {
//			while (!Thread.currentThread().isInterrupted()) {
//				System.out.println("������ ����");
//				Thread.sleep(100);
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} finally {
//			System.out.println("\n����");
//		}
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println("������ ����");
		}
		System.out.println("����");
	}
	
	void process() {
		Runnable interruptThread = new A();
		Thread thread = new Thread(interruptThread);
		thread.start();
		try {
			Thread.sleep(2000); //�� ���忡���� Thread�� process()�޼ҵ尡 �������� main �������̰� ���� �����带 2�ʰ� ���߸鼭 thread.interrupt();�� ����Ѵ�.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}
}

public class InterruptedThread {

	public static void main(String[] args) {
		System.out.println("����");
		A ATest = new A();
		ATest.process();
	}

}
