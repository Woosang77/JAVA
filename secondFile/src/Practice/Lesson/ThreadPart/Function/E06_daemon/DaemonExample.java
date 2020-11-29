package Practice.Lesson.ThreadPart.Function.E06_daemon;

public class DaemonExample {
	/*
	 * 데몬 스레드는 주 스레드(메인 스레드)의 작업을 돕는 보조역할이다.
	 * 그렇기 때문에 주 스레드의 작업이 종료되면 데몬 스레드 또한 종료되어야한다. 
	 */

	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();		//메인 스레드 이외에 새로운 스레드를 생성한다.
		autoSaveThread.setDaemon(true);		//.setDaemon(boolean); 메소드는 boolean값이 true이면 해당 스레드가 데몬스레드가 된다.
		autoSaveThread.start();							//데몬 스레드를 생성하려면 반드시 setDaemon()메소드 후에 해당 메소드를 start()해야한다. (안그러면 오류남)
		try {Thread.sleep(5000);} catch (InterruptedException e) {}
		System.out.println("메인 스레드 종료");		//메인스레드가 종료되면 데몬 스레드도 같이 종료된다.
	}
}
