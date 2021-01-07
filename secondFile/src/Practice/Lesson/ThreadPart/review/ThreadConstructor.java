package Practice.Lesson.ThreadPart.review;

import java.util.concurrent.Callable;

public class ThreadConstructor implements Callable<String>{
	
	String name;
	int age;
	
	public ThreadConstructor(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String call() throws Exception {
		
		
		return null;
	}

}