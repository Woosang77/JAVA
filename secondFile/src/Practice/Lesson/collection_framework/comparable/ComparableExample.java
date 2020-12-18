package Practice.Lesson.collection_framework.comparable;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparableExample {
		//TreeSet�� TreeMap�� �⺻������ ������ ���� ���� ��ü���� Comparable�������̽� ������ �䱸�Ѵ�.
		//String, int, double�� ��� �⺻������ Comparable�� �����ϰ� �ֱ� ������ ���� �������� ����� ���̴�.
		//���� ��ü�� �����ؼ� ����Ϸ��� �ش� ��ü�� �ݵ�� Comparable�� �����ϰ�, CompareTo()�� ������ �ؾ��Ѵ�.
	public static void main(String[] args) {
		TreeSet<Person> treeSet = new TreeSet<>();
		
		treeSet.add(new Person("ȫ�浵", 40));
		treeSet.add(new Person("��ö��", 25));
		treeSet.add(new Person("�迵��", 30));
		
		Iterator<Person> iterator = treeSet.iterator();
		while (iterator.hasNext()) {
			Person person = iterator.next();
			System.out.println(person.name + "  " + person.age);
//			��ö��  25
//			�迵��  30
//			ȫ�浵  40
		}
	}

}
