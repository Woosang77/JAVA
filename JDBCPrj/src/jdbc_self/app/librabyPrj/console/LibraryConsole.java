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
		System.out.printf("    ���� ������ [���� �� : %d��]\n", count); 
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
				"< 1. �뿩 / 2. �ݳ� / 3. ���� / 4. ���� / 5. �˻� / 6. ������ >\n"
				);
		System.out.println("-----------------------------------------------");
		System.out.print("> ");
		
		String num_ = scan.nextLine();
		int num = Integer.parseInt(num_);
		return num;
	}

	//1. �뿩
	public void rentBook() throws ClassNotFoundException, SQLException{
		String expire = "";
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy�� MM�� dd��");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);	
		cal.add(Calendar.DATE, +14);
		expire = sdformat.format(cal.getTime());
		
		Scanner scan = new Scanner(System.in);
		System.out.print("> ������ȣ : ");
		String book_id = scan.nextLine();
		int id = Integer.parseInt(book_id);
		Book book = bookService.find(id);
		System.out.println("< �˻���� >");
		System.out.printf("> %d | %s | %s | %s\n",
				book.getId(),
				book.getTitle(),
				book.getWriter(),
				book.alterRent(book.getRent())
			);
		System.out.print("> ���� �Ͻðڽ��ϱ�? ( Y / N) : ");
		String answer = scan.nextLine();
		if (answer.equals("Y") || answer.equals("y")) {
			if (book.getRent().equals("0")) {
				System.out.println("> ����Ϸ�� �����Դϴ�.");
				return;
			}
			System.out.println("-----------------------------------------------");
			System.out.printf("< ���� �Ϸ� >\n"+
					"�뿩�� : %s\n�ݳ��� : %s\n", member.getId(), expire);
			bookService.updateToRent(id, 0, member.getSerialId());
		}
		return;
	}
	
	//2. �ݳ�
	public void returnBook() throws ClassNotFoundException, SQLException{
		Scanner scan = new Scanner(System.in);
		System.out.print("> ������ȣ : ");
		String book_id = scan.nextLine();
		int id = Integer.parseInt(book_id);
		Book book = bookService.find(id);
		if (book.getRent().equals("1")) {
			System.out.println("����� ������ �ƴմϴ�.");
			return;
		}
		System.out.println("< �˻���� >");
		System.out.printf("> %d | %s | %s | %s\n",
				book.getId(),
				book.getTitle(),
				book.getWriter(),
				book.alterRent(book.getRent())
			);
		System.out.print("> �ݳ� �Ͻðڽ��ϱ�? ( Y / N) : ");
		String answer = scan.nextLine();
		if (answer.equals("Y") || answer.equals("y")) {
			System.out.println("< �ݳ� �Ϸ� >");
			bookService.updateToRent(id, 1, member.getSerialId());
		}
		
	}
	
	//search
	public void inputSearchWord() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�˻� ���� (Title / Writer )�߿� �ϳ��� �Է��ϼ���.");
		System.out.print("> ");
		searchField = scan.nextLine();
		
		System.out.print("�˻��� > ");
		searchWord = scan.nextLine();
	}
	
	//3. ����
	public void movePrePage() {
		if (page == 1) {
			System.out.println("�������������Դϴ�.");
			return;
		}
		page--;
	}
	
	//4. ����
	public void MoveNextPage() {
		if (page == lastPage) {
			System.out.println("������ �������Դϴ�.");
			return;
		}
		page++;
	}
}
