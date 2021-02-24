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
		System.out.printf("	<공지사항> 총 %d 개\n", 12);
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
		
		
		System.out.printf("1. 상세 조회 / 2. 이전 / 3. 다음 / 4. 작성 / 5. 종료 >");
		//int menu = scan.nextInt();
		//문제 1 : 입력된 값이 정수로 변환될 수 없는 경우
		// 버퍼에 남겨진 엔터키가 다음입력에 영향을 준다.
		String menu_ = scan.nextLine();
		int menu = Integer.parseInt(menu_);
		
		return menu;
	}
}
