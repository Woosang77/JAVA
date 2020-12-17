package Practice.Lesson.collection_framework.set.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetPractice {
/*Set 인터페이스는 Collection FrameWork의 일부로서 특징을 가진다.
*	=====수학적으로 집합과 일치한다.=====
*	1. Set은 같은 값을 중복하여 삽입할 수 없다. 
*	2. List와는 다르게 특정한 순서를 가지고 있지 않고 바구니속에 들어있다고 생각하면 된다.
*	iterator를 사용해서 저장된 객체를 가져온다.
*/
	public static void main(String[] args) {
		HashSet<Integer> set1 = new HashSet<>();
		set1.add(10);
		set1.add(10);
		set1.add(20);
		set1.add(20);
		set1.add(40);
		
		Iterator iter = set1.iterator(); 		//Set컬렉션의 메소드 중 반복자 iterator를 객체와 시키는 Iterator를 생성한다.
		while(iter.hasNext()) {			//.hasNext()는 가져올 객체가 있으면 true 아니면 false
			System.out.println(iter.next());		//.next()
		}
		/*
		 * Iterator 구조적 이해하기
		 * set1에서 iterator메소드를 iter이름으로 생성하면 set1에서 저장된 인스턴스들을 복사하여 iter에 저장한다.
		 * iter안에 값이 있는지 .hasNext()로 확인하고 true가 반환되면 실행이 된다.
		 * .next()는 iter안에 있는 값 중 하나를 리턴시키고 메모리에서 삭제시킨다.
		 * 위 같은 사이클이 while문을 만족할 때까지 반복한다.
		 */
	}
}

