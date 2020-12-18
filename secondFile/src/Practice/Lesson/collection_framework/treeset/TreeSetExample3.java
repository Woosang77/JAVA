package Practice.Lesson.collection_framework.treeset;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample3 {

	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<>();
		//String TreeSet�� ���ĺ��� ���� ���� ���� ������, ���߿� ���� ���� ���� ��忡 ��ġ�Ѵ�.
		treeSet.add("apple");
		treeSet.add("forever");
		treeSet.add("description");
		treeSet.add("ever");
		treeSet.add("zoo");
		treeSet.add("base");
		treeSet.add("guess");
		treeSet.add("cherry");
		
		//c���� f���̿� ���ĺ����� �����ϴ� �ܾ ������ ����ϱ�
		System.out.println("[c~f ������ �ܾ� �˻�]");
		//.subSet(fromElement, fromInclusive, toElement, toInclusive);
		/*
		 * fromElement : ���� ��
		 * fromInclusive : ���� ���� ���� ����
		 * toElement : �� ��
		 * toInclusive : �� ���� ���� ����
		 */
		NavigableSet<String> rangeSet = treeSet.subSet("c", true, "f", true);
		for (String word : rangeSet) {
			System.out.print(word + " ");
		}
		// ��� : cherry description ever 
		/*
		 * f���� �����ε� forever�� ���� ����
		 * f�� ���� ��, f�� �����ϴ� ��� �ܾ�� f�ڿ� �ٸ� ���ĺ��� ���� ���̱� ������ 
		 * f ���ĺ� ���� �� ������ ��ġ�ȴ�.
		 */
	}

}
