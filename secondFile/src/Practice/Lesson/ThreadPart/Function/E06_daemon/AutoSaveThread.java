package Practice.Lesson.ThreadPart.Function.E06_daemon;

public class AutoSaveThread extends Thread{
	public void save() {
		System.out.println("작업내용 저장");
	}
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
			save();
		}
	}
}
