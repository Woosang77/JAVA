package Practice.Lesson.ThreadPart.ThreadName;

public class ThreadNameExample {

	public static void main(String[] args) {
		//모든 스레드에는 이름이 있다. main Thread는 "main"
		//작업 스레드는 "Thread - n"이다.
		//각각 할당되는 이름들을 변경할 수 있다.(setname)
		Thread thread = Thread.currentThread();
		System.out.println("프로그램 시작 스레드 이름 : " +thread.getName());
		
		Thread thread2 = new ThreadA();
		System.out.println("ThreadA를 생성한 스레드 " +Thread.currentThread().getName());		
		thread2.start();
		
		//현재 thread2가 이미 .start();된 상태에서는 다시thread2.start();를 실행할 수 없다.
		
		Thread thread3 = new ThreadB();
		thread3.start();
	}

}
