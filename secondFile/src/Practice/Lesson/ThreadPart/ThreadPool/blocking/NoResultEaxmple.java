package Practice.Lesson.ThreadPart.ThreadPool.blocking;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultEaxmple {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		System.out.println("(작업처리 요청)");
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				int sum = 0;
				for (int i = 1; i <= 10; i++) {
					sum += i;
				}
				System.out.println("처리결과 : "+ sum);
			}
		};
		
		Future future = executorService.submit(runnable);		//Future리턴
		
		try {			
			future.get();
			System.out.println("작업처리 완료");
		} catch (Exception e) {
			System.out.println("예외발생" + e.getMessage());
		}
		
		executorService.shutdown();
	}
}
