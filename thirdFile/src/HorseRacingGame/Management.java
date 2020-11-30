package HorseRacingGame;

import java.util.*;

public class Management {
	
	List<Identify> membersIdcheck = new ArrayList<Identify>();
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
		String id;
		int pin;
		boolean flags = true;
		
		do {
			System.out.print("�ű� �̿��� ������ �Ͻðڽ��ϱ�? ( Y / N )");
			String answer = sc.nextLine();
			if(answer.equals("Y") || answer.equals("y")) {
				
				//�̸�
				System.out.print("�̸� : ");
				name = sc.nextLine();
				identify.setName(name);
				
				//����
				System.out.print("����( �� / �� ) : ");
				sex = sc.nextLine();
				try {
					identify.setSex(sex);
				} catch (SexUnclearException e) {
					System.out.println(e.getMessage()
							 + "\nó������ ���ư��ϴ�.");
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
					System.out.println(e.getMessage() +
							"\nó������ ���ư��ϴ�.");
					continue;
				}
				System.out.println("�̸� : " + identify.getName()
						+ "\n���� : " + identify.getSex()
						+ "\n������� : " + identify.getAge());
				
				//���̵� ���� (�ߺ��ֳ� Ȯ�� �Ұ���)
				do {
					System.out.print("����� ���̵� �����ּ��� : ");
					id = sc.nextLine();
					flags = idchecking(id);
				} while (flags);
				identify.setId(id);
				System.out.println("���̵� ����� �Ϸ�Ǿ����ϴ�.");
				
				//��й�ȣ ����(pin 4�ڸ�)
				do {
					System.out.print("����� ��й�ȣ 4�ڸ� ���ڸ� �Է����ּ��� : ");
					pin = sc.nextInt();
					sc.nextLine();
					if (!((pin % 1000) >= 1)) {
						System.out.println("�߸� �Է��ϼ̽��ϴ�.");
						continue;
					}
					
				} while (true);
				
			}else if(answer.equals("N") || answer.equals("n")) {
				System.out.println("���� �޴��� �̵��մϴ�.");
				break;
			}else {
				System.out.println("�߸� �����̽��ϴ�. �ٽ� �����ּ���.");
			}
		} while (true);
	}
	
	//���̵� �ߺ��˻�
	boolean idchecking(String id) {
		for (Identify checkmember : membersIdcheck) {
			if (id.equals(checkmember.getId())) {
				System.out.println("���̵� �ߺ��Ǿ����ϴ�. �ٸ� ���̵� ������ּ���.");
				return true;
			}
		}
		return false;
	}
}
