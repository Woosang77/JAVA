package Practice.Lesson.ThreadPart.State;

public class ThreadStateExample {

	public static void main(String[] args) {
		StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());
		statePrintThread.start();
	}
	/*타겟 스레드 상태 : NEW
타겟 스레드 상태 : RUNNABLE
타겟 스레드 상태 : RUNNABLE
타겟 스레드 상태 : TIMED_WAITING
타겟 스레드 상태 : TIMED_WAITING
타겟 스레드 상태 : TIMED_WAITING
타겟 스레드 상태 : TIMED_WAITING
타겟 스레드 상태 : TIMED_WAITING
타겟 스레드 상태 : TIMED_WAITING
타겟 스레드 상태 : TIMED_WAITING
타겟 스레드 상태 : RUNNABLE
타겟 스레드 상태 : RUNNABLE
타겟 스레드 상태 : RUNNABLE
타겟 스레드 상태 : TERMINATED*/
	/*
	 * 예제 설명 : TargetThread의 상태를 확인하는 StatePrintThread는
	 * TargetThread가 run() 한 번 하는것보다 훨씬 빠른 속도로 상태를 확인한다.
	 * 메인 메소드  new StatePrintThread(new TargetThread()); 에서 TargetThread가 생성된 상태이기 때문에
	 * NEW의 값을 가지고 있었고 NEW면 TargetThread가 시작하기 때문에 동시에 스레드 두 개가 시작되었다.
	 * 하나의 스레드는 큰 한바퀴를 돌고, 다른 스레드는 전자보다 빠르게 전자의 상태를 체크한다.
	 */
}
	