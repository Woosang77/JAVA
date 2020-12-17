package Practice.Lesson.collection_framework.set.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetPractice {
/*Set �������̽��� Collection FrameWork�� �Ϻημ� Ư¡�� ������.
*	=====���������� ���հ� ��ġ�Ѵ�.=====
*	1. Set�� ���� ���� �ߺ��Ͽ� ������ �� ����. 
*	2. List�ʹ� �ٸ��� Ư���� ������ ������ ���� �ʰ� �ٱ��ϼӿ� ����ִٰ� �����ϸ� �ȴ�.
*	iterator�� ����ؼ� ����� ��ü�� �����´�.
*/
	public static void main(String[] args) {
		HashSet<Integer> set1 = new HashSet<>();
		set1.add(10);
		set1.add(10);
		set1.add(20);
		set1.add(20);
		set1.add(40);
		
		Iterator iter = set1.iterator(); 		//Set�÷����� �޼ҵ� �� �ݺ��� iterator�� ��ü�� ��Ű�� Iterator�� �����Ѵ�.
		while(iter.hasNext()) {			//.hasNext()�� ������ ��ü�� ������ true �ƴϸ� false
			System.out.println(iter.next());		//.next()
		}
		/*
		 * Iterator ������ �����ϱ�
		 * set1���� iterator�޼ҵ带 iter�̸����� �����ϸ� set1���� ����� �ν��Ͻ����� �����Ͽ� iter�� �����Ѵ�.
		 * iter�ȿ� ���� �ִ��� .hasNext()�� Ȯ���ϰ� true�� ��ȯ�Ǹ� ������ �ȴ�.
		 * .next()�� iter�ȿ� �ִ� �� �� �ϳ��� ���Ͻ�Ű�� �޸𸮿��� ������Ų��.
		 * �� ���� ����Ŭ�� while���� ������ ������ �ݺ��Ѵ�.
		 */
	}
}

