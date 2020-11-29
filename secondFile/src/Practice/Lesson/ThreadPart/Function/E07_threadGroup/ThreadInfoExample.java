package Practice.Lesson.ThreadPart.Function.E07_threadGroup;

import java.util.Map;
import java.util.Set;

public class ThreadInfoExample {

	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setName("AutoSaveThread");
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();
		
		//프로세스에서 실행하는 모든 Thread를 가져온다.
		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		Set<Thread> threads = map.keySet();
		for (Thread thread : threads) {
			System.out.println("Name : " + thread.getName() 
							+ ((thread.isDaemon()) ? "(데몬)" : "(주)"));
			System.out.println("\t" + "소속그룹: " + thread.getThreadGroup().getName());
			System.out.println();
		}
	}
		//<RESULT>
		//	Name : AutoSaveThread(데몬)   --이 스레드는 main스레드 안에서 만들었기 때문에 main그룹 안에 있다.
		//	소속그룹: main
		//
		//Name : Finalizer(데몬)
		//	소속그룹: system
		//
		//Name : Attach Listener(데몬)
		//	소속그룹: system
		//
		//Name : Reference Handler(데몬)
		//	소속그룹: system
		//
		//Name : Signal Dispatcher(데몬)
		//	소속그룹: system
		//
		//Name : main(주)
		//	소속그룹: main

}
