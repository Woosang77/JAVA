package Practice.Lesson.ThreadPart.ThreadPool.blocking;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceExample {

	public static void main(String[] args) {
		//ThreadPoolExecutor ����
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	
		//���� ThreadPoolExecutor(������Ǯ ������)�� �̿��ϴ� ExecutorCompletionService ����
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);
		
		System.out.println("[�۾� ó�� ��û]");
		
		//Task�� completionService�� submit()�� ���� Queueing Future�� ��ȯ�ȴ�.
		for (int i = 1; i <=  3; i++) {
			completionService.submit(new Callable<Integer>() {
				//submit()�� ����� ���ÿ� Future
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
		System.out.println("[ó�� �Ϸ�� �۾� Ȯ��!]");
		// 1��
		
//		try {			
//			Future<Integer> future = completionService.take();
//			int value = future.get();
//			System.out.println("[ó�����]" + value);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		/*
		 * 1���� ������ take()�� �� ���� ����Ǳ� ������ Callable Task�� �ϳ��� �����´�.
		 * while���� ��� ���ø����̼��� ����� ������ �ݺ� �����ؾ� �ϹǷ� ������Ǯ�� �����忡�� �����ϴ� ���� ����.
		 */
		
		//2��
		executorService.submit(new Runnable() {
		//new Runnable()�̶�� Task�� ThreadPool�� �̿��ؼ� �۾��� �Ѵٴ� ��
		//������ ������� ThreadPool�� �̿��Ͽ� �ϳ��� Task�� �����, while(True)�� ��������ν� 
		//�ϳ��� Task���� completionService.take();�� ����� �� �ְ� ��
			@Override
			public void run() {
				while (true) {
					try {
						Future<Integer> future = completionService.take();
						//take();�� Completion Queue�� Future�� �ִٸ� �����Ѵ�. ���ٸ� ���� ������ blocking
						int value = future.get();	//future�� <Integer>�̱� ������ ������� int�� ������.
						//get()�� �ʿ��� ��� blocking�� �ϴٰ� ����� �����Ѵ�. ������ take���� block�� �� �����̶� �ٷ� ������� �����Ѵ�.
						System.out.println("[ó�� ���]" + value);
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
		/*�� �̻� �Ϸ�� �۾��� ������ �ʿ䰡 ���ٸ� while���� take()�� ������Ѿ� �Ѵ�.
		* take()�� blocking�� main method�� ������ ����.
		*/
	}

}
