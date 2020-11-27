package Practice.Lesson.ThreadPart.Function.E03_join;

public class JoinExample {
	/*
	 * �� ���� �����带 ���� ����۾��� �� ��, �� ������� ����� �ϰ�, ���ڴ� ������ ��갪�� ���� ����� �� ���
	 * �����尡 ���ÿ� ����ȴٸ�, ������ ������� ������ �����带 ��ٸ��� �ʱ� ������ �߸��� ���� ������ ����� �Ѵ�.
	 * �׷� ��츦 �����ϱ� ����, join() method�� ����Ѵ�.
	 */
	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		try {sumThread.join();} catch (InterruptedException e) {}
		//��ٸ� ��� ������.join()�� �ϸ� ���� �����尡 ���ڰ� ������ ��ٷȴٰ� ����� ������ �� �� ����� �����Ѵ�.
		System.out.println(sumThread.getSum());
	}

}
