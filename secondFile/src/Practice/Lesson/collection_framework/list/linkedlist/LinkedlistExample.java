package Practice.Lesson.collection_framework.list.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedlistExample {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();
		//객체를 저장할 때, 끝에서부터 순차적으로 추가/삭제하는 것은 Arraylist가 더 빠르지만,
		//특정위치를 지정하고 추가할 때는 LinkedList가 더욱 빠르다.
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("Arraylist 걸린 시간 : " + (endTime - startTime) + "ns");
		//Arraylist 걸린 시간 : 10655200ns
		
		
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("Linkedlist 걸린 시간 : " + (endTime - startTime) + "ns");
		//Linkedlist 걸린 시간 : 2375600ns
		
	}

}
