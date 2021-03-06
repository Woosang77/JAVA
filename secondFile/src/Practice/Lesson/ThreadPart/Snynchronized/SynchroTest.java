package Practice.Lesson.ThreadPart.Snynchronized;

public class SynchroTest {

	public static void main(String[] args) {
		Runnable run = new A();
		
		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run);
		
		t1.start();
		t2.start();
	}
	/*
	 * balance : 800
		balance : 800
		balance : 600
		balance : 300
		balance : 0
		balance : -300  ====> 예금 계좌가 음수가 나온다.
		Thread t1, t2 모두 Runnable을 구현하는 run객체를 파라미터로 받는데, run은 Account객체를 공유객체로 지닌다.
	 */

		//공유객체에 synchronized 추가 후 
		/*balance : 700
			balance : 600
			balance : 500
			balance : 300
			balance : 100
			balance : 100
			balance : 0
			balance : 0
			*/
	
	/*
	Thread-0balance : 4700
	Thread-1balance : 4400
	Thread-0balance : 4300
	Thread-1balance : 4100
	Thread-0balance : 4000
	Thread-1balance : 3800
	Thread-0balance : 3500
	*/
	/*각각의 스레드가 임계영역으로 들어가는 순서를 보여준다.
	 * 0번 스레드가 임계영역(withdraw)를 지나 lock을 반납하면 대기중인 1번스레드가 들어간다.
	 * 위와 같은 동작을 반복한다.
	 */
}

class Account {
	int balance = 5000;
	
	public synchronized void withdraw(int money) {
		if(balance >= money) {
			try {Thread.sleep(1000);} catch (Exception e) {}
			balance -= money;
		}
	}
}

class A implements Runnable	{
	Account ac = new Account();
	
	@Override
	public void run() {
		while(ac.balance > 0 ) {
			int money = (int)(Math.random() * 3 + 1) * 100;
			ac.withdraw(money);
			System.out.println(Thread.currentThread().getName() + "balance : " + ac.balance);
		}
	}
}