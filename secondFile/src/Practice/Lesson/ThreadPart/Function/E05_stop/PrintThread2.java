package Practice.Lesson.ThreadPart.Function.E05_stop;

public class PrintThread2 extends Thread{
	@Override
	public void run() {
//		try {
//			while(true) {
//				System.out.println("���� ��");
//			//	Thread.sleep(1);		//main ������ 1�� �Ͻ����� �� .interrupt()�޼ҵ� ����� InterruptedException �߻�
//			//Thread.sleep(1);ó�� ������ �Ͻ������� ����� ���� ���� �ʴ�.
//			}
//		} catch (InterruptedException e) {
//		}
		
		while (true) {
			System.out.println("���� ��");
			if (Thread.interrupted()) {	//.interrupted()�� �ش� �������� interrupt() ȣ�⿩�θ� boolean���� �����Ѵ�.
				break;								//Thread(���� ������)�� .interrupted()
			}											//�ν��Ͻ� ������� .isInterrupted()
		}
		System.out.println("�ڿ� ����");
		System.out.println("����");
	}
}
