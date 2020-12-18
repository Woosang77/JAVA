package Practice.Lesson.collection_framework.treemap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
	public static void main(String[] args) {
		TreeMap<Integer, String> scores = new TreeMap<>();
		//TreeMap�� Ű ���� ��� �񱳸� ���� ��尴ü�� ��ġ�Ѵ�.
		//�޼ҵ� ��ü�� ���� �����̳� ������ TreeSet�� �����ϴ�.
		scores.put(87, "ȫ�浿");
		scores.put(98, "�̵���");
		scores.put(75, "�ڱ��");
		scores.put(95, "�ſ��");
		scores.put(80, "���ڹ�");
		
		Map.Entry<Integer, String> entry = null;
		
		entry = scores.firstEntry();
		System.out.println(entry.getKey() + " " + entry.getValue());	//		75 �ڱ��
		
		entry = scores.lastEntry();
		System.out.println(entry.getKey() + " " + entry.getValue());	//		98 �̵���
		
		entry = scores.lowerEntry(95);
		System.out.println(entry + " ");	// 87=ȫ�浿 
		
		entry = scores.higherEntry(95);
		System.out.println(entry + " ");	// 98=�̵��� 
		
		entry = scores.floorEntry(95);
		System.out.println(entry + " ");	// 95=�ſ��
		
		entry = scores.ceilingEntry(95);
		System.out.println(entry + " ");	// 95=�ſ��  
		
		
		while (!scores.isEmpty()) {
			entry = scores.pollFirstEntry();
			System.out.println(entry.getKey() + "  " + entry.getValue() + "  " + scores.size());
			//			75  �ڱ��  4
			//			80  ���ڹ�  3
			//			87  ȫ�浿  2
			//			95  �ſ��  1
			//			98  �̵���  0
		}
	}
}
