package Practice.Lesson.collection_framework.comparable;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparableExample {
		//TreeSet과 TreeMap은 기본적으로 정렬을 위해 저장 객체에게 Comparable인터페이스 구현을 요구한다.
		//String, int, double은 모두 기본적으로 Comparable을 구현하고 있기 때문에 이전 예제들이 진행된 것이다.
		//직접 객체를 정의해서 사용하려면 해당 객체는 반드시 Comparable를 구현하고, CompareTo()를 재정의 해야한다.
	public static void main(String[] args) {
		TreeSet<Person> treeSet = new TreeSet<>();
		
		treeSet.add(new Person("홍길도", 40));
		treeSet.add(new Person("김철수", 25));
		treeSet.add(new Person("김영덕", 30));
		
		Iterator<Person> iterator = treeSet.iterator();
		while (iterator.hasNext()) {
			Person person = iterator.next();
			System.out.println(person.name + "  " + person.age);
//			김철수  25
//			김영덕  30
//			홍길도  40
		}
	}

}
