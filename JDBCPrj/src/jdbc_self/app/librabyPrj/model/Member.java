package jdbc_self.app.librabyPrj.model;

public class Member {
	
	private int serialId;
	private String name;
	private String id;
	private String pw;
	
	public Member() {
		
	}
	public Member(String name) {
		super();
		this.name = name;
	}
	public Member(String name, String id, String pw) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getSerialId() {
		return serialId;
	}
	public void setSerialId(int serialId) {
		this.serialId = serialId;
	}
	
	
}
