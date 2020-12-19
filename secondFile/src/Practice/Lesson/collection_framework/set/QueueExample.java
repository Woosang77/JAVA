package Practice.Lesson.collection_framework.set;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<>();
		
		messageQueue.offer(new Message("������ ������", "ȫ�浿"));
		messageQueue.offer(new Message("SMS", "��ö��"));
		messageQueue.offer(new Message("Kakao", "��â��"));
		
		while (!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			System.out.println(message.command + " " + message.to);
			//			������ ������ ȫ�浿
			//			SMS ��ö��
			//			Kakao ��â��
			//Queue�� FIFO�� ��ǥ���� �������̽��̴�. ���Լ��� ������ �Է¹��� ������� ��µȴ�.
		}
	}

}
