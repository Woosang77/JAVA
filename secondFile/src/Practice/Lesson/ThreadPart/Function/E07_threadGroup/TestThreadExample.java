package Practice.Lesson.ThreadPart.Function.E07_threadGroup;

public class TestThreadExample {

	public static void main(String[] args) {
		//Runnable interface
		Runnable testRun = new TestRun();
		//ThreadGroup
		ThreadGroup upperThreadGroup = new ThreadGroup("upperThreadGroup");
		ThreadGroup lowerThreadGroup = new ThreadGroup(upperThreadGroup, "lowerThreadGroup");
		//Thread
		Thread upperThreadA = new Thread(upperThreadGroup, testRun, "upperThreadA");
		Thread upperThreadB = new Thread(upperThreadGroup, testRun, "upperThreadB");
		Thread lowerThreadC = new Thread(lowerThreadGroup, testRun, "lowerThreadC");
		Thread lowerThreadD = new Thread(lowerThreadGroup, testRun, "lowerThreadD");
		
		upperThreadA.start();
		upperThreadB.start();
		lowerThreadC.start();
		lowerThreadD.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.getStackTrace();
		}
		
		lowerThreadGroup.interrupt();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.getStackTrace();
		}
		
		upperThreadGroup.list();
		lowerThreadGroup.destroy();
		boolean flag = lowerThreadGroup.isDestroyed();
		if(flag) {System.out.println("lowerThreadGroup is destroyed.");
		}else {System.out.println("lowerThreadGroup is not destroyed.");
		}
		upperThreadGroup.list();
		upperThreadGroup.interrupt();
		
	}

}
