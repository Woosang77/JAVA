package Practice.Lesson.collection_framework.treemap;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample2 {
	public static void main(String[] args) {
		TreeMap<Integer, String> scores = new TreeMap<>();
		scores.put(87, "ȫ�浿");
		scores.put(98, "�̵���");
		scores.put(75, "�ڱ��");
		scores.put(95, "�ſ��");
		scores.put(80, "���ڹ�");
		
		NavigableMap<Integer, String> descendingMap = scores.descendingMap();
		//descendingMap() key�� ������ ������������ ���ĵ� NavigableMap�� �����.
		Set<Map.Entry<Integer, String>> descendingEntrySet = descendingMap.entrySet();
		//Map�� �޼ҵ��� .entrySet�� ���� key�� value�� ������ Map.entry Ÿ�԰�ü���� Set���� ����ȴ�.
		for (Map.Entry<Integer, String> entry : descendingEntrySet) {
			System.out.println(entry.getKey() + "  " + entry.getValue());
		}
		//		98  �̵���
		//		95  �ſ��
		//		87  ȫ�浿
		//		80  ���ڹ�
		//		75  �ڱ��
	}
}
