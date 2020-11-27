package Practice.Lesson.ThreadPart.State;

public class TargetThread extends Thread{
	//TargetThread객체가 생성되면 상태는 NEW로 된다.
	
	//run메소드 재정의
	@Override 
	public void run() {
		//10억번 루핑을 통해 RUNNABLE 상태 유지
		for (long i = 0; i < 1000000000; i++) {}
		//.sleep메소드를 통해 1.5초간 TIME_WAITING상태 유지
		try {Thread.sleep(1500);} catch (Exception e) {}
		//다시 10억번 루핑을 통해 RUNNABLE 상태 유지
		for (long i = 0; i < 1000000000; i++) {}
	}
}
