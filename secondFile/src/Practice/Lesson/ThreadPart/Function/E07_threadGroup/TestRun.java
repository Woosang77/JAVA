package Practice.Lesson.ThreadPart.Function.E07_threadGroup;

public class TestRun implements Runnable{
	
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {	
				System.out.println(Thread.currentThread().getName() + "Interrupt »£√‚ µ ");
				break;
			}
			System.out.println(Thread.currentThread().getName() + " µÓ¿Â!!");
		}
		System.out.println(Thread.currentThread().getName() + " º“∏Í §–§–");
	}
}
