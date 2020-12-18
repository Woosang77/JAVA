package Practice.Lesson.collection_framework.treeset;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample2 {

	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<>();
		
		scores.add(new Integer(87));
		scores.add(new Integer(98));
		scores.add(new Integer(75));
		scores.add(95);
		scores.add(80);
		
		//������������ ���� descending~
		NavigableSet<Integer> descendingSet = scores.descendingSet();
		for (Integer score : descendingSet) {
			System.out.print(score + " ");		//	(98 95 87 80 75) �������� ���� Ȯ��
		}
		System.out.println();
		
		//���� �ٽ� �Ѵٸ� ���������� �ٽ� descending�� �Ѵٸ�?
		NavigableSet<Integer> ascendingSet  = descendingSet.descendingSet();
		for (Integer score : ascendingSet) {
			System.out.print(score + " ");		//	(75 80 87 95 98 ) �������� ���� Ȯ��
		}
		System.out.println();
		/*
		 * �⺻������ TreeSet���� descending�� ������������ ��������,
		 * descending�� �ܼ��� ���������� �ϴ� �ͺ��ٴ� ������ �ڹٲ۴ٴ� ������ �´�.
		 */
	}

}
