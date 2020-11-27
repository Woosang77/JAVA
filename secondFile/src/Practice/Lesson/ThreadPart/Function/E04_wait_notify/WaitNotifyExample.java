package Practice.Lesson.ThreadPart.Function.E04_wait_notify;

public class WaitNotifyExample {
	/*wait() 와 notify() 를 사용해 databox에 producerThread가 값을 넣고, 
	consumerThread가 그 겂을 받아 출력하는 것을 순서있게 만듬.*/
	public static void main(String[] args) {
		DataBox dataBox = new DataBox();
		
		ProducerThread producerThread = new ProducerThread(dataBox);
		ConsumerThread consumerThread = new ConsumerThread(dataBox);
		
		producerThread.start();
		consumerThread.start();
	}
	/*
	 * ProducerThread가 입력한 데이터 : Data-1
		ConsumerThread가 가져온 데이터 :Data-1
		ProducerThread가 입력한 데이터 : Data-2
		ConsumerThread가 가져온 데이터 :Data-2
		ProducerThread가 입력한 데이터 : Data-3
		ConsumerThread가 가져온 데이터 :Data-3
	 */
}
