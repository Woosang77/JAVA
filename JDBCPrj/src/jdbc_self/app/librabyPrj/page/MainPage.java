package jdbc_self.app.librabyPrj.page;

import java.sql.SQLException;
import jdbc_self.app.librabyPrj.console.MainConsole;

public class MainPage {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		MainConsole mainConsole = new MainConsole();
		int num;
		
		EXIT: 
		while (true) {
			num = mainConsole.printPage();
			switch (num) {
			case 1:	//ȸ��
				mainConsole.logIn();
				break;
			case 2:	//������
				try {mainConsole.startLibrary();}
				catch (NullPointerException e) {
					System.out.println("�α����� ���ּ���. [ ȸ�� - �α��� ]");}
				break;
			case 3: 	//����
				System.out.println("�ȳ��� ������.");
				break EXIT;
			default:	 //�߸�����
				System.out.println("�߸� �����̽��ϴ�.");
				break;
			}
		}
	}
}
