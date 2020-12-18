package Practice.Lesson.collection_framework.comparator;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparatorExample {
	public static void main(String[] args) {
		TreeSet<Fruit> treeSet = new TreeSet<>(new DescendingComparator());		//new DescendingComparator()   == 정렬자
		
		treeSet.add(new Fruit("포도", 3000));
		treeSet.add(new Fruit("수박", 10000));
		treeSet.add(new Fruit("딸기", 6000));
		
		Iterator<Fruit> iterator = treeSet.iterator();
		while (iterator.hasNext()) {
			Fruit fruit = iterator.next();
			System.out.println(fruit.name + " " + fruit.price);		//정렬자 생성 전)  오류발생 ClassCastException (Comparable을 구현하지 않았기 때문)
			//만약 Fruit이 Comparable을 구현할 수 없는 상황이라면??
			//정렬자 Comparator를 이용하면 된다.
		}
		//		정렬자 생성 후)
		//		포도 3000
		//		딸기 6000
		//		수박 10000

	}
}
