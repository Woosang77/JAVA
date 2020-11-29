package Practice.Lesson.ThreadPart.Function.E07_threadGroup;

public class ThreadGroupExample {

	public static void main(String[] args) {
		ThreadGroup myGroup = new ThreadGroup("myGroup");
		WorkThread workThreadA = new WorkThread(myGroup, "workThreadA");
		WorkThread workThreadB = new WorkThread(myGroup, "workThreadB");
		
		workThreadA.start();
		workThreadB.start();
		
		System.out.println("[ main 스레드 그룹의 list() 메소드 출력 내용 ]");
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		mainGroup.list();
//		[ main 스레드 그룹의 list() 메소드 출력 내용 ]
//				java.lang.ThreadGroup[name=main,maxpri=10]
//				    Thread[main,5,main]
//				    java.lang.ThreadGroup[name=myGroup,maxpri=10]
//				        Thread[workThreadA,5,myGroup]
//				        Thread[workThreadB,5,myGroup]
		System.out.println();
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {	}
		
		System.out.println("[ myGroup 스레드 그룹의 interrupt() 메소드 호출 ]");
		mainGroup.interrupt();
	}
//		[ myGroup 스레드 그룹의 interrupt() 메소드 호출 ]
//				workThreadB interrupted
//				workThreadB종료됨
//				workThreadA interrupted
//				workThreadA종료됨

}
