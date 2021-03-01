package jdbc_self.app.librabyPrj.model;

public class Book {
	
	private int id;
	private String name;
	private String title;
	private String writer;
	private String rent;
	
	public Book(int id, String title, String writer, String rent) {
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.rent = rent;
	}
	
	//Getter & Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public int getId() {
		return id;
	}
	
	public String alterRent(String rent) {
		
		if (rent.equals("1")) {
			return "대여가능";
		} else {
			return "대여불가";
		}
	}

}
