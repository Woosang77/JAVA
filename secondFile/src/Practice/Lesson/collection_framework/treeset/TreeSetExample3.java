package Practice.Lesson.collection_framework.treeset;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample3 {

	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<>();
		//String TreeSet은 알파벳이 먼저 오는 것은 좌측에, 나중에 오는 것은 우측 노드에 배치한다.
		treeSet.add("apple");
		treeSet.add("forever");
		treeSet.add("description");
		treeSet.add("ever");
		treeSet.add("zoo");
		treeSet.add("base");
		treeSet.add("guess");
		treeSet.add("cherry");
		
		//c에서 f사이에 알파벳으로 시작하는 단어를 가져와 출력하기
		System.out.println("[c~f 사이의 단어 검색]");
		//.subSet(fromElement, fromInclusive, toElement, toInclusive);
		/*
		 * fromElement : 시작 값
		 * fromInclusive : 시작 값의 포함 여부
		 * toElement : 끝 값
		 * toInclusive : 끝 값의 포함 여부
		 */
		NavigableSet<String> rangeSet = treeSet.subSet("c", true, "f", true);
		for (String word : rangeSet) {
			System.out.print(word + " ");
		}
		// 결과 : cherry description ever 
		/*
		 * f까지 포함인데 forever이 빠진 이유
		 * f와 비교할 때, f로 시작하는 모든 단어는 f뒤에 다른 알파벳이 붙은 것이기 때문에 
		 * f 알파벳 보다 후 순위로 배치된다.
		 */
	}

}
