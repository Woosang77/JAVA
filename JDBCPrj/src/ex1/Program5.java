package ex1;

import java.sql.SQLException;

import jdbc_newlec.app.console.TopicConsole;

public class Program5 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		TopicConsole console = new TopicConsole();
		console.printTopicList();
		int menu = console.inputTopicMenu();
		
		switch (menu) {
		case 1: // 상세조회
			break;
		case 2:	//이전
			break;
		case 3:	//다음
			break;
		case 4:	//글쓰기
			break;
		}
	}

}
