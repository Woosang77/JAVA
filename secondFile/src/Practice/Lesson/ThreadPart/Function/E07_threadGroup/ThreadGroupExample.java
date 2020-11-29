package Practice.Lesson.ThreadPart.Function.E07_threadGroup;

public class ThreadGroupExample {

	public static void main(String[] args) {
		ThreadGroup myGroup = new ThreadGroup("myGroup");
		WorkThread workThreadA = new WorkThread(myGroup, "workThreadA");
		WorkThread workThreadB = new WorkThread(myGroup, "workThreadB");
		
		workThreadA.start();
		workThreadB.start();
		
		System.out.println("[ main ������ �׷��� list() �޼ҵ� ��� ���� ]");
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		mainGroup.list();
//		[ main ������ �׷��� list() �޼ҵ� ��� ���� ]
//				java.lang.ThreadGroup[name=main,maxpri=10]
//				    Thread[main,5,main]
//				    java.lang.ThreadGroup[name=myGroup,maxpri=10]
//				        Thread[workThreadA,5,myGroup]
//				        Thread[workThreadB,5,myGroup]
		System.out.println();
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {	}
		
		System.out.println("[ myGroup ������ �׷��� interrupt() �޼ҵ� ȣ�� ]");
		mainGroup.interrupt();
	}
//		[ myGroup ������ �׷��� interrupt() �޼ҵ� ȣ�� ]
//				workThreadB interrupted
//				workThreadB�����
//				workThreadA interrupted
//				workThreadA�����

}
