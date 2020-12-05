package Practice.Lesson.ThreadPart.Unsynchronized;

public class MainThreadExample {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		//������ü�� �̿��� ��� �����尡 ������ ��ü�� ���� �Ϻ��� �������� �ʴ´�.
		User1 user1 = new User1();
		user1.setCalculator(calculator);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start();
	}
	/*
	 * User1: 50 / User2: 50
	 * User1�� setMemory(100)�� �ϰ� 2�� ���� ����
	 * User2�� ������ü�� memory������ 50���� �ٲ��.
	 * �̷��� ������ ����ȭ ����, �޼ҵ尡 �ʿ���
	 */

}