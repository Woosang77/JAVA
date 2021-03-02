package jdbc_self.app.librabyPrj.console;

import java.sql.SQLException;

import java.util.Scanner;

import jdbc_self.app.librabyPrj.model.Member;
import jdbc_self.app.librabyPrj.service.MemberService;

public class MemberConsole {
	
	MemberService memberService;
	Member member;
	String user = "Unconnected...";
	Boolean logInState;
	
	public MemberConsole() {
		memberService = new MemberService();
	}
	
	
	//선택창
	public int start() {
		Scanner scan = new Scanner(System.in);
		logInCheck();
		System.out.println("-----------------------------------------------");
		System.out.println(user);
		System.out.println("-----------------------------------------------");
		System.out.printf("< 1. 로그인 / 2. 회원가입 / 3. 나가기  >\n");
		System.out.println("-----------------------------------------------");
		System.out.print("> ");
		int num = scan.nextInt();
		scan.nextLine();
		return num;
	}
	
	//로그인 상태
	public void logInCheck ( ) {
		if (member != null) {
			logInState = true;
			user = member.getName();
		}else {logInState = false;}
	}
	
	//로그인
	public Member logIn( ) throws ClassNotFoundException, SQLException{
		String id = "";
		String pw = "";
		Scanner scan = new Scanner(System.in);
		
		System.out.println("----------------------로그인화면-----------------");
		System.out.print("> ID : ");
		id = scan.nextLine();
		
		System.out.print("> PW : ");
		pw = scan.nextLine();
		member = memberService.searchMember(id, pw);
		user = member.getName();
		return member;
	}
	
	//회원가입
	public void signIn() throws ClassNotFoundException, SQLException{
		String name = "";
		String id = "";
		String pw = "";
		Scanner scan = new Scanner(System.in);
		
		System.out.print("> 이름 : ");
		name = scan.nextLine();
		
		System.out.print("> ID : ");
		id = scan.nextLine();
		
		System.out.print("> 비밀번호 : ");
		pw = scan.nextLine();
		System.out.println("-----------------------------------------------");
		memberService.createId(name, id, pw);
	}
}
