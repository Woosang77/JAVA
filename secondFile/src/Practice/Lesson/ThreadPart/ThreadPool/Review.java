package Practice.Lesson.ThreadPart.ThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Review {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		Callable<Integer> task = new Callable<Integer>() {	
			@Override
			public Integer call() throws Exception {
				int count = 0;
				for (int i = 0; i <= 100; i++) {
					count += i;
				}
				System.out.println(Thread.currentThread().getName());
				return count;
			}
		};
		
		Runnable task2 = new Runnable() {
			@Override
			public void run() {
				String[] str = {"일", "이", "삼", "사", "오"};
				System.out.println(Thread.currentThread().getName());
				for (String string : str) {
					System.out.println(string);
				}
			}
		};
		
		executorService.execute(task2);
		//Runnable 구현객체는 바로 실행하는 void타입이기 때문에 Future객체로 타입을 받지 않는다.
		Future future2 = executorService.submit(task2);
		//위와 같이 Runnable 구현객체이지만 future로 받는 이유는 스레드가 작업처리를 정상적으로 완료했는지 아니면 예외가 발생했는지 확인을 위해서이다.
		
		Future<Integer> future = executorService.submit(task);
		//Callable 구현객체는 return값이 있으므로 Future객체로 우선 받고 get을 통해 제네릭에 입력해둔 타입으로 전환한다.
		
		try {			
			int num = future.get();
			System.out.println(num);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("main끝");
		executorService.shutdown();
	}

}
