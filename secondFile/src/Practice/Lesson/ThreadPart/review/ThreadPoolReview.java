package Practice.Lesson.ThreadPart.review;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class object implements Callable<String> {
	
	String engName;
	int count;
	
	public object(String engName, int count) {
		this.engName = engName;
		this.count = count;
	}
	
	@Override
	public String call() throws Exception {
		
		for (int i = 0; i <= 100; i++) {
			count += i;
		}
		String result = engName + count;
		System.out.println(engName + " " +  Thread.currentThread().getName());
		return result;
	}
}

public class ThreadPoolReview {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		object object1 = new object("Woosang", 60);
		object object2 = new object("obok", 50);
		object object3 = new object("jason", 80);
		object object4 = new object("Aiden", 100);
		object object5 = new object("Michael", 70);
		
		// 1) ������ ������� completionService
		CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
		
		completionService.submit(object1);
		completionService.submit(object2);
		completionService.submit(object3);
		completionService.submit(object4);
		completionService.submit(object5);
		
		
		
		try {
			for (int i = 0; i < 5; i++) {
				Future<String> future = completionService.take();		//������ ��������� take()�� �ݺ��� �ʿ��ϴ�. while�� �Բ� ����Ѵ�.
				String result = future.get();
				System.out.println(result);
				Thread.sleep(1000);				
			}
		} catch (Exception e) {
			
		}
		
		
		// 2) ������ ������ ������ϴ� executorService
		Future<String> future1 = executorService.submit(object1);
		Future<String> future2 = executorService.submit(object2);
		Future<String> future3 = executorService.submit(object3);
		Future<String> future4 = executorService.submit(object4);
		Future<String> future5 = executorService.submit(object5);
		
		try {
			System.out.println(future1.get());
			System.out.println(future5.get());
			System.out.println(future3.get());
			System.out.println(future2.get());
			System.out.println(future4.get());		//executorService�� get()�� ȣ���� ������� ������ ����� �ȴ�. (1-5-3-2-4)�����̴�.
																	//�ٸ� �����尡 ���� �Ϸ�Ǵ��� ������ ������ �����尡 ������ ������ blocking���Ѵ�.
		} catch (Exception e) {}


		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("Thread End");
		executorService.shutdown();
		
	}

}
