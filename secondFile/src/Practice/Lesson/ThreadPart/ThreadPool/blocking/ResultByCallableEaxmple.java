package Practice.Lesson.ThreadPart.ThreadPool.blocking;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByCallableEaxmple {
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		System.out.println("(�۾�ó�� ��û)");
		Callable<Integer> task = new Callable<Integer>() {
			
			@Override	
			public Integer call() {
				int sum = 0;
				for (int i = 1; i <= 10; i++) {
					sum += i;
				}
				return sum;
			}
		};
		
		Future<Integer> future = executorService.submit(task);		//Future����
		
		try {			
			int result = future.get();
			System.out.println("ó����� : " + result);
			System.out.println("�۾�ó�� �Ϸ�");
		} catch (Exception e) {
			System.out.println("���ܹ߻�" + e.getMessage());
		}
		
		executorService.shutdown();
	}
}
