package Practice.Lesson.stream.stream_collect;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ToListExample {
	/*
	 * ����(Collect)�� ���͸��� ���ε����� ���� ���� ó�� ��ҵ��� �����Ͽ� �÷��ǿ� �����Ѵ�.
	 * ������ ��Ʈ������ .collect(Collector)�� ����ϸ�ȴ�.
	 *  �Ű��� Ÿ���� Collector�� Collector�� ���� ��ü�� Collectors�� �����޼ҵ带 ����Ѵ�.  
	 */
	public static void main(String[] args) {
		List<Student> totalList = Arrays.asList(
			new Student("ȫ�浿", 10, Student.Sex.MALE),
			new Student("�����", 6, Student.Sex.FEMALE),
			new Student("����", 10, Student.Sex.MALE),
			new Student("�����", 6, Student.Sex.FEMALE)
		);
		
		//���л��鸸 ���� List ����
		List<Student> maleList = totalList.stream()
			.filter(s -> s.getSex() == Student.Sex.MALE)
			.collect(Collectors.toList());
		maleList.stream()
			.forEach(n -> System.out.println(n.getName()));
		
		//���л��鸸 ���� List ����
		Set<Student> femaleSet= totalList.stream()
			.filter(s -> s.getSex() == Student.Sex.FEMALE)
			.collect(Collectors.toCollection(HashSet::new));
		femaleSet.stream()
			.forEach(n->System.out.println(n.getName()));
	}
}
