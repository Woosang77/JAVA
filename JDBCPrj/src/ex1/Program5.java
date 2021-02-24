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
			case 1: // 상세조회
				break;
			case 2:	//이전
				console.movePrevList();
				break;
			
			case 3:	//다음
				console.moveNextList();
				break;
			case 4:	//글쓰기
				break;
			case 5:	//종료
				System.out.println("Bye~~");
				break EXIT;
			default:
				System.out.println("<<잘못된 번호>>");
				break;
			}
			
		}
	}

}
