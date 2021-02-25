package jdbc_newlec.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import jdbc_newlec.app.entity.Topic;
import jdbc_newlec.app.service.TopicService;

public class TopicConsole {
	
	private TopicService service;
	
	private int page;
	private String searchField = "TITLE";
	private String searchWord = "";
	
	public TopicConsole() {
		service = new TopicService();
		page = 1;
	}

	public void printTopicList() throws ClassNotFoundException, SQLException{
		
		int count = service.getCount(searchField, searchWord);
		List<Topic> list = service.getList(page, searchField, searchWord, count);
		
		int lastPage = count /10;
		lastPage = count % 10>0 ? lastPage+1:lastPage;
		
		System.out.println("-----------------------------------------------");
		System.out.printf("	<��������> �� %d ��\n", count);
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
		System.out.printf("		%d/%d pages\n", page, lastPage);
	}
	
	public int inputTopicMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.printf("1. �� ��ȸ / 2. ���� / 3. ���� / 4. �ۼ� / 5. �˻� / 6. ���� >");
		String menu_ = scan.nextLine();
		int menu = Integer.parseInt(menu_);
		return menu;
	}
	
	public void movePrevList() {
		if (page == 1) {
			System.out.println("-----------------------------------------------");
			System.out.println("���� �������� �����ϴ�.");
			System.out.println("-----------------------------------------------");
			return;
		}
		page--;
	}
	
	public void moveNextList() throws ClassNotFoundException, SQLException{
		int count = service.getCount(searchField, searchWord);
		int lastPage = count /10;
		lastPage = count % 10>0 ? lastPage+1:lastPage;
		
		if (page == lastPage) {
			System.out.println("-----------------------------------------------");
			System.out.println("������ �������Դϴ�.");
			System.out.println("-----------------------------------------------");
			return;
		}
		page++;
	}
	
	public void inputSearchWord() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�˻� ���� (title/description)�߿� �ϳ��� �Է��ϼ���.");
		System.out.print("> ");
		searchField = scan.nextLine();
		
		System.out.print("�˻��� > ");
		searchWord = scan.nextLine();
	}
}
