package jdbc_self.app.librabyPrj.console;

import java.sql.SQLException;
import java.util.Scanner;

public class MainConsole {
	
	private LibraryConsole libraryConsole;
	private SignInConsole signInConsole;
	//int count = bookservice.getCount();
	
	public MainConsole() {
		libraryConsole = new LibraryConsole();
		signInConsole = new SignInConsole();
	}
	
	//시작
	public int printPage() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-----------------------------------------------");
		System.out.println("		Welcome");
		System.out.println("-----------------------------------------------");
		System.out.printf(
					"> 1. 로그인\n"+
					"> 2. 회원가입\n"+
					"> 3. 도서관\n"+
					"> 4. 종료\n"
				);
		System.out.println("-----------------------------------------------");
		System.out.print("> ");
		String num_ = scan.nextLine();
		int num = Integer.parseInt(num_);
		return num;
	}
	
	//도서관
	public void startLibrary() throws ClassNotFoundException, SQLException{
		int num;
		EXIT: 
			while (true) {
			num = libraryConsole.start();
			switch (num) {
			case 1:	//대여
				libraryConsole.rentBook();
				break;
			case 2:	//반납
				libraryConsole.returnBook();
				break;
			case 3:	//이전
				libraryConsole.movePrePage();
				break;
			case 4:	//다음
				libraryConsole.MoveNextPage();
				break;
			case 5://검색
				libraryConsole.inputSearchWord();
				break;
			case 6: 	//종료
				System.out.println("메인화면으로...");
				break EXIT;
			default:	 //잘못누름
				System.out.println("잘못 누르셨습니다.");
				break;
			}
		}
	}
}
