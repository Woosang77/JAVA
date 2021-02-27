package jdbc_self.app.librabyPrj.model;

public class Member {

	private String name;
	private String age;
	private String id;
	private String pw;
	
	public Member(String name, String age, String id, String pw) {
		this.name = name;
		this.age = age;
		this.id = id;
		this.pw = pw;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
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
	
	
}
