package jdbc_self.app.librabyPrj.console;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import jdbc_self.app.librabyPrj.model.Book;
import jdbc_self.app.librabyPrj.model.Member;
import jdbc_self.app.librabyPrj.service.BookService;

public class LibraryConsole {
	private BookService bookService;
	private String searchField = "TITLE";
	private String searchWord = "";
	private int page = 1;
	private int count;
	private int lastPage;
	private Member member;
	
	public LibraryConsole() {
		bookService = new BookService();
	}
	
	public void connect(Member member) {
		this.member = member;
	}
	
	public int start() throws ClassNotFoundException, SQLException{
		Scanner scan = new Scanner(System.in);
		List<Book> list = bookService.getList(page, searchField, searchWord);
		count = bookService.getCount(searchField, searchWord);
		int lastPage = count / 10;
		lastPage = count % 10 > 0? lastPage+1:lastPage;
		
		System.out.println("-----------------------------------------------");
		System.out.println("					" + member.getName());
		System.out.printf("    오복 도서관 [도서 수 : %d권]\n", count); 
		System.out.println("-----------------------------------------------");
		System.out.println("<ID> | <Title> | <Writer> | <Rentable>");
		for (Book book : list) {
			System.out.printf("%d | %s | %s | %s\n",
					book.getId(),
					book.getTitle(),
					book.getWriter(),
					book.alterRent(book.getRent())
					);
		}
		System.out.printf("		%d/%d pages\n",page,lastPage);
		System.out.printf(
				"< 1. 대여 / 2. 반납 / 3. 이전 / 4. 다음 / 5. 검색 / 6. 나가기 >\n"
				);
		System.out.println("-----------------------------------------------");
		System.out.print("> ");
		
		String num_ = scan.nextLine();
		int num = Integer.parseInt(num_);
		return num;
	}

	//1. 대여
	public void rentBook() throws ClassNotFoundException, SQLException{
		String expire = "";
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy년 MM월 dd일");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);	
		cal.add(Calendar.DATE, +14);
		expire = sdformat.format(cal.getTime());
		
		Scanner scan = new Scanner(System.in);
		System.out.print("> 도서번호 : ");
		String book_id = scan.nextLine();
		int id = Integer.parseInt(book_id);
		Book book = bookService.find(id);
		System.out.println("< 검색결과 >");
		System.out.printf("> %d | %s | %s | %s\n",
				book.getId(),
				book.getTitle(),
				book.getWriter(),
				book.alterRent(book.getRent())
			);
		System.out.print("> 대출 하시겠습니까? ( Y / N) : ");
		String answer = scan.nextLine();
		if (answer.equals("Y") || answer.equals("y")) {
			if (book.getRent().equals("0")) {
				System.out.println("> 대출완료된 도서입니다.");
				return;
			}
			System.out.println("-----------------------------------------------");
			System.out.printf("< 대출 완료 >\n"+
					"대여인 : %s\n반납일 : %s\n", member.getId(), expire);
			bookService.updateToRent(id, 0, member.getSerialId(), expire);
		}
		return;
	}
	
	//2. 반납
	public void returnBook() throws ClassNotFoundException, SQLException{
		String date = "";
		Scanner scan = new Scanner(System.in);
		System.out.print("> 도서번호 : ");
		String book_id = scan.nextLine();
		int id = Integer.parseInt(book_id);
		Book book = bookService.find(id);
		if (book.getRent().equals("1")) {
			System.out.println("대출된 도서가 아닙니다.");
			return;
		}
		System.out.println("< 검색결과 >");
		System.out.printf("> %d | %s | %s | %s\n",
				book.getId(),
				book.getTitle(),
				book.getWriter(),
				book.alterRent(book.getRent())
			);
		System.out.print("> 반납 하시겠습니까? ( Y / N) : ");
		String answer = scan.nextLine();
		if (answer.equals("Y") || answer.equals("y")) {
			System.out.println("< 반납 완료 >");
			bookService.updateToRent(id, 1, member.getSerialId(),date);
		}
		
	}
	
	//search
	public void inputSearchWord() {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색 범주 (Title / Writer )중에 하나를 입력하세요.");
		System.out.print("> ");
		searchField = scan.nextLine();
		
		System.out.print("검색어 > ");
		searchWord = scan.nextLine();
	}
	
	//3. 이전
	public void movePrePage() {
		if (page == 1) {
			System.out.println("마지막페이지입니다.");
			return;
		}
		page--;
	}
	
	//4. 다음
	public void MoveNextPage() {
		if (page == lastPage) {
			System.out.println("마지막 페이지입니다.");
			return;
		}
		page++;
	}
}
