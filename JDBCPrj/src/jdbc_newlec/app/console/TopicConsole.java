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
		System.out.printf("	<공지사항> 총 %d 개\n", count);
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
		System.out.printf("1. 상세 조회 / 2. 이전 / 3. 다음 / 4. 작성 / 5. 검색 / 6. 종료 >");
		String menu_ = scan.nextLine();
		int menu = Integer.parseInt(menu_);
		return menu;
	}
	
	public void movePrevList() {
		if (page == 1) {
			System.out.println("-----------------------------------------------");
			System.out.println("이전 페이지가 없습니다.");
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
			System.out.println("마지막 페이지입니다.");
			System.out.println("-----------------------------------------------");
			return;
		}
		page++;
	}
	
	public void inputSearchWord() {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색 범주 (title/description)중에 하나를 입력하세요.");
		System.out.print("> ");
		searchField = scan.nextLine();
		
		System.out.print("검색어 > ");
		searchWord = scan.nextLine();
	}
}
