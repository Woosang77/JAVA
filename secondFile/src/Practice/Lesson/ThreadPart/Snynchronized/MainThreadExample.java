package Practice.Lesson.ThreadPart.Snynchronized;

public class MainThreadExample {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		//공유객체를 이용할 경우 스레드가 지정한 객체의 값이 완벽히 보존되지 않는다.
		
		User1 user1 = new User1();
		user1.setCalculator(calculator);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start();
	}
	/*
	 * User1: 100 / User2: 50
	 * main에서 user1.start()를 통해 User1이 setMemory(100)하면 Calculator객체에서
	 * 실행하고 2초 쉬는 동안 User2에서 start()를 통해 실행되더라도, synchronized된 setMemory는
	 * user1의 동작이 마무리 되지 않는 이상 끝나지 않는다.
	 */

}
