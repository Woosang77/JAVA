 package smartphone;

import java.util.*;
import java.text.SimpleDateFormat;

public class Tool {
	Scanner scan = new Scanner(System.in);
	private String passWord = "486715*";
	String[] manual = {"��ȭ", "����", "�ð�", "��ȭ��ȣ���", "��й�ȣ����", "��й�ȣȮ��"};
	
	
	List<String> nameBook = new ArrayList<>();
	List<String> numberBook = new ArrayList<>();
	
	//��ȭ�ϱ�
	public void calling () {
		System.out.println("����в� ��ȭ�� �Ͻðڽ��ϱ�" + nameBook);
		String name = scan.nextLine();
		System.out.println(name + "�Բ� ��ȭ�� �̴ϴ�.");
	}
	
	//�������
	public void takingPhoto() {
		for (int i = 0; i < 3; i++) {
			System.out.println(i+1);
		}
		System.out.println("������ �Կ��Ǿ����ϴ�.");
	}
	//��¥, �ð�����
	public void clock() {
		long time = System.currentTimeMillis();
		SimpleDateFormat simpl = new SimpleDateFormat("yyyy�� MM�� dd�� aa hh�� mm�� ss��");
		String s = simpl.format(time);
		System.out.println(s);
	}
	//��й�ȣ����
	public void PwChange() {
		System.out.println("�����Ͻ� ��й�ȣ�� �Է����ּ���. :");
		this.passWord = scan.nextLine(); 
	}
	
	//��й�ȣ Ȯ��
	public void PwConfirm() {
		System.out.println(passWord);
	}
	
	//��������ϱ�
	public boolean unlocking() {
		do {
			System.out.println("��� ��й�ȣ�� �Է����ּ��� : ");
			String passnum = scan.nextLine();
				if (!passnum.equals(passWord)) {
					System.out.println("�߸��� ��й�ȣ �Դϴ�.");
				}else {
					System.out.println("��������Ǿ����ϴ�.");
					return true;
				}
		}while(true);
	}
	
	//��ȭ��ȣ���
	public void registering() {
		//���Ϲ�ȣ �˻�
		boolean check = true;
		System.out.println("��ȣ�� �Է����ּ��� : ");
		String number = scan.nextLine();
		for (int i = 0; i < numberBook.size(); i++) {
			if(numberBook.contains(number)) {
				System.out.println("������ ��ȣ�� ����Ǿ��ֽ��ϴ�. " + nameBook.get(i));
				check = false;
				break;
			}
		}
		if(check == true) {
			System.out.println("�ش� ��ȣ�� �̸��� ������ּ��� : ");
			String name = scan.nextLine();
			nameBook.add(0, name);
			numberBook.add(0, number);
			System.out.println("����� �Ϸ�Ǿ����ϴ�.");
		}
	}
	
	//����Ʈ�� �����ϱ�
		void smartPhoneStart() {
			//���θ޴�
			while (true) {
				System.out.println("���Ͻô� ����� ������ �ּ���. : " + Arrays.toString(manual));
				String answer = scan.nextLine();
				switch (answer) {
					case "��ȭ":
						calling();
						break;
					case "����":
						takingPhoto();
						break;
					case "�ð�":
						clock();
						break;
					case "��ȭ��ȣ���":
						registering();
						break;
					case "��й�ȣ����":
						PwChange();
						break;
					case "��й�ȣȮ��":
						PwConfirm();
						break;
				}
			}
		}
}