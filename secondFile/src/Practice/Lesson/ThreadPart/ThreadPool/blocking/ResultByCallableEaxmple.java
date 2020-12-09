package Practice.Lesson.ThreadPart.ThreadPool.blocking;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByCallableEaxmple {
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		System.out.println("(작업처리 요청)");
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
		
		Future<Integer> future = executorService.submit(task);		//Future리턴
		
		try {			
			int result = future.get();
			System.out.println("처리결과 : " + result);
			System.out.println("작업처리 완료");
		} catch (Exception e) {
			System.out.println("예외발생" + e.getMessage());
		}
		
		executorService.shutdown();
	}
}
