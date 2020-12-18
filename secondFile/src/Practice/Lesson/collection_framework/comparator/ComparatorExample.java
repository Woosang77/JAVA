package Practice.Lesson.collection_framework.comparator;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparatorExample {
	public static void main(String[] args) {
		TreeSet<Fruit> treeSet = new TreeSet<>(new DescendingComparator());		//new DescendingComparator()   == ������
		
		treeSet.add(new Fruit("����", 3000));
		treeSet.add(new Fruit("����", 10000));
		treeSet.add(new Fruit("����", 6000));
		
		Iterator<Fruit> iterator = treeSet.iterator();
		while (iterator.hasNext()) {
			Fruit fruit = iterator.next();
			System.out.println(fruit.name + " " + fruit.price);		//������ ���� ��)  �����߻� ClassCastException (Comparable�� �������� �ʾұ� ����)
			//���� Fruit�� Comparable�� ������ �� ���� ��Ȳ�̶��??
			//������ Comparator�� �̿��ϸ� �ȴ�.
		}
		//		������ ���� ��)
		//		���� 3000
		//		���� 6000
		//		���� 10000

	}
}
