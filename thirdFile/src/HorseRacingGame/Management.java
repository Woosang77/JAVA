package HorseRacingGame;

import java.util.*;

public class Management {
	HashMap<String, Identify> members = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	Identify getIdentify;
	Gaming gaming;
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
					+ "\n5. Personal Bankruptcy"
					+ "\n6. I'm out");	
			System.out.println();
			System.out.print("Press number : ");
			num = sc.nextInt();
			sc.nextLine();
			if(num < 1 || num > 6) {
				System.out.println("Press number again");
			}else if(num == 6) {
				System.out.println("Bye");
				break;
			}
			switch (num) {

			//���ӽ���
			case 1:
				getIdentify = new Identify();
				System.out.print("��ϵǾ��ִ� ���̵�� ��й�ȣ�� �Է����ּ���"
						+ "\nID : ");
				String str = sc.nextLine();
				if (idchecking(str)) {
					getIdentify = members.get(str);
					System.out.print("PW : ");
					int try_pw = sc.nextInt();
					sc.nextLine();
					if (try_pw == getIdentify.getPin()) {
						gaming = new Gaming();
						gaming.gameStarting(getIdentify);
						break;
					}else {
						System.out.print("��й�ȣ�� �ٽ� �Է��Ͻðڽ��ϱ�? ( Y / N )");
						String answer  = sc.nextLine();
						if (answer.equals("N") || answer.equals("n")) {
							System.out.println("���θ޴��� �̵��մϴ�.");
							break;
						}
					}
				}else {
					System.out.println("��ϵ��� ���� ���̵��Դϴ�.");
					break;
				}
				break;
				
			//���� ����� ���
			case 2:
				signing();
				break;
				
			//����� ��ȸ
			case 3:
				UserLookup();
				break;
				
			//���� ��������
			case 4:
				modifying();
				break;
				
			//���� �Ļ��û
			case 5:
				//������ ���࿡ ���� ���� ��ȯ���� ��ȹ
				break;
			}
		} while (true);
	}
	
	//���� ����� ���
	void signing() {
		Identify setIdentify = new Identify();
		String name;
		String sex;
		String age;
		String id;
		int pin;
		boolean flags = true;
		
		breakOut :
		do {	
			System.out.println("=================");
			System.out.print("�ű� �̿��� ������ �Ͻðڽ��ϱ�? ( Y / N ) : ");
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
			setIdentify.setName(name);
			
			//����
			System.out.print("����( �� / �� ) : ");
			sex = sc.nextLine();
			try {
				setIdentify.setSex(sex);
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
				setIdentify.setAge(age);					
			} catch (IllegalAgeException e) {
				System.out.println(e.getMessage() +
						"\nó������ ���ư��ϴ�.");
				continue;
			}			
			//���̵� ����
			do {
				System.out.println("===============");
				System.out.print("����� ���̵� �����ּ��� : ");
				id = sc.nextLine();
				flags = idchecking(id);
				if (flags) {
					System.out.println("�ߺ��Ǵ� ���̵� �����մϴ�.");
				}
			} while (flags);
			setIdentify.setId(id);
			System.out.println("���̵� ����� �Ϸ�Ǿ����ϴ�.");
			
			//��й�ȣ ����(pin 4�ڸ�)
			do {
				System.out.println("===============");
				System.out.print("����� ��й�ȣ 4�ڸ� ���ڸ� �Է����ּ��� : ");
				pin = sc.nextInt();
				sc.nextLine();
				if (!((pin / 1000) >= 1)) {
					System.out.println("�ٽ� �Է����ּ���.");
					continue;
				}else {
					setIdentify.setPin(pin);
					break;
				}
			} while (true);
			//�̸� ���� ���� ���̵� ��й�ȣ ��� �Է¹޾Ҵٸ�?
			do {
				System.out.println("===============");
				boolean check = true;
				System.out.print("ȸ�������� Ȯ���Ͻðڽ��ϱ�? ( Y / N ) : ");
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
			members.put(id, setIdentify);
			System.out.println("���������� ���ԵǼ̽��ϴ�.");
			System.out.println("	<ȸ������>		"
					+ "\n1. �̸� : " + setIdentify.getName()
					+ "\n2. ���� : " + setIdentify.getSex()
					+ "\n3. ���� : " + setIdentify.getAge()
					+ "\n4. ���̵� : " + setIdentify.getId()
					+ "\n5. ��й�ȣ : " + setIdentify.showPin() + "\n"
					+ "\n �⺻������ 1,000���� �־����ϴ�." + "\n");
			break;
		} while (true);
	}
	
	//����� ������ȸ
	void UserLookup() {
		getIdentify = new Identify();
		do {
			boolean check;
			System.out.println("===============");
			System.out.print("������ȸ�� �Ͻðڽ��ϱ�? ( Y / N ) : ");
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
			check = idchecking(findId);
			if (check) {
				getIdentify = members.get(findId);
				System.out.println("===============");
				getIdentify.getAllInfo();
				break;
			}else if (!check) {
				System.out.println("ID doesn't exist.");
			}
		} while (true);
	}
	
	//���� ���� ����
	void modifying() {
		getIdentify = new Identify();
		Identify changeIdentify = new Identify();
		String m_ID = null;
		int try_pw;
		int count;
		boolean check =  true;
		boolean flags;
		
		do {
			System.out.println("===============");
			System.out.print("ID : ");
			m_ID = sc.nextLine();
			flags = idchecking(m_ID);
			if (!flags) {
				System.out.println("ID doesn't exist.");
				continue;
			}
			getIdentify = members.get(m_ID);
			int real_pw = getIdentify.getPin();
			for (count = 0; count < 5; count++) {
				System.out.print("PW : ");
				 try_pw = sc.nextInt();
				 sc.nextLine();
				 if (try_pw == real_pw) {
					 System.out.println("������������ �̵��մϴ�.");
					 break;
				}else {
					System.out.println("��й�ȣ�� "+(count +1)+ "ȸ Ʋ���̽��ϴ�.");
					System.out.print("��й�ȣ�� �ٽ� �Է��Ͻðڽ��ϱ�? ( Y / N )");
					String answer  = sc.nextLine();
					if (answer.equals("N") || answer.equals("n")) {
						System.out.println("���θ޴��� �̵��մϴ�.");
						check = false;
						break;
					}
				}
			}
			if (count == 4) {
				System.out.println("���θ޴��� �̵��մϴ�.");
				break;
			}
			//������� ��������
			while (check) {
				String str;
				System.out.println("===============");
				getIdentify.getAllInfo();
				System.out.print("�����Ͻ� ������ ��ȣ�� �����ּ��� : ");
				int modifyInfo = sc.nextInt();
				sc.nextLine();
				if(modifyInfo < 1 || modifyInfo > 6) {
					System.out.println("��ȣ�� �ٽ� �����ּ���.");
					continue;
				}else if (modifyInfo == 6) {
					System.out.println("���ӸӴϴ� ������ �� �����ϴ�.");
					continue;
				}
				switch (modifyInfo) {
				case 1:
					//���̵� ����
					while (true) {
						String id = getIdentify.getId();
						System.out.print("<ID ����>" 
								+"\n���� �� : " + id
								+ "\n���� : ");
						str = sc.nextLine();
						if (idchecking(str)) {
							System.out.println("������ ���̵� �����մϴ�.");
							continue;
						}
						try {
							//value�� Identify��ü ���� ����
							getIdentify.setId(str);
							changeIdentify = (Identify)getIdentify.clone();
						} catch (CloneNotSupportedException e) {
							System.out.println(e.getStackTrace());
						}
						members.put(str, changeIdentify);
						members.remove(id);
						System.out.println( "<����Ϸ�>"
								+ "\nID : " + changeIdentify.getId());
						System.out.println("���̵� ������ ������� �ʿ��Ͽ� ���θ޴����� �������ֽ��̿�.");
						break;
					}
					break;
				case 2:
					//�̸� ����
					System.out.print("<�̸� ����>" 
					+"\n���� �� : " + getIdentify.getName() 
					+ "\n���� : ");
					str = sc.nextLine();
					getIdentify.setName(str);
					System.out.println( "<����Ϸ�>"
							+ "\nUser Name : " + getIdentify.getName());
					break; 
				case 3:
					//������Ϻ���
					while (true) {
						System.out.print("<������� ����>" 
								+"\n���� �� : " + getIdentify.getAge()
								+ "\n���� : ");
						str = sc.nextLine();
						try {
							getIdentify.setAge(str);							
						} catch (IllegalAgeException e) {
							e.getMessage();
							System.out.println("�ٽ� �Է����ּ���.");
							continue;
						}
						System.out.println( "<����Ϸ�>"
								+ "\nAge : " + getIdentify.getAge());
						break;
					}
					break;
				case 4:
					//���� ����
					while (flags) {						
						System.out.print("<���� ����>" 
								+"\n���� �� : " + getIdentify.getSex() 
								+ "\n���� ( �� / �� ) : ");
						str = sc.nextLine();
						try {
							getIdentify.setSex(str);						
						} catch (SexUnclearException e) {
							e.getMessage();
							continue;
						}
						System.out.println( "<����Ϸ�>"
								+ "\nSex : " + getIdentify.getSex());
						break;
					}
					break;
				case 5:
					//��й�ȣ ����
					do {
						System.out.print("<��й�ȣ ����>" 
								+"\n���� �� : " + getIdentify.getPin() 
								+ "\n����  : ");
						int pw = sc.nextInt();
						sc.nextLine();
						if (!((pw / 1000) >= 1)) {
							System.out.println("�ٽ� �Է����ּ���.");
							continue;
						}else {
							getIdentify.setPin(pw);
							break;
						}
					} while (true);
					
					break;
				}
				System.out.print("�ٸ� ������ �߰��� �����Ͻðڽ��ϱ�? ( Y / N ) : ");
				str = sc.nextLine();
				try {
					check = checkYesNo(str);					
				} catch (WrongAnswerException e) {
					System.out.println("Y / N �� �������ֽʽÿ�.");
					check = false;
				}
			}
		} while (flags && check);
	}
	
	//���̵� Ȯ��
	boolean idchecking(String id) {
		Set<String> set = members.keySet();
		for (String string : set) {
			if (id.equals(string)) {
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