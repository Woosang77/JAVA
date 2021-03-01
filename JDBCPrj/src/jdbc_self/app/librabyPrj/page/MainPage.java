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
			case 1:	//회원
				mainConsole.logIn();
				break;
			case 2:	//도서관
				try {mainConsole.startLibrary();}
				catch (NullPointerException e) {
					System.out.println("로그인을 해주세요. [ 회원 - 로그인 ]");}
				break;
			case 3: 	//종료
				System.out.println("안녕히 가세요.");
				break EXIT;
			default:	 //잘못누름
				System.out.println("잘못 누르셨습니다.");
				break;
			}
		}
	}
}
