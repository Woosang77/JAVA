package Practice.Lesson.ThreadPart.Function.E04_wait_notify;

public class ConsumerThread extends Thread{
	private DataBox databox;
	
	public ConsumerThread(DataBox dataBox) {
		this.databox = dataBox;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			databox.getData();
		}
	}
}