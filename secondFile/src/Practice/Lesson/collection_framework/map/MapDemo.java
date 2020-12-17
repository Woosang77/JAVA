package Practice.Lesson.collection_framework.map;

import java.util.*;

public class MapDemo {

	public static void main(String[] args) {
		HashMap<String, Integer> a = new HashMap<>(); 	//List�� Set�� �޸� ���׸��� �ΰ��̴�.(key, value)
		
		a.put("one", 1);		//put�� map������ ��밡��(�Ķ���ʹ� �ΰ�/key, value)
		a.put("two", 2);
		a.put("three", 3);
		a.put("four", 4);
		
		System.out.println(a.get("one"));		//get�� key���� ���� value�� �����´�.
		System.out.println(a.get("two"));
		System.out.println(a.get("three"));
		
		iteratorUsingForEach(a);
	}
	
	static void iteratorUsingForEach(HashMap map) {
		Set<Map.Entry<String, Integer>> entries = map.entrySet();		//map �������̽�����.entrySet()�� ����Ǿ��ִµ�, Set������Ÿ�� 
		for (Map.Entry<String, Integer> entry : entries	 ) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}		//iteratorUsingForEach(a); �� ���� ���� : HashMapŸ���� a�� map�� �Ķ���ͷ� �ְ� 
			//.entrySet�޼ҵ带 ���� key�� value�� ������ ��Ʈ������ Map�� �������̽��� EntryŸ���̰�, key�� value��
			// String�� Integer�� �����ϴ� entries��� �̸��� ����(Set)�� ��´�.
			//for���� ���� Map.Entry<String, Integer>������ ��Ʈ������ entries���� �ϳ��� ������ entry�� ��� �����Ѵ�.
}
