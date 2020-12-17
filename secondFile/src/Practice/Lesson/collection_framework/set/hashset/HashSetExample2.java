package Practice.Lesson.collection_framework.set.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();
		
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));
		//서로 다른 객체이지만 이름과 나이가 같다면 동등객체가 같을까?
		//해쉬샛의 중복저장이 될까?
		
		System.out.println(set.size());		//1
		//HashSet은 서로 다른 객체이더라도 Hashcode를 비교한다. 만약 같다면 동등객체로 간주하여 둘 중 하나만 저장한다.
		//현재 Member의 해쉬코드 재정의하여, 이름의 해시값과 나이를 더한 것으로 설정했기때문에 해시값이 같다.
	}
}
