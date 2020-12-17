package Practice.Lesson.collection_framework.set;

import java.util.Objects;

public class Member {
	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.age = age;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member member = (Member) obj;
			return member.name.equals(name) && member.age ==age;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}
}
