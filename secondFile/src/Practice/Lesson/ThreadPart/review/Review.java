package Practice.Lesson.ThreadPart.review;

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
				String[] str = {"��", "��", "��", "��", "��"};
				System.out.println(Thread.currentThread().getName());
				for (String string : str) {
					System.out.println(string);
				}
			}
		};
		
		executorService.execute(task2);
		//Runnable ������ü�� �ٷ� �����ϴ� voidŸ���̱� ������ Future��ü�� Ÿ���� ���� �ʴ´�.
		Future future2 = executorService.submit(task2);
		//���� ���� Runnable ������ü������ future�� �޴� ������ �����尡 �۾�ó���� ���������� �Ϸ��ߴ��� �ƴϸ� ���ܰ� �߻��ߴ��� Ȯ���� ���ؼ��̴�.
		
		Future<Integer> future = executorService.submit(task);
		//Callable ������ü�� return���� �����Ƿ� Future��ü�� �켱 �ް� get�� ���� ���׸��� �Է��ص� Ÿ������ ��ȯ�Ѵ�.
		
		try {			
			int num = future.get();
			System.out.println(num);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("main��");
		executorService.shutdown();
	}

}
