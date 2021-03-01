package jdbc_self.app.librabyPrj.console;

import java.sql.SQLException;
import java.util.Scanner;

import jdbc_self.app.librabyPrj.model.Member;
import jdbc_self.app.librabyPrj.service.MemberService;

public class MainConsole {
	
	private LibraryConsole libraryConsole;
	private MemberConsole memberConsole;
	private Member member;
	public MainConsole() {
		libraryConsole = new LibraryConsole();
		memberConsole = new MemberConsole();	
	}
	
	//����
	public int printPage() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-----------------------------------------------");
		System.out.printf("		Welcome			%s\n", memberConsole.member.getName());
		System.out.println(memberConsole.logInState);
		System.out.println("-----------------------------------------------");
		System.out.printf(
					"> 1. ȸ��\n"+
					"> 2. ������\n"+
					"> 3. ����\n"
				);
		System.out.println("-----------------------------------------------");
		System.out.print("> ");
		String num_ = scan.nextLine();
		int num = Integer.parseInt(num_);
		return num;
	}
	
	//ȸ��
	public void logIn() throws ClassNotFoundException, SQLException{
		int num;
		EXIT:
		while (true) {
			num = memberConsole.start();
			switch (num) {
			case 1:	//�α���
				memberConsole.logIn();
				break;
			case 2: //ȸ������
				memberConsole.signIn();
				break;
			case 3: //������
				System.out.println("> ���� ȭ������");
				break EXIT;
			default:
				System.out.println("> �߸��� ��ȣ�Դϴ�.");
				break;
			}
		}
		//idã��
		//��й�ȣã��
	}

	
	//������
	public void startLibrary() throws ClassNotFoundException, SQLException{
		int num;
		EXIT: 
			while (memberConsole.logInState) {
			num = libraryConsole.start();
			switch (num) {
			case 1:	//�뿩
				libraryConsole.rentBook();
				break;
			case 2:	//�ݳ�
				libraryConsole.returnBook();
				break;
			case 3:	//����
				libraryConsole.movePrePage();
				break;
			case 4:	//����
				libraryConsole.MoveNextPage();
				break;
			case 5://�˻�
				libraryConsole.inputSearchWord();
				break;
			case 6: 	//����
				System.out.println("����ȭ������...");
				break EXIT;
			default:	 //�߸�����
				System.out.println("�߸� �����̽��ϴ�.");
				break;
			}
		}
	}
}
