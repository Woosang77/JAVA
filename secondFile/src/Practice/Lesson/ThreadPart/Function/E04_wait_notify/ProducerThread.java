package Practice.Lesson.ThreadPart.Function.E04_wait_notify;

public class ProducerThread extends Thread{
	private DataBox databox;
	
	public ProducerThread(DataBox dataBox) {
		this.databox = dataBox;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			String data = "Data-" + i;
			databox.setData(data);
		}
	}
}
