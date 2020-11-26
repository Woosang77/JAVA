package Practice.Lesson.ThreadPart.ThreadName;

public class ThreadA extends Thread{
	
	public ThreadA() {
		setName("ThreadA");
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "°¡ Ãâ·ÂµÊ");
		}
	}

}
