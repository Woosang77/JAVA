package jdbc_self.app.librabyPrj.console;

import java.sql.SQLException;
import java.util.Scanner;

public class MainConsole {
	
	private LibraryConsole libraryConsole;
	private SignInConsole signInConsole;
	//int count = bookservice.getCount();
	
	public MainConsole() {
		libraryConsole = new LibraryConsole();
		signInConsole = new SignInConsole();
	}
	
	//����
	public int printPage() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-----------------------------------------------");
		System.out.println("		Welcome");
		System.out.println("-----------------------------------------------");
		System.out.printf(
					"> 1. �α���\n"+
					"> 2. ȸ������\n"+
					"> 3. ������\n"+
					"> 4. ����\n"
				);
		System.out.println("-----------------------------------------------");
		System.out.print("> ");
		String num_ = scan.nextLine();
		int num = Integer.parseInt(num_);
		return num;
	}
	
	//������
	public void startLibrary() throws ClassNotFoundException, SQLException{
		int num;
		EXIT: 
			while (true) {
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
