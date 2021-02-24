package jdbc_newlec.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import jdbc_newlec.app.entity.Topic;
import jdbc_newlec.app.service.TopicService;

public class TopicConsole {
	
	private TopicService service;
	
	public TopicConsole() {
		service = new TopicService();
	}

	public void printTopicList() throws ClassNotFoundException, SQLException{
		
		List<Topic> list = service.getList(2);
		
		System.out.println("-----------------------------------------------");
		System.out.printf("	<��������> �� %d ��\n", 12);
		System.out.println("-----------------------------------------------");
		
		for (Topic t : list) {			
			System.out.printf("%d. %s / %s / %s\n",
					t.getId(), 
					t.getTitle(), 
					t.getDescription(), 
					t.getCreated()
			);
		}
		System.out.println("-----------------------------------------------");
		System.out.printf("		%d/%d pages\n", 1, 2);
	}
	
	public int inputTopicMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		
		System.out.printf("1. �� ��ȸ / 2. ���� / 3. ���� / 4. �ۼ� / 5. ���� >");
		//int menu = scan.nextInt();
		//���� 1 : �Էµ� ���� ������ ��ȯ�� �� ���� ���
		// ���ۿ� ������ ����Ű�� �����Է¿� ������ �ش�.
		String menu_ = scan.nextLine();
		int menu = Integer.parseInt(menu_);
		
		return menu;
	}
}
