package Practice.Lesson.ThreadPart.Function.E03_join;

public class JoinExample {
	/*
	 * 두 개의 스레드를 통해 계산작업을 할 때, 한 스레드는 계산을 하고, 후자는 전자의 계산값을 통해 계산을 할 경우
	 * 스레드가 동시에 진행된다면, 후자의 스레드는 전자의 스레드를 기다리지 않기 때문에 잘못된 값을 가지고 계산을 한다.
	 * 그런 경우를 방지하기 위해, join() method를 사용한다.
	 */
	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		try {sumThread.join();} catch (InterruptedException e) {}
		//기다릴 대상 스레드.join()을 하면 후자 스레드가 전자가 끝나길 기다렸다가 계산이 끝나면 그 때 계산을 시작한다.
		System.out.println(sumThread.getSum());
	}

}
