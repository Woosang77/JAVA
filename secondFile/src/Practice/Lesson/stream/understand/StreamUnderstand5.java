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
		//스트림을 위한 컬렉션 생성
		Set<Menu> orderMenu = new HashSet<Menu>() {{
			add(new Menu(Country.KOREAN, Kinds.MEET, "삼겹살"));
			add(new Menu(Country.JAPENESE, Kinds.NOODLE, "우동"));
			add(new Menu(Country.CHINESE, Kinds.RICE, "볶음밥"));
			add(new Menu(Country.JAPENESE, Kinds.MEET, "돈까스"));
			add(new Menu(Country.CHINESE, Kinds.NOODLE, "짜장면"));
			add(new Menu(Country.KOREAN, Kinds.RICE, "비빔밥"));
		}};
		
		//오리지널 스트림 생성
		Stream<Menu> menuStream = orderMenu.stream();
		
		//중간처리 스트림(필터링)
		Stream<Menu> filteredStream = menuStream.filter(
			m -> m.getCoutry() != Country.KOREAN
		);
		//중간처리 스트림(정렬)
		Stream<Menu> sortedStream = filteredStream.sorted();
		
		//최종처리 (기본집계)
//		System.out.println(sortedStream.count());
		
//		Optional<Menu> firstMenu = sortedStream.findFirst();
//		System.out.println(firstMenu.get().getName().toString());
		
		//최종처리 커스텀 집계(reduce)	기본 집계(sum, average, count, min, max)이외에 다양한 기능들이 필요하다면, reduce
		
		//최종처리 collect(수집) 요소의 값을 얻는 것이 아닌 추려진 요소를 그룹핑한다.
		//
		Function<Menu, Menu.Kinds>classifier = Menu :: getKinds;
		
		Function<Menu, String> mapper = Menu :: getName;
		Collector<String, ?, List<String>> downstream = Collectors.toList();
		Collector<Menu, ?, List<String>> collector = Collectors.mapping(mapper, downstream);
		
		Collector<Menu, ?, Map<Menu.Kinds, List<String>>> finalCollector = Collectors.groupingBy(classifier, collector);
		
		Map<Menu.Kinds, List<String>> finalList = sortedStream.collect(finalCollector);
		
		
		
		
		


		
		
	}

}
