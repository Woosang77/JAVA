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
			System.out.println(userIdentify.getName() + "�� ȯ���մϴ�.");
			System.out.println("===============");
			System.out.println("\n" + 
					"\n1. ������" + 
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
				System.out.println("���� �ܰ� : " + userIdentify.getMoney());
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
					System.out.print("��⸦ �����Ͻðڽ��ϱ�? ( Y / N )");
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
			System.out.print("���� �ܰ� : " + userIdentify.getMoney()
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

	//�� 10���� ���� �� ��� �� run���� �� ��� ����
	void racing() {
		
		Thread horseThread1 = new Horse();
		Thread horseThread2 = new Horse();
		Thread horseThread3 = new Horse();
		Thread horseThread4 = new Horse();
		Thread horseThread5 = new Horse();
		Thread horseThread6 = new Horse();
		Thread horseThread7 = new Horse();
		Thread horseThread8 = new Horse();
		Thread horseThread9 = new Horse();
		Thread horseThread10 = new Horse();
		
		
		try {
			horseThread1.start();
			horseThread1.join();
			
			horseThread2.start();
			horseThread2.join();
			
			horseThread3.start();
			horseThread3.join();
			
			horseThread4.start();
			horseThread4.join();
			
			horseThread5.start();
			horseThread5.join();
			
			horseThread6.start();
			horseThread6.join();
			
			horseThread7.start();
			horseThread7.join();
			
			horseThread8.start();
			horseThread8.join();
			
			horseThread9.start();
			horseThread9.join();
			
			horseThread10.start();
			horseThread10.join();
			
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		
	}
}
