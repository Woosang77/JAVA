package Practice.Lesson.ThreadPart.ThreadPool.blocking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByRunnableExample {
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		System.out.println("[�۾�ó����û]");
		
		//ThreadPool�� �Ѿ �۾�(Task)
		class Task implements Runnable	{
			
			Result result;
			Task(Result result) {
				this.result = result;
			}
			@Override
			public void run() {
				
				int sum = 0;
				for (int i = 1; i <=  10; i++) {
					sum += i;
				}
				System.out.println(Thread.currentThread().getName() + " " + sum);
				result.addValue(sum);
			}
		}
		
		//������ü(�ܺ� ��ü)
		Result result = new Result();
		//�ΰ��� �۾��� ����
		Runnable task1 = new Task(result);
		Runnable task2 = new Task(result);
		
		Future<Result> future1 = executorService.submit(task1, result);
		Future<Result> future2 = executorService.submit(task2, result);
		
		try {
			result = future1.get();
			result = future2.get();
			System.out.println("[ó�� ���]" + result.accumValue);
			System.out.println("�۾� ����");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		executorService.shutdown();
		
		/*
		 * [�۾�ó����û]
			pool-1-thread-1 55
			pool-1-thread-2 55
			[ó�� ���]110		�� �����尡 �ϳ��� ��üresult�� �����ϱ� ������ �� �������� ��갪�� ���δ�.
			�۾� ����
		 */
	}
}

class Result {
	int accumValue;
	
	synchronized void addValue(int value) {
		accumValue += value;
	}
}