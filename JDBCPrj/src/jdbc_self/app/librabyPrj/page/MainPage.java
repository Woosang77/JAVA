package jdbc_self.app.librabyPrj.page;

import java.sql.SQLException;
import jdbc_self.app.librabyPrj.console.MainConsole;

public class MainPage {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		MainConsole mainConsole = new MainConsole();
		EXIT: 
		while (true) {
			int num = mainConsole.printPage();
			switch (num) {
			case 1:	//ȸ��
				mainConsole.logIn();
				break;
			case 2:	//������
				try {
					mainConsole.startLibrary();					
				} catch (NullPointerException e) {
					System.out.println("> �α��λ��¿��� �̿밡��");
				}
				break;
			case 3: 	//����
				System.out.println("> ����");
				break EXIT;
			default:	 //�߸�����
				System.out.println("> �߸� �����̽��ϴ�.");
				break;
			}
		}
	}
}
