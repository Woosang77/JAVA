package Practice.Lesson.collection_framework.set.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();
		
		set.add(new Member("ȫ�浿", 30));
		set.add(new Member("ȫ�浿", 30));
		//���� �ٸ� ��ü������ �̸��� ���̰� ���ٸ� ���ü�� ������?
		//�ؽ����� �ߺ������� �ɱ�?
		
		System.out.println(set.size());		//1
		//HashSet�� ���� �ٸ� ��ü�̴��� Hashcode�� ���Ѵ�. ���� ���ٸ� ���ü�� �����Ͽ� �� �� �ϳ��� �����Ѵ�.
		//���� Member�� �ؽ��ڵ� �������Ͽ�, �̸��� �ؽð��� ���̸� ���� ������ �����߱⶧���� �ؽð��� ����.
	}
}
