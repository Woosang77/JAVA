package Practice.Lesson.ThreadPart.Function.E05_stop;

public class InterruptExample {

	public static void main(String[] args) {
		Thread thread = new PrintThread2();
		thread.start();
		
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		
		thread.interrupt();
		//.interrupt()�޼ҵ尡 ����Ǹ� thread�� ������, ���� ���¿� ���� �� ���ܰ� �߻����� �ʰ�,
		//�����尡 �̷��� �Ͻ��������°� �Ǹ� ���ܸ� �߻���Ų��.
		//.interrupt()�� ����Ǹ� ��� �޼ҵ尡 �� �Ŀ��� �Ͻ����� ���°� �Ǵ��� ���Ѻ��ٴ� ���ΰ�
		
	}

}
