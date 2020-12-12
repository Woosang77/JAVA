package Practice.Lesson.ThreadPart.ThreadPool.blocking;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UseCompletion2 {
	
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors());
		CompletionService<Integer> completionService = new 
				ExecutorCompletionService<>(executorService);
		
		//completionService�� ���� �� ������ 10�� ����
		for (int i = 1; i <= 10; i++) {
			completionService.submit(new Callable<Integer>() {
				Horses horse = new Horses(Horses.Num++);
				
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
		
		Future<int[]> future = executorService.submit(new Callable<int[]>() {
			@Override
			public int[] call() throws Exception {
				int count = 0;
				int[] arr = new int[10];
				while (true) {
					try {
						Future<Integer> future =  completionService.take();
						int value = future.get();
						if (value != 0) {
							arr[count] = value;
							count += 1;
						}
						if (count == 10) {
							System.out.println("if������ ����");
							System.out.println(Arrays.toString(arr));
							break;
						}
					} catch (Exception e) {}
				}
				return arr;
			}
		});
		
		//���� �����带 ���߰�, ��� ������ ��ٷ����Ѵ�.
		try {
			int[]	result = future.get();
			Horses.rankArray = result;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}


class Horses {
	public int horsenum;
	public static int Num = 1;
	public static int Rank = 0;
	int meter = 100;
	public static int[] rankArray;
	
	public Horses(int horsenum) {
		this.horsenum = horsenum;
	}
	synchronized public static void putRank(int horsenum) {
		rankArray[Rank++] = horsenum;
	}
	
}

class Yaya implements Callable<Yaya> {
	
	Horses horse2 = new Horses(Horses.Num);
	
	@Override
	public Yaya call() throws Exception {
			while (true) {
				int distance = (int)(Math.random() * 5) + 1;
				horse2.meter -= distance;
				if (horse2.meter <= 0) {
					break;
				}
				System.out.println(horse2.horsenum + "�� �� ���� �Ÿ� : " + horse2.meter);
				int second = (int)(Math.random() * 3) + 1;
				try {
					Thread.sleep(second * 1000);
				} catch (InterruptedException e) {				
				}
			}
		return null;
	}
}


