package Practice.Lesson.ThreadPart.State;

public class TargetThread extends Thread{
	//TargetThread��ü�� �����Ǹ� ���´� NEW�� �ȴ�.
	
	//run�޼ҵ� ������
	@Override 
	public void run() {
		//10��� ������ ���� RUNNABLE ���� ����
		for (long i = 0; i < 1000000000; i++) {}
		//.sleep�޼ҵ带 ���� 1.5�ʰ� TIME_WAITING���� ����
		try {Thread.sleep(1500);} catch (Exception e) {}
		//�ٽ� 10��� ������ ���� RUNNABLE ���� ����
		for (long i = 0; i < 1000000000; i++) {}
	}
}
