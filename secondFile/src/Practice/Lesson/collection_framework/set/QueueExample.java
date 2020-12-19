package Practice.Lesson.collection_framework.set;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<>();
		
		messageQueue.offer(new Message("메일을 보내라", "홍길동"));
		messageQueue.offer(new Message("SMS", "김철수"));
		messageQueue.offer(new Message("Kakao", "김창수"));
		
		while (!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			System.out.println(message.command + " " + message.to);
			//			메일을 보내라 홍길동
			//			SMS 김철수
			//			Kakao 김창수
			//Queue는 FIFO의 대표적인 인터페이스이다. 선입선출 법으로 입력받은 순서대로 출력된다.
		}
	}

}
