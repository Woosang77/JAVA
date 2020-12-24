package Practice.Lesson.stream.understand;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//��� 
class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}

public class StreamUnderstand {
	
	/*
	 * Stream�� Collection �ڷ� �������� ������ ó�� ������ �����ϵ��� ����� ���ӵ� ����̴�.
	 * ū �ܰ�� �� ������ �ִ�.
	 * 1) �ڷᱸ���κ��� ��Ʈ�� ����
	 * 2) �߰� ����
	 * 3) ���� ����
	 */
	public static void main(String[] args) {
		//����Ʈ �ڷᱸ�� ����
		List<Person> list = Arrays.asList(
				new Person("����", 22),
				new Person("����", 19),
				new Person("�ֿ��", 9)
		);
		//1) �ڷᱸ���κ��� ��Ʈ�� ���� (�������� ��Ʈ��)
		Stream<Person> mainStream = list.stream();
		
		/*
		 * 2) �߰� ���� - filter, map, sort, loop���� �ְ� ���� ����Ǿ� ������������ "����"�Ѵ�.
		 * �߰� ���󿡼��� ������ �� ��������� �ʴ´�(lazy).
		 */
		Stream<Person> filterStream = mainStream.filter(p -> (p.getAge() - 10) > 1);
		Stream<String> mapStream = filterStream.map(Person :: getName);
		
		/*
		 * 3) ���� ���� : ������ ��Ʈ�� ������������ ����, ������� �� �ݴ´�. ���� ���꿡�� ũ�� �ΰ��� �η��� �ִ�.
		 * 
		 * ù ��°, ����(reduce) : ����� �⺻ Ÿ��(int, long, double ��) �Ǵ� Optional class�� �����Ѵ�.
		 * 		Optional<T> : ���� ����, ���� ���θ� ǥ���ϴ� �����̳� Ŭ���� - ���� �ִٸ� ���, �߰� ������ ���� ���� �������� �� �����߻��� ���ϱ� ���� ����Ʈ�� ����
		 * 			.method : isPresent()(�� ���翩�� �Ҹ�����) / orElse(...) (���ٸ� ...����) / ifPresent(...)(������...���� , ������ ������)
		 * 
		 * �� ��°, collect : ����� ū ���� ������ ����� ����ϰ� �����Ѵ�. ������ collect�� �߰� ������ �ϰ� �߷��� ��ҵ��� �÷������� ���� �� �ִ�.
		 * 		.collect(Collector collector);
		 * 			Collector�� �⺻������ ���� ��ü�� Collectors�� ���� �޼ҵ带 �̿��� ���ϰ��� CollectorŸ���̱� ������ �׷��� �ִ´�.
		 * 			���� ���, .collect(Collectors.toList())�� ������ CollecterŸ���� ���ϰ��� Collector<T,?,List<T>>�̴�.
		 * 			Collector <T,A,R>���� T�� ����� Ÿ��, A�� ������, R�� ��� ���� �÷��� Ÿ���̴�.
		 * 
		 */
		//ù ��°, ���� (�⺻Ÿ��)
		Long count = mapStream.count();	
		System.out.println(count);		//��� 2
		
		//ù ��° ����(Optional<T>)
		Optional<String> firstName = mapStream.findFirst();
		String name = firstName.get();
		System.out.println(name);
		// ��� : ����
		
		//�� ����, collect
		//collect�� ���̱� ������ Collector Ÿ���� ���� �޾ƾ��Ѵ�. 
		Supplier<HashSet<String>> supplier = HashSet :: new;
		Collector<String, ?, HashSet<String>> nameSet = Collectors.toCollection(supplier);
		//toCollection(Supplier<Collection<T>>)�޼ҵ�� T�� Supplier���� ������ �÷��ǿ� ����
		Set<String> set = mapStream.collect(nameSet);
		set.forEach(s -> System.out.println(s));
		// 	���
		//		����
		//		����


		
		
		
		
	}

}
