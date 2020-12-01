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
				myPageModifying();
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
		
		breakOut :
		do {	
			System.out.print("�ű� �̿��� ������ �Ͻðڽ��ϱ�? ( Y / N )");
			String answer = sc.nextLine();
			try {
				flags = checkYesNo(answer);				
			} catch (WrongAnswerException e) {
				System.out.println("Y(y) �Ǵ� N(n)�� �Է����ּ���.");
				continue;
			}
			if (!flags) {
				System.out.println("���θ޴��� �̵��մϴ�.");
				break;
			}
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
				if (!((pin / 1000) >= 1)) {
					System.out.println("�ٽ� �Է����ּ���.");
					continue;
				}else {
					identify.setPin(pin);
					break;
				}
			} while (true);
			//�̸� ���� ���� ���̵� ��й�ȣ ��� �Է¹޾Ҵٸ�?
			do {				
				boolean check = true;
				System.out.println("ȸ�������� Ȯ���Ͻðڽ��ϱ�? ( Y / N )");
				answer = sc.nextLine();
				try {				
					check = checkYesNo(answer);
				} catch (WrongAnswerException e) {
					System.out.println("Y(y) �Ǵ� N(n)�� �Է����ּ���.");
				}
				if (!check) {
					System.out.println("Ȯ���� ����մϴ�. ���� �޴��� �̵��մϴ�.");
					break breakOut;
				}else if(check) {break;}
			} while (true);
			membersIdcheck.add(identify);
			System.out.println("���������� ���ԵǼ̽��ϴ�.");
			System.out.println("	<ȸ������>		"
					+ "\n1. �̸� : " + identify.getName()
					+ "\n2. ���� : " + identify.getSex()
					+ "\n3. ���� : " + identify.getAge()
					+ "\n4. ���̵� : " + identify.getId()
					+ "\n5. ��й�ȣ : " + identify.getPin() + "\n"
					+ "\n �⺻������ 1,000���� �־����ϴ�." + "\n");
			break;
		} while (true);
	}
	
	//����� ������ȸ
	void myPageModifying() {
		do {
			boolean check;
			System.out.print("������ȸ�� �Ͻðڽ��ϱ�? ( Y / N )");
			try {
				check = checkYesNo(sc.nextLine());				
			} catch (WrongAnswerException e) {
				System.out.println("Y(y) �Ǵ� N(n)�� �Է����ּ���.");
				continue;
			}
			if (!check) {
				System.out.println("��ȸ�� ����մϴ�.");
				break;
			}
			System.out.print("��ȸ�Ͻ� ������ ���̵� �Է����ּ��� : ");
			String findId = sc.nextLine();
			for (Identify identify : membersIdcheck) {
				String compareId = identify.getId();
				if (findId.equals(compareId)) {
					identify.getAllInfo();
					check = false;
				}
			}
			if (check) {
				System.out.println("��û�Ͻ� ���̵��� ������ �����ϴ�.");
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
	
	//YES or NO
	boolean checkYesNo(String answer) throws WrongAnswerException {
		if (answer.equals("Y") || answer.equals("y")) {
			return true;
		}else if(answer.equals("N") || answer.equals("n")) {
			return false;
		} else {
			throw new WrongAnswerException();
		}
	}
}