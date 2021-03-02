package jdbc_self.app.librabyPrj.console;

import java.sql.SQLException;
import java.util.Scanner;
import jdbc_self.app.librabyPrj.model.Member;

public class MainConsole {
	
	private LibraryConsole libraryConsole;
	private MemberConsole memberConsole;
	private Member member;
	
	public MainConsole() {
		memberConsole = new MemberConsole();
		libraryConsole = new LibraryConsole();
		member = new Member("Unconnected");
	}
	
	//시작
	public int printPage() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-----------------------------------------------");
		System.out.println("					" + member.getName());
		System.out.println("   Welcome to Library System");
		System.out.println("-----------------------------------------------");
		System.out.printf(
					"> 1. 회원\n"+
					"> 2. 도서관\n"+
					"> 3. 종료\n"
				);
		System.out.println("-----------------------------------------------");
		System.out.print("> ");
		String num_ = scan.nextLine();
		int num = Integer.parseInt(num_);
		return num;
	}
	
	//회원 (MainPage - 1.회원 내부)
	public void logIn() throws ClassNotFoundException, SQLException{
		int num;
		EXIT:
		while (true) {
			num = memberConsole.start();
			switch (num) {
			case 1:	//로그인
				member = memberConsole.logIn();
				System.out.printf("%s님이 로그인하셨습니다.\n", member.getName());
				break;
			case 2: //회원가입
				memberConsole.signIn();
				break;
			case 3: //나가기
				System.out.println("> 메인 화면으로 이동");
				break EXIT;
			default:
				System.out.println("> 잘못된 번호입니다.");
				break;
			}
		}
	}

	
	//도서관 (MainPage - 2. 도서관 내부)
	public void startLibrary() throws ClassNotFoundException, SQLException{
		EXIT: 
		while (memberConsole.logInState) {
			//도서관콘솔에 필요한 Member 정보를 넘겨줌
			libraryConsole.connect(member);
			int num = libraryConsole.start();
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
			case 5: //대여한 도서 목록
				libraryConsole.rentedBook();
				break;
			case 6://검색
				libraryConsole.searchFilter();
				break;
			case 7: 	//종료
				System.out.println("메인화면으로...");
				break EXIT;
			default:	 //잘못누름
				System.out.println("잘못 누르셨습니다.");
				break;
			}
		}
	}
}
