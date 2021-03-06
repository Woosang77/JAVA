package jdbc_self.app.librabyPrj.page;

import java.sql.SQLException;
import jdbc_self.app.librabyPrj.console.MainConsole;

public class MainPage {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		MainConsole mainConsole = new MainConsole();
		EXIT: 
		while (true) {
			int num = mainConsole.printPage();
			switch (num) {
			case 1:	//회원
				mainConsole.logIn();
				break;
			case 2:	//도서관
				try {
					mainConsole.startLibrary();					
				} catch (NullPointerException e) {
					System.out.println("> 로그인상태에서 이용가능");
				}
				break;
			case 3: 	//종료
				System.out.println("> 종료");
				break EXIT;
			default:	 //잘못누름
				System.out.println("> 잘못 누르셨습니다.");
				break;
			}
		}
	}
}
