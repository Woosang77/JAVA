package Practice.Lesson.ThreadPart.Function.E06_daemon;

public class DaemonExample {
	/*
	 * ���� ������� �� ������(���� ������)�� �۾��� ���� ���������̴�.
	 * �׷��� ������ �� �������� �۾��� ����Ǹ� ���� ������ ���� ����Ǿ���Ѵ�. 
	 */

	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();		//���� ������ �̿ܿ� ���ο� �����带 �����Ѵ�.
		autoSaveThread.setDaemon(true);		//.setDaemon(boolean); �޼ҵ�� boolean���� true�̸� �ش� �����尡 ���󽺷��尡 �ȴ�.
		autoSaveThread.start();							//���� �����带 �����Ϸ��� �ݵ�� setDaemon()�޼ҵ� �Ŀ� �ش� �޼ҵ带 start()�ؾ��Ѵ�. (�ȱ׷��� ������)
		try {Thread.sleep(5000);} catch (InterruptedException e) {}
		System.out.println("���� ������ ����");		//���ν����尡 ����Ǹ� ���� �����嵵 ���� ����ȴ�.
	}
}
