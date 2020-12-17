package Practice.Lesson.collection_framework.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExmaple {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("java");
		set.add("jdbc");
		set.add("servlet/jsp");
		set.add("java");
		set.add("ibatis");
		
		int size = set.size();
		System.out.println(size);			//4
		
		Iterator<String>iterator = set.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			System.out.println("\t" + str);
		}
		
		set.remove("jdbc");
		set.remove("ibatis");
		
		System.out.println(set.size());
		
		set.clear();
		if (set.isEmpty()) {
			System.out.println("비어있음");
		}
	}

}
