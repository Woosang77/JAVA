package Practice.Lesson.ThreadPart.Function.E02_yield;


public class YieldExample {
/*yield�� �� �� �̻��� ������ �� �� �����尡 ���ǹ��� �ݺ����� ���,
 * �ٸ� �����忡�� ������ �纸�ϰ�, �ڽ��� ���� ��� ���·� ����.
 */
	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		threadA.start();
		threadB.start();
		
		try {Thread.sleep(3000);} catch (Exception e) {}
		//Thread A,B ���ÿ� ���� ��Ű��, main Thread 3�ʵ��� �Ͻ�����(3�ʵ����� A,B�� ���� �ְ� �����鼭 �����)
		threadA.work = false;
		//ThreadA work�� false�� �ٲ�鼭, yield()�޼ҵ尡 ����ǰ�, ThreadA�� ��������� B���� �Ѱ��ְ� ������ ���·� ���ư� ����
		//�ٽ� �����ϰ� �; work�� false�̱� ������ ��� �纸�Ѵ�.
		
		try {Thread.sleep(3000);} catch (Exception e) {}
		//main Thread�� 3�ʵ��� �Ͻ�����(ThreadB�� ��� ������)
		threadA.work = true;
		//ThreadA work�� true�� �ٲ�鼭, �ٽ� �Ѵ� ����
		
		try {Thread.sleep(3000);} catch (Exception e) {}
		//main Thread�� �ٽ� 3�ʰ� �Ͻ�����(Thread A,B �� �� ������)
		threadA.stop = true;
		threadB.stop = true;
		//Thread A,B�� stop�� true�� �ٲ�鼭 �� �� �۾� ����(TERMINATED)
	}
}
