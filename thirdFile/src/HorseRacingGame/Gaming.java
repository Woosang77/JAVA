package HorseRacingGame;

import java.util.Scanner;

public class Gaming {
	Scanner sc = new Scanner(System.in);
	private Identify userIdentify;
	private int money;
	Management method = new Management();
	
	//management���� 1�� ������ ���̵� ������ ����
	public void gameStarting(Identify identify) {
		boolean playable = false;
		boolean flag = true;
		userIdentify = identify;
		do {
			System.out.println("===============");
			System.out.println(userIdentify.getName() + "�� ȯ���մϴ�.");
			System.out.println("===============");
			System.out.println(
					"1. ������" + 
					"\n2. �����" + 
					"\n3. ������"
					);
			System.out.print("��ȣ�� �����ּ��� : ");
			int num = sc.nextInt(	);
			sc.nextLine();
			if (num == 3) {
				System.out.println("���� ȭ������ �̵��մϴ�.");
				break;
			}
			switch (num) {
			case 1:
				//������
				System.out.println("�����忡 ���Ű� ȯ���մϴ�.");
				System.out.println("���� �ܰ� : " + userIdentify.getMoney() + "��");
				if (userIdentify.getMoney() < 100) {
					System.out.println("���� ��� �ּҹ��ñݾ׺��� �����Ƿ� �����Ͻ� �� �����ϴ�.");
					break;
				}
				System.out.print("������ �Ͻðڽ��ϱ�? ( Y / N )");
				String yn = sc.nextLine();
				try {
					flag = method.checkYesNo(yn);
				} catch (Exception e) {
					System.out.println("Y(y) �Ǵ� N(n)�� �Է����ּ���.");
				}
				if (!flag) {
					System.out.println("����ȭ������ �̵��մϴ�.");
					break;
				}
				money = betting(userIdentify);
				playable = true;
				//���� Ȯ�ο�
				System.out.println("���� ���þ� : " + money + "��");
				break;
			
			case 2:
				//�����	
				if (playable) {
					System.out.println("���� ���þ� : " + money + "��");
					System.out.print("��� ������ �����Ͻðڽ��ϱ�?(1~10) : ");
					int expectWin = sc.nextInt();
					sc.nextLine();
					System.out.print("��⸦ �����Ͻðڽ��ϱ�? ( Y / N ) : ");
					String answer = sc.nextLine();
					try {
						flag = method.checkYesNo(answer);
					} catch (Exception e) {
						System.out.println("Y(y) �Ǵ� N(n)�� �Է����ּ���.");
					}
					if (!flag) {
						System.out.println("����ȭ������ �̵��մϴ�.");
						break;
					}
					racing();
				}else {
					System.out.println("������ ���� ������ ���ӿ� �����Ͻ� �� �����ϴ�.");
				}
				break;

			}
		} while (true);
	}
	//���ñݾ� ����
	int betting(Identify identify) {
		do {
			userIdentify = identify;
			System.out.println("�ּ� ���ñݾ��� 100���̸� 20�������� �ö󰩴ϴ�.");
			System.out.print("���� �ܰ� : " + userIdentify.getMoney() + "��"
					+ "\n���þ� : ");
			money = sc.nextInt();
			sc.nextLine();
			if (money < 100) {
				System.out.println("�ּ� ���ñݾ��� 100���Դϴ�.");
				continue;
			}
			if (money % 20 != 0) {
				System.out.println("20�������� �������ֽʽÿ�.");
				continue;
			}
			return money;
		} while (true);
	}
	
	void racing() {
		
		Thread horseThread1 = new Horse("1�� ��");
		Thread horseThread2 = new Horse("2�� ��");
		Thread horseThread3 = new Horse("3�� ��");
		Thread horseThread4 = new Horse("4�� ��");
		Thread horseThread5 = new Horse("5�� ��");
		Thread horseThread6 = new Horse("6�� ��");
		Thread horseThread7 = new Horse("7�� ��");
		Thread horseThread8 = new Horse("8�� ��");
		Thread horseThread9 = new Horse("9�� ��");
		Thread horseThread10 = new Horse("10�� ��");
		
		horseThread1.start();
		horseThread2.start();
		horseThread3.start();
		horseThread4.start();
		horseThread5.start();
		horseThread6.start();
		horseThread7.start();
		horseThread8.start();
		horseThread9.start();
		horseThread10.start();
		
		try {
			horseThread1.join();
			horseThread2.join();
			horseThread3.join();
			horseThread4.join();
			horseThread5.join();
			horseThread6.join();
			horseThread7.join();
			horseThread8.join();
			horseThread9.join();
			horseThread10.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("=====�����=====");
		Horse.getRankArray();
	}
}
