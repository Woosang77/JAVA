package jdbc_self.app.librabyPrj.console;

import java.sql.SQLException;

import java.util.Scanner;

import jdbc_self.app.librabyPrj.model.Member;
import jdbc_self.app.librabyPrj.service.MemberService;

public class MemberConsole {
	
	MemberService memberService;
	Member member;
	String user = "No Log In...";
	Boolean logInState;
	
	public MemberConsole() {
		memberService = new MemberService();
	}
	
	
	//����â
	public int start() {
		Scanner scan = new Scanner(System.in);
		logInCheck();
		System.out.println("-----------------------------------------------");
		System.out.println(user);
		System.out.println("-----------------------------------------------");
		System.out.printf(
				"< 1. �α��� / 2. ȸ������ / 3. ������  >\n"
				);
		System.out.println("-----------------------------------------------");
		System.out.print("> ");
		String num_ = scan.nextLine();
		int num = Integer.parseInt(num_);
		return num;
	}
	
	//�α��� ����
	public void logInCheck ( ) {
		if (member != null) {
			logInState = true;
			user = member.getName();
		}else {
			logInState = false;
		}
	}
	
	//�α���
	public Member logIn( ) throws ClassNotFoundException, SQLException{
		String id = "";
		String pw = "";
		Scanner scan = new Scanner(System.in);
		System.out.println("----------------------�α���ȭ��-----------------");
		System.out.print("> ID : ");
		id = scan.nextLine();
		
		System.out.print("> PW : ");
		pw = scan.nextLine();
		member = memberService.searchMember(id, pw);
		user = member.getName();
		return member;
	}
	
	//ȸ������
	public void signIn() throws ClassNotFoundException, SQLException{
		String name = "";
		String id = "";
		String pw = "";
		Scanner scan = new Scanner(System.in);
		
		System.out.print("> �̸� : ");
		name = scan.nextLine();
		
		System.out.print("> ID : ");
		id = scan.nextLine();
		
		System.out.print("> ��й�ȣ : ");
		pw = scan.nextLine();
		
		memberService.createId(name, id, pw);
	}
}
