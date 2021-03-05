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
	private Member member;
	private int count;
	private int lastPage;
	//Default
	private String searchField = "TITLE";
	private String searchWord = "";
	private int page = 1;
	
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
		System.out.println("-----------------------------------------------");
		for (Book book : list) {
			System.out.printf("%d | %s | %s | %s\n",
					book.getId(),
					book.getTitle(),
					book.getWriter(),
					book.alterRent(book.getRent())
					);
		}
		System.out.println("-----------------------------------------------");
		System.out.printf("		%d/%d pages\n",page,lastPage);
		System.out.printf(
				"< 1. 대여 / 2. 반납 / 3. 이전 / 4. 다음 / 5. 대여목록 / 6. 검색 / 7. 나가기 >\n"
				);
		System.out.println("-----------------------------------------------");
		System.out.print("> ");
		
		int num = scan.nextInt();
		scan.nextLine();
		return num;
	}

	//1. 대여
	public void rentBook() throws ClassNotFoundException, SQLException{
		String expire = "";
		Scanner scan = new Scanner(System.in);

		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy년 MM월 dd일");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);	
		cal.add(Calendar.DATE, +14);
		expire = sdformat.format(cal.getTime());
		
		System.out.print("> 도서번호 : ");
		int id = scan.nextInt();
		scan.nextLine();
		List<Book> list = bookService.find("ID", id);
		Book book = list.get(0);
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
	}
	
	//2. 반납 (수정 필요)
	public void returnBook() throws ClassNotFoundException, SQLException{
		List<Book> list = bookService.find("RENTID", member.getSerialId());
		boolean check = false;
		String date = "";
		Scanner scan = new Scanner(System.in);
		
		System.out.println("<반납 대상 도서>");
		rentedBook();
		System.out.println("-----------------------------------------------");
		System.out.print("> 도서번호 : ");
		int id = scan.nextInt();
		scan.nextLine();
		for (Book book : list) {
			if (book.getId() != id) {continue;}
			check = true;
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
				System.out.println("-----------------------------------------------");
				System.out.println("< 반납 완료 >");
				bookService.updateToRent(id, 1, member.getSerialId(),date);
			} 
		}
		if (check != true) {
			System.out.println("찾는 결과 없음(반납 불가 도서)");
		}
	}
	
	//search
	public void searchFilter() {
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
			System.out.println("이전 페이지가 없습니다.");
			return;
		}
		page--;
	}
	
	//4. 다음
	public void MoveNextPage() throws ClassNotFoundException, SQLException{
		int count = bookService.getCount(searchField, searchWord);
		int lastPage = count /10;
		lastPage = count % 10>0 ? lastPage+1:lastPage;
		if (page == lastPage) {
			System.out.println("마지막 페이지입니다.");
			return;
		}
		page++;
	}
	
	//5.대여한 도서 목록
	public void rentedBook() throws ClassNotFoundException, SQLException{
		List<Book> list = bookService.find("RENTID", member.getSerialId());
		int count = list.size();
		System.out.println("-----------------------------------------------");
		System.out.printf("%s님 앞으로 %d권 대여되어있습니다.\n",member.getName(), count);
		for (Book book : list) {
			System.out.printf("%d | %s | %s | %s\n",
					book.getId(),
					book.getTitle(),
					book.getWriter(),
					book.getExpiration()
				);
		}
	}
}
