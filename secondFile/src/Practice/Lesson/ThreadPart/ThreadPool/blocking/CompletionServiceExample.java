package Practice.Lesson.ThreadPart.ThreadPool.blocking;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceExample {

	public static void main(String[] args) {
		//ThreadPoolExecutor 생성
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	
		//위의 ThreadPoolExecutor(스레드풀 생성자)를 이용하는 ExecutorCompletionService 생성
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);
		
		System.out.println("[작업 처리 요청]");
		
		//Task는 completionService의 submit()을 통해 Queueing Future로 전환된다.
		for (int i = 1; i <=  3; i++) {
			completionService.submit(new Callable<Integer>() {
				//submit()의 실행과 동시에 Future
				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for (int j = 1; j <= 10; j++) {
						sum += j;
					}
					return sum;
				}
			});
		}
		System.out.println("[처리 완료된 작업 확인!]");
		// 1번
		
//		try {			
//			Future<Integer> future = completionService.take();
//			int value = future.get();
//			System.out.println("[처리결과]" + value);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		/*
		 * 1번의 실행은 take()가 한 번만 실행되기 때문에 Callable Task중 하나만 가져온다.
		 * while문은 모든 어플리케이션이 종료될 때까지 반복 실행해야 하므로 스레드풀의 스레드에서 실행하는 것이 좋다.
		 */
		
		//2번
		executorService.submit(new Runnable() {
		//new Runnable()이라는 Task를 ThreadPool을 이용해서 작업을 한다는 뜻
		//기존에 만들었던 ThreadPool을 이용하여 하나의 Task를 만들고, while(True)를 사용함으로써 
		//하나의 Task에서 completionService.take();를 계속할 수 있게 함
			@Override
			public void run() {
				while (true) {
					try {
						Future<Integer> future = completionService.take();
						//take();는 Completion Queue에 Future이 있다면 리턴한다. 없다면 나올 때까지 blocking
						int value = future.get();	//future이 <Integer>이기 때문에 결과값을 int로 보낸다.
						//get()은 필요한 경우 blocking을 하다가 결과를 리턴한다. 하지만 take에서 block을 한 다음이라 바로 결과값을 리턴한다.
						System.out.println("[처리 결과]" + value);
					} catch (Exception e) {
						break;
					}					
				}
			}
		});

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		executorService.shutdownNow();
		/*더 이상 완료된 작업을 가져올 필요가 없다면 while문의 take()를 종료시켜야 한다.
		* take()의 blocking은 main method에 영향이 없다.
		*/
	}

}
