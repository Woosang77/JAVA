package Practice.Lesson.stream.stream_pipelines;

public class Member {
	public static int MALE = 0;
	public static int FEMALE = 1;
	
	
	private String name;
	private int sex;
	private int age;
	
	public Member(String name, int sex, int age) {
	this.name = name;
	this.age = age;
	this.sex = sex;
	}

	public int getSex() {
		return sex;
	}

	public int getAge() {
		return age;
	}
	
	
}
