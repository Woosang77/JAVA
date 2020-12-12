package Practice.Lesson.ThreadPart.ThreadPool.blocking;

import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UseCompletion {
	
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors());
		CompletionService<Integer> completionService = new 
				ExecutorCompletionService<>(executorService);
		
		//completionService�� ���� �� ������ 10�� ����
		for (int i = 1; i <= 10; i++) {
			completionService.submit(new Callable<Integer>() {
				Horse horse = new Horse(Horse.Num++);
				
				@Override
				public Integer call() throws Exception {
					while (true) {
						int distance = (int)(Math.random() * 5) + 1;
						horse.meter -= distance;
						if (horse.meter <= 0) {
							break;
						}
						System.out.println(horse.horsenum + "�� �� ���� �Ÿ� : " + horse.meter);
						int second = (int)(Math.random() * 3) + 1;
						try {
							Thread.sleep(second * 1000);
						} catch (InterruptedException e) {				
						}
					}
					System.out.println("       " + horse.horsenum + "�� �� ��¼� ���");
					return horse.horsenum;
				}
			});
		}
		//BlockingQueue�� ������� ������ take�� ���� ������ Array�� ���� ��ȹ��
		executorService.submit(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						Future<Integer> future = completionService.take();
						
						int value = future.get();
						Horse.putRank(value);
						
					} catch (Exception e) {
						break;
					}
				}
			}
		});
		//���� �����带 ���߰�, ��� ������ ��ٷ����Ѵ�.
	
		//executorService���� take()�� ���������� ���� �˾ƾ� �Ѵ�.
	}
}


class Horse {
	public int horsenum;
	public static int Num = 1;
	public static int Rank = 0;
	int meter = 100;
	public static int[] rankArray = new int[10]; 
	
	public Horse(int horsenum) {
		this.horsenum = horsenum;
	}
	synchronized public static void putRank(int horsenum) {
		rankArray[Rank++] = horsenum;
	}
	
}


