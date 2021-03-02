package jdbc_self.app.librabyPrj.model;

public class Book {
	
	private int id;
	private String title;
	private String writer;
	private String rent;
	private String expiration;
	
	public Book() {
	}
	
	public Book(int id, String title, String writer, String rent, String expiration) {
		super();
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.rent = rent;
		this.expiration = expiration;
	}
	
	//Getter & Setter
	
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
	
	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public String alterRent(String rent) {
		
		if (rent.equals("1")) {
			return "대여가능";
		} else {
			return "대여불가";
		}
	}

}
