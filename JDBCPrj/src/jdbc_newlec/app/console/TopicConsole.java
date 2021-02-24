package jdbc_newlec.app.console;

import java.sql.SQLException;
import java.util.List;

import jdbc_newlec.app.entity.Topic;
import jdbc_newlec.app.service.TopicService;

public class TopicConsole {
	
	private TopicService service;
	
	public TopicConsole() {
		service = new TopicService();
	}
	
	public void printTopicList() throws ClassNotFoundException, SQLException{
		
		List<Topic> list = service.getList();
		
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
		return 0;
	}
}
