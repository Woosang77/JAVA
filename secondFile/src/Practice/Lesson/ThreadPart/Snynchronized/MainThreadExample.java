package Practice.Lesson.ThreadPart.Snynchronized;

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
	 * User1: 100 / User2: 50
	 * main���� user1.start()�� ���� User1�� setMemory(100)�ϸ� Calculator��ü����
	 * �����ϰ� 2�� ���� ���� User2���� start()�� ���� ����Ǵ���, synchronized�� setMemory��
	 * user1�� ������ ������ ���� �ʴ� �̻� ������ �ʴ´�.
	 */

}
