package Practice.Lesson.ThreadPart.Function.E07_threadGroup;

public class TestRun implements Runnable{
	
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {	
				System.out.println(Thread.currentThread().getName() + "Interrupt ȣ�� ��");
				break;
			}
			System.out.println(Thread.currentThread().getName() + " ����!!");
		}
		System.out.println(Thread.currentThread().getName() + " �Ҹ� �Ф�");
	}
}
