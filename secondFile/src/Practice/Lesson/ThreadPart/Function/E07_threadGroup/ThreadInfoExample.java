package Practice.Lesson.ThreadPart.Function.E07_threadGroup;

import java.util.Map;
import java.util.Set;

public class ThreadInfoExample {

	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setName("AutoSaveThread");
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();
		
		//���μ������� �����ϴ� ��� Thread�� �����´�.
		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		Set<Thread> threads = map.keySet();
		for (Thread thread : threads) {
			System.out.println("Name : " + thread.getName() 
							+ ((thread.isDaemon()) ? "(����)" : "(��)"));
			System.out.println("\t" + "�Ҽӱ׷�: " + thread.getThreadGroup().getName());
			System.out.println();
		}
	}
		//<RESULT>
		//	Name : AutoSaveThread(����)   --�� ������� main������ �ȿ��� ������� ������ main�׷� �ȿ� �ִ�.
		//	�Ҽӱ׷�: main
		//
		//Name : Finalizer(����)
		//	�Ҽӱ׷�: system
		//
		//Name : Attach Listener(����)
		//	�Ҽӱ׷�: system
		//
		//Name : Reference Handler(����)
		//	�Ҽӱ׷�: system
		//
		//Name : Signal Dispatcher(����)
		//	�Ҽӱ׷�: system
		//
		//Name : main(��)
		//	�Ҽӱ׷�: main

}
