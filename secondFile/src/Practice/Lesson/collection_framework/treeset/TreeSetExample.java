package Practice.Lesson.collection_framework.treeset;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<>();
		
		scores.add(new Integer(87));
		scores.add(new Integer(98));
		scores.add(new Integer(75));
		scores.add(95);
		scores.add(80);
		
		//내림차순으로 정렬 descending~
		NavigableSet<Integer> descendingSet = scores.descendingSet();
		for (Integer score : descendingSet) {
			System.out.print(score + " ");		//	(98 95 87 80 75) 내림차순 정렬 확인
		}
		System.out.println();
		
		//만약 다시 한다면 내림차순에 다시 descending을 한다면?
		NavigableSet<Integer> ascendingSet  = descendingSet.descendingSet();
		for (Integer score : ascendingSet) {
			System.out.print(score + " ");		//	(75 80 87 95 98 ) 오름차순 정렬 확인
		}
		System.out.println();
		/*
		 * 기본적으로 TreeSet에서 descending은 내림차순으로 만들지만,
		 * descending은 단순히 내림차순을 하는 것보다는 순서를 뒤바꾼다는 개념이 맞다.
		 */
	}

}
