package Practice.Lesson.ThreadPart.Unsynchronized;

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
	 * User1: 50 / User2: 50
	 * User1이 setMemory(100)을 하고 2초 쉬는 동안
	 * User2가 공유객체의 memory정보를 50으로 바꿨다.
	 * 이렇기 때문에 동기화 블록, 메소드가 필요함
	 */

}
