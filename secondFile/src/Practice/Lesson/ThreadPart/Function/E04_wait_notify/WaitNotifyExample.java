package Practice.Lesson.ThreadPart.Function.E04_wait_notify;

public class WaitNotifyExample {
	/*wait() �� notify() �� ����� databox�� producerThread�� ���� �ְ�, 
	consumerThread�� �� ���� �޾� ����ϴ� ���� �����ְ� ����.*/
	public static void main(String[] args) {
		DataBox dataBox = new DataBox();
		
		ProducerThread producerThread = new ProducerThread(dataBox);
		ConsumerThread consumerThread = new ConsumerThread(dataBox);
		
		producerThread.start();
		consumerThread.start();
	}
	/*
	 * ProducerThread�� �Է��� ������ : Data-1
		ConsumerThread�� ������ ������ :Data-1
		ProducerThread�� �Է��� ������ : Data-2
		ConsumerThread�� ������ ������ :Data-2
		ProducerThread�� �Է��� ������ : Data-3
		ConsumerThread�� ������ ������ :Data-3
	 */
}