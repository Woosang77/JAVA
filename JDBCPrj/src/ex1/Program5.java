package ex1;

import java.sql.SQLException;

import jdbc_newlec.app.console.TopicConsole;

public class Program5 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		TopicConsole console = new TopicConsole();
		
		EXIT :
			while (true) {
			console.printTopicList();
			int menu = console.inputTopicMenu();
						
			switch (menu) {
			case 1: // ����ȸ
				break;
			case 2:	//����
				break;
			case 3:	//����
				break;
			case 4:	//�۾���
				break;
			case 5:	//����
				System.out.println("Bye~~");
				break EXIT;
			default:
				System.out.println("<<�߸��� ��ȣ>>");
				break;
			}
			
		}
	}

}
