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
			case 1:	//�α���
				break;
			case 2:	//ȸ������
				break;
			case 3:	//������
				mainConsole.startLibrary();
				break;
			case 4: 	//����
				System.out.println("�ȳ��� ������.");
				break EXIT;
			default:	 //�߸�����
				System.out.println("�߸� �����̽��ϴ�.");
				break;
			}
		}
	}
}
