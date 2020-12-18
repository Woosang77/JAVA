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
		//둘 다 가능 어차피 자동 박싱됨
		
		Integer score = null;
		
		score = scores.first();
		System.out.println(score);	//75
		//가장 왼쪽에 있는 객체를 리턴 이진트리에서 가장 왼쪽 값이 가장 작은 첫번째 정렬의 수

		score = scores.last();
		//가장 큰 수는 이진트리상 가장 마지막 정렬에 들어오기 때문에 가장 오른쪽 객체 리턴
		System.out.println(score);	//98
		
		score = scores.lower(95);
		//lower(e)는 매개값으로 받는 e의 아랫단에 있는 노드를 가져온다. 한 노드에 두 개의 자식 노드가 있는데, 왼쪽이 작은 노드이므로 왼쪽 노드를 호출시킨다.
		System.out.println(score);	//87
		
		score = scores.higher(95);
		//higher(e)는 e객체보다 바로 한 단계위의 객체를 리턴한다. 즉, 주 노드 기준 오른쪽을 의미한다.
		System.out.println(score); //98
		
		score = scores.floor(new Integer(94));
		//floor(e)는 e객체를 찾고 있다면, 해당 객체를 출력한다. 하지만, e객체가 없다면, e보다 작은 값 중 가장 가까운 값을 찾는다.
		//즉 해당 값이 없다면 아랫방향의 값을 리턴
		System.out.println(score);	
		
		score = scores.ceiling(new Integer(85));
		//ceiling(e)는 e를 찾고 있으면 리턴, 없다면 e보다 큰 값들 중 가장 가까운 값을 리턴
		//즉, 해당 값이 없다면 윗방향의 값을 리턴
		System.out.println(score);	
		
		//Treeset의 저장 값을 하나씩 가져와서 출력
		while (!scores.isEmpty()) {
			score = scores.pollFirst();
			//제일 왼쪽 자식 노드부터 하나씩 빼낸다. pollfirst()로 객체를 뺴면 TreeSet에서 해당객체가 사라진다.
			//pollLast()는 pollfirst()의 반대로 가장 오른쪽에 있는 자식을 리턴하고 삭제시킨다.
			System.out.println(score + "\t" + scores.size());
			/*
			 *  75	4
			 *  80	3
			 *  87	2
			 *  95	1
			 *  98	0
			 */
		}
		//원래 Set Collection 출력 방법
		Iterator<Integer> iterator = scores.iterator();
		while (iterator.hasNext()) {
			int s = iterator.next();
			System.out.println(s);
		}
		/*
		 * 위 두 방법의 차이점은 객체 리턴 후 리턴된 객체의 삭제여부이다.
		 * pollFirst()는 노드 객체를 리턴 한 후 TreeSet에서 완전히 삭제를 시키지만,
		 * Iterator를 통한 while문 실행은 리턴된 객체를 삭제시키지 않는다.
		 */
	}

}
