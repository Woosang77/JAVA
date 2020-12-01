package HorseRacingGame;

import java.util.*;

public class Management {
	HashMap<String, Identify> members = new HashMap<>();

	Identify identify = new Identify();
	Scanner sc = new Scanner(System.in);
	
	public void menu() {
		int num = 0;
		System.out.println("=====Welcome=====");
		do {
			System.out.println("=Obok's HorseRacing="
					+"\n"
					+ "\n1. Game start"
					+ "\n2. Sign up"
					+ "\n3. User Lookup"
					+ "\n4. Modify User Information"
					+ "\n5. I'm out");	
			System.out.println();
			System.out.print("Press number : ");
			num = sc.nextInt();
			sc.nextLine();
			if(num < 1 || num > 5) {
				System.out.println("Press number again");
			}else if(num == 5) {
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
				//����� ��ȸ
				UserLookup();
				break;
			case 4:
				modifying();
				break;
				//���� ��������
				
			}
		} while (true);
	}
	
	//���� ����� ���(�̸�, ����, ���� // �̻� ������ ��й�ȣ �Է¹ޱ�(���������� �̿��ϱ�))
	void signing() {
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
			//���̵� ����
			do {
				System.out.print("����� ���̵� �����ּ��� : ");
				id = sc.nextLine();
				flags = idchecking(id);
				if (flags) {
					System.out.println("���̵� �ߺ��Ǿ����ϴ�.");
				}
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
			members.put(identify.getId(), identify);
			System.out.println("���������� ���ԵǼ̽��ϴ�.");
			System.out.println("	<ȸ������>		"
					+ "\n1. �̸� : " + identify.getName()
					+ "\n2. ���� : " + identify.getSex()
					+ "\n3. ���� : " + identify.getAge()
					+ "\n4. ���̵� : " + identify.getId()
					+ "\n5. ��й�ȣ : " + identify.showPin() + "\n"
					+ "\n �⺻������ 1,000���� �־����ϴ�." + "\n");
			break;
		} while (true);
	}
	
	//����� ������ȸ
	void UserLookup() {
		do {
			boolean check;
			Set<String> idSet = members.keySet();
			Iterator<String> iter = idSet.iterator();
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
			System.out.print("ID : ");
			String findId = sc.nextLine();
			while (iter.hasNext()) {
				String valueId = iter.next();
				if (findId.equals(valueId)) {
					identify = members.get(valueId);
					identify.getAllInfo();
					check = false;
					break;
				}
			}
			if (check) {
				System.out.println("ID doesn't exist.");
			}
		} while (true);
	}
	
	//���� ���� ����
	void modifying() {
		String m_ID;
		boolean flags;
		int m_pw;
		System.out.print("ID : ");
		m_ID = sc.nextLine();
		flags = idchecking(m_ID);
		if (!flags) {System.out.println("ID doesn't exist.");}
		do {
			for (int i = 0; i < 5; i++) {
				System.out.print("ID : " + m_ID + "" + "\n PW : ");
				 m_pw = sc.nextInt();
			}
		} while (flags);
	}
	
	//���̵� �ߺ�Ȯ��
	boolean idchecking(String id) {
		Set<String> idSet = members.keySet();
		Iterator<String> iter = idSet.iterator();
		while(iter.hasNext()) {
			String iterId = iter.next();
			if (id.equals(iterId)) {
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