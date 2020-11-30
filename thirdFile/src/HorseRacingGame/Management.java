package HorseRacingGame;

import java.util.*;

public class Management {
	
	Scanner sc = new Scanner(System.in);
	
	public void menu() {
		int num = 0;
		System.out.println("=====Welcome=====");
		do {
			System.out.println("=Obok's HorseRacing="
					+"\n"
					+ "\n1. Game start"
					+ "\n2. Sign up"
					+ "\n3. My page"
					+ "\n4. I'm out");	
			System.out.println();
			System.out.print("Press number : ");
			num = sc.nextInt();
			sc.nextLine();
			if(num < 1 || num > 4) {
				System.out.println("Press number again");
			}else if(num == 4) {
				System.out.println("Bye");
				break;
			}
			switch (num) {
			case 1:
				//���ӽ���
				break;
			case 2:
				//���� ����� ���
				signing();
				break;
			case 3:
				//����������
				break;
			}
		} while (true);
	}
	
	//���� ����� ���(�̸�, ����, ���� // �̻� ������ ��й�ȣ �Է¹ޱ�(���������� �̿��ϱ�))
	void signing() {
		Identify identify = new Identify();
		String name;
		String sex;
		String age;
		do {
			System.out.print("�ű� �̿��� ������ �Ͻðڽ��ϱ�? ( Y / N )");
			String answer = sc.nextLine();
			if(answer.equals("Y") || answer.equals("y")) {
				//�̸�
				System.out.print("�̸� : ");
				name = sc.nextLine();
				identify.setName(name);
				//����
				System.out.println("����( �� / �� ) : ");
				sex = sc.nextLine();
				try {
					identify.setSex(sex);
				} catch (SexUnclearException e) {
					System.out.println("���� �Է� ���� �߻�, ����� ������ �ٽ� �մϴ�.");
					continue;
				}
				//������� 
				System.out.print("��������� �Է����ּ���."
						+ "\nEx) 1999-06-12"
						+ "\n�Է� : ");
				age = sc.nextLine();
				try {
					identify.setAge(age);					
				} catch (IllegalAgeException e) {
					System.out.println("�̼����� ���� ���� �߻�, ���� �޴��� �̵��մϴ�.");
					break;
				}

			}else if(answer.equals("N") || answer.equals("n")) {
				System.out.println("���� �޴��� �̵��մϴ�.");
				break;
			}else {
				System.out.println("�߸� �����̽��ϴ�. �ٽ� �����ּ���.");
			}
		} while (true);
	}
}
