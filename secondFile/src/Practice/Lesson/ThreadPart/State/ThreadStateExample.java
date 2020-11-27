package Practice.Lesson.ThreadPart.State;

public class ThreadStateExample {

	public static void main(String[] args) {
		StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());
		statePrintThread.start();
	}
	/*Ÿ�� ������ ���� : NEW
Ÿ�� ������ ���� : RUNNABLE
Ÿ�� ������ ���� : RUNNABLE
Ÿ�� ������ ���� : TIMED_WAITING
Ÿ�� ������ ���� : TIMED_WAITING
Ÿ�� ������ ���� : TIMED_WAITING
Ÿ�� ������ ���� : TIMED_WAITING
Ÿ�� ������ ���� : TIMED_WAITING
Ÿ�� ������ ���� : TIMED_WAITING
Ÿ�� ������ ���� : TIMED_WAITING
Ÿ�� ������ ���� : RUNNABLE
Ÿ�� ������ ���� : RUNNABLE
Ÿ�� ������ ���� : RUNNABLE
Ÿ�� ������ ���� : TERMINATED*/
	/*
	 * ���� ���� : TargetThread�� ���¸� Ȯ���ϴ� StatePrintThread��
	 * TargetThread�� run() �� �� �ϴ°ͺ��� �ξ� ���� �ӵ��� ���¸� Ȯ���Ѵ�.
	 * ���� �޼ҵ�  new StatePrintThread(new TargetThread()); ���� TargetThread�� ������ �����̱� ������
	 * NEW�� ���� ������ �־��� NEW�� TargetThread�� �����ϱ� ������ ���ÿ� ������ �� ���� ���۵Ǿ���.
	 * �ϳ��� ������� ū �ѹ����� ����, �ٸ� ������� ���ں��� ������ ������ ���¸� üũ�Ѵ�.
	 */
}
	