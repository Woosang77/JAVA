package Practice.Lesson.ThreadPart.Function.E05_stop;

public class PrintThread1 extends Thread	{
	//�����带 �����ϴ� ������� stop()�޼ҵ尡 �־��µ�, run()�۵� ���� �� �����尡 ���ڱ� �����Ǹ�, ����ϴ� �����̳� ��Ʈ��ũ ����� ���� �ڿ����� 
	//�Ҿ����� ���·� �������� ������ deprecated�Ǿ���.
	
	//�׷��� �����߿� ���������� ��Ű�� ���ؼ��� stop flag�� ����Ͽ� �����Ѵ�.
	
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	@Override
	public void run() {
		//run()�ȿ� stop(boolean)�� ���Ե� while���� �־�ΰ�, ���ν����� start ��, Ư�� ������ �´´ٸ� stop boolean�� �ٲ��ָ鼭 ������ �����Ų��. 
		while (!stop) {
			System.out.println("������");
		}
		System.out.println("�ڿ�����");
		System.out.println("���� ����");
	}
}
