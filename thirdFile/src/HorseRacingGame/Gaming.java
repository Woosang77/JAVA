package HorseRacingGame;

import java.util.Scanner;

public class Gaming {
	Scanner sc = new Scanner(System.in);
	private Identify userIdentify;
	private int money;
	private int expectWin;
	Management method = new Management();
	
	//management���� 1�� ������ ���̵� ������ ����
	public void gameStarting(Identify identify) {
		boolean flag = true;
		userIdentify = identify;
		boolean playable = false;
		do {
			int account = userIdentify.getMoney();
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
				if(playable) {
					System.out.println("������ ������ �ݾ��� ��ȯ�մϴ�.");
					userIdentify.setMoney(userIdentify.getMoney() + money);
				}
				System.out.println("���� ȭ������ �̵��մϴ�.");
				break;
			}
			switch (num) {
			case 1:
				//������
				System.out.println("�����忡 ���Ű� ȯ���մϴ�.");
				System.out.println("���� �ܰ� : " + account + "��");
				if (account < 100) {
					System.out.println("���� ��� �ּҹ��ñݾ׺��� �����Ƿ� �����Ͻ� �� �����ϴ�.");
					break;
				}
				System.out.print("������ �Ͻðڽ��ϱ�? ( Y / N ) : ");
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
				userIdentify.setMoney(account - money);
				playable = true;
				break;
			
			case 2:
				//�����	
				if (playable) {
					System.out.println("���� ���þ� : " + money + "��");
					System.out.print("��� ������ �����Ͻðڽ��ϱ�?(1~10) : ");
					expectWin = sc.nextInt();
					sc.nextLine();
					if (expectWin < 1 || expectWin > 10) {
						System.out.println("1~10�� ������ ���� �������ֽʽÿ�");
						continue;
					}
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
					money = (int)playing(expectWin, money);
					Horse.cleanMemory();
					userIdentify.setMoney(userIdentify.getMoney() + money);
					System.out.println(userIdentify.getMoney());
					playable = false;
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
			System.out.println("���� �Ϸ�Ǿ����ϴ�.");
			return money;
		} while (true);
	}
	
	//�� �޸���
	void racing() {
		
		Thread horseThread1 = new Horse("1");
		Thread horseThread2 = new Horse("2");
		Thread horseThread3 = new Horse("3");
		Thread horseThread4 = new Horse("4");
		Thread horseThread5 = new Horse("5");
		Thread horseThread6 = new Horse("6");
		Thread horseThread7 = new Horse("7");
		Thread horseThread8 = new Horse("8");
		Thread horseThread9 = new Horse("9");
		Thread horseThread10 = new Horse("10");
		
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
		} catch (InterruptedException e) {}
		System.out.println("=====�����=====");
		Horse.getRankArray();
	}
	
	//�� �ְ� �� ����
	double playing(int horseNum, int money) {
		
		String num = "" + horseNum;
		String[] arr = Horse.rankArray;
		double betMoney = money;
		int myHorseRank = 1;
		
		for (int i = 0; i < arr.length; i++) {
			if (num.equals(arr[i])) {
				break;
			}else {
				myHorseRank++;
			}
		}
		switch (myHorseRank) {
		case 1:
			betMoney = betMoney * 8;
			break;
			
		case 2:
			betMoney = betMoney * 5;
			break;
			
		case 3:
			betMoney = betMoney * 3;
			break;
		
		case 4:
			betMoney = betMoney * 1.5;
			break;
			
		case 5:
			betMoney = betMoney * 1;
			break;
			
		case 6:
			betMoney = betMoney * 0.85;
			break;
			
		case 7:
			betMoney = betMoney * 0.6;
			break;
			
		case 8:
			betMoney = betMoney * 0.45;
			break;
			
		case 9:
			betMoney = betMoney * 0.3;
			break;
			
		case 10:
			betMoney = betMoney * 0;
			break;
		}
		
		return betMoney;
	}
}
