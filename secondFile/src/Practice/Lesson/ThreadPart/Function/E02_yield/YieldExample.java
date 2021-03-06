package Practice.Lesson.ThreadPart.Function.E02_yield;


public class YieldExample {
/*yield는 두 개 이상의 스레드 중 한 스레드가 무의미한 반복중일 경우,
 * 다른 스레드에게 실행을 양보하고, 자신은 실행 대기 상태로 간다.
 */
	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		threadA.start();
		threadB.start();
		
		try {Thread.sleep(3000);} catch (Exception e) {}
		//Thread A,B 동시에 실행 시키고, main Thread 3초동안 일시정지(3초동안은 A,B가 같이 주고 받으면서 실행됨)
		threadA.work = false;
		//ThreadA work가 false로 바뀌면서, yield()메소드가 실행되고, ThreadA는 실행순서를 B에게 넘겨주고 실행대기 상태로 돌아간 다음
		//다시 실행하고 싶어도 work가 false이기 때문에 계속 양보한다.
		
		try {Thread.sleep(3000);} catch (Exception e) {}
		//main Thread가 3초동안 일시정지(ThreadB만 계속 실행중)
		threadA.work = true;
		//ThreadA work가 true로 바뀌면서, 다시 둘다 실행
		
		try {Thread.sleep(3000);} catch (Exception e) {}
		//main Thread가 다시 3초간 일시정지(Thread A,B 둘 다 진행중)
		threadA.stop = true;
		threadB.stop = true;
		//Thread A,B의 stop이 true로 바뀌면서 둘 다 작업 종료(TERMINATED)
	}
}
