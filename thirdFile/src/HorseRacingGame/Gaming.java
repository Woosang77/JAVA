package HorseRacingGame;

import java.util.Scanner;

public class Gaming {
	Scanner sc = new Scanner(System.in);
	private Identify userIdentify;
	private int money;
	Management method = new Management();
	
	public void gameStarting(Identify identify) {
		boolean playable = false;
		userIdentify = identify;
		do {
			System.out.println(userIdentify.getName() + "�� ȯ���մϴ�.");
			System.out.println("===============");
			System.out.println("\n" + "\n1. ������" + "\n2. �����" + "\n3. ������");
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
				boolean flag = true;
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
					System.out.print("��� ������ �����Ͻðڽ��ϱ�?(1~10) : ");
					int expectWin = sc.nextInt();
					
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
	
	void racing() {
		
	}
}
