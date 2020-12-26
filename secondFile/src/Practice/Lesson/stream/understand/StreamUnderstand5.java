package Practice.Lesson.stream.understand;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Practice.Lesson.stream.understand.Menu.Country;
import Practice.Lesson.stream.understand.Menu.Kinds;

class Menu implements Comparable<Menu>{
	
	public enum Country{KOREAN, CHINESE, JAPENESE}
	public enum Kinds{NOODLE, RICE, MEET}
	
	private String name;
	private Country country;
	private Kinds kinds;
	
	public Menu(Country country, Kinds kinds, String name) {
		this.name = name;
		this.country = country;
		this.kinds = kinds;
	}
	
	public String getName() {
		return name;
	}
	
	public Country getCoutry() {
		return country;
	}
	
	public Kinds getKinds() {
		return kinds;
	}
	
	@Override
	public int compareTo(Menu o) {
		return name.compareTo(o.name);
	}
}

public class StreamUnderstand5 {

	public static void main(String[] args) {
		//��Ʈ���� ���� �÷��� ����
		Set<Menu> orderMenu = new HashSet<Menu>() {{
			add(new Menu(Country.KOREAN, Kinds.MEET, "����"));
			add(new Menu(Country.JAPENESE, Kinds.NOODLE, "�쵿"));
			add(new Menu(Country.CHINESE, Kinds.RICE, "������"));
			add(new Menu(Country.JAPENESE, Kinds.MEET, "���"));
			add(new Menu(Country.CHINESE, Kinds.NOODLE, "¥���"));
			add(new Menu(Country.KOREAN, Kinds.RICE, "�����"));
		}};
		
		//�������� ��Ʈ�� ����
		Stream<Menu> menuStream = orderMenu.stream();
		
		//�߰�ó�� ��Ʈ��(���͸�)
		Stream<Menu> filteredStream = menuStream.filter(
			m -> m.getCoutry() != Country.KOREAN
		);
		//�߰�ó�� ��Ʈ��(����)
		Stream<Menu> sortedStream = filteredStream.sorted();
		
		//����ó�� (�⺻����)
//		System.out.println(sortedStream.count());
		
//		Optional<Menu> firstMenu = sortedStream.findFirst();
//		System.out.println(firstMenu.get().getName().toString());
		
		//����ó�� Ŀ���� ����(reduce)	�⺻ ����(sum, average, count, min, max)�̿ܿ� �پ��� ��ɵ��� �ʿ��ϴٸ�, reduce
		
		//����ó�� collect(����) ����� ���� ��� ���� �ƴ� �߷��� ��Ҹ� �׷����Ѵ�.
		//
		Function<Menu, Menu.Kinds>classifier = Menu :: getKinds;
		
		Function<Menu, String> mapper = Menu :: getName;
		Collector<String, ?, List<String>> downstream = Collectors.toList();
		Collector<Menu, ?, List<String>> collector = Collectors.mapping(mapper, downstream);
		
		Collector<Menu, ?, Map<Menu.Kinds, List<String>>> finalCollector = Collectors.groupingBy(classifier, collector);
		
		Map<Menu.Kinds, List<String>> finalList = sortedStream.collect(finalCollector);
		
		
		
		
		


		
		
	}

}
