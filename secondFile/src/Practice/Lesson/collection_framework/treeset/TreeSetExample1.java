package Practice.Lesson.collection_framework.treeset;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample1 {

	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<>();
		
		scores.add(new Integer(87));
		scores.add(new Integer(98));
		scores.add(new Integer(75));
		scores.add(95);
		scores.add(80);
		//�� �� ���� ������ �ڵ� �ڽ̵�
		
		Integer score = null;
		
		score = scores.first();
		System.out.println(score);	//75
		//���� ���ʿ� �ִ� ��ü�� ���� ����Ʈ������ ���� ���� ���� ���� ���� ù��° ������ ��

		score = scores.last();
		//���� ū ���� ����Ʈ���� ���� ������ ���Ŀ� ������ ������ ���� ������ ��ü ����
		System.out.println(score);	//98
		
		score = scores.lower(95);
		//lower(e)�� �Ű������� �޴� e�� �Ʒ��ܿ� �ִ� ��带 �����´�. �� ��忡 �� ���� �ڽ� ��尡 �ִµ�, ������ ���� ����̹Ƿ� ���� ��带 ȣ���Ų��.
		System.out.println(score);	//87
		
		score = scores.higher(95);
		//higher(e)�� e��ü���� �ٷ� �� �ܰ����� ��ü�� �����Ѵ�. ��, �� ��� ���� �������� �ǹ��Ѵ�.
		System.out.println(score); //98
		
		score = scores.floor(new Integer(94));
		//floor(e)�� e��ü�� ã�� �ִٸ�, �ش� ��ü�� ����Ѵ�. ������, e��ü�� ���ٸ�, e���� ���� �� �� ���� ����� ���� ã�´�.
		//�� �ش� ���� ���ٸ� �Ʒ������� ���� ����
		System.out.println(score);	
		
		score = scores.ceiling(new Integer(85));
		//ceiling(e)�� e�� ã�� ������ ����, ���ٸ� e���� ū ���� �� ���� ����� ���� ����
		//��, �ش� ���� ���ٸ� �������� ���� ����
		System.out.println(score);	
		
		//Treeset�� ���� ���� �ϳ��� �����ͼ� ���
		while (!scores.isEmpty()) {
			score = scores.pollFirst();
			//���� ���� �ڽ� ������ �ϳ��� ������. pollfirst()�� ��ü�� ���� TreeSet���� �ش簴ü�� �������.
			//pollLast()�� pollfirst()�� �ݴ�� ���� �����ʿ� �ִ� �ڽ��� �����ϰ� ������Ų��.
			System.out.println(score + "\t" + scores.size());
			/*
			 *  75	4
			 *  80	3
			 *  87	2
			 *  95	1
			 *  98	0
			 */
		}
		//���� Set Collection ��� ���
		Iterator<Integer> iterator = scores.iterator();
		while (iterator.hasNext()) {
			int s = iterator.next();
			System.out.println(s);
		}
		/*
		 * �� �� ����� �������� ��ü ���� �� ���ϵ� ��ü�� ���������̴�.
		 * pollFirst()�� ��� ��ü�� ���� �� �� TreeSet���� ������ ������ ��Ű����,
		 * Iterator�� ���� while�� ������ ���ϵ� ��ü�� ������Ű�� �ʴ´�.
		 */
	}

}
