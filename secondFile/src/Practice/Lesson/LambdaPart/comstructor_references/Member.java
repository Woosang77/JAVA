package Practice.Lesson.LambdaPart.comstructor_references;

public class Member {
	private String name;
	private String id;
	
	public Member() {
		System.out.println("Member() ����");
	}
	
	public Member(String id) {
		System.out.println("Member(String id) ����");
		this.id = id;
	}
	
	public Member(String name, String id) {
		System.out.println("Member(String name, String id) ����");
		this.id = id;
		this.name = name;
	}
}

