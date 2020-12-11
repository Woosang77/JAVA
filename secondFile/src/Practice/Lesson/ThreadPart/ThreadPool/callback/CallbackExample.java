package Practice.Lesson.ThreadPart.ThreadPool.callback;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackExample {
	
	//Ŭ�������� �۵��� �� �ִ� ������Ǯ ���� ����
	private ExecutorService executorService;
	
	//�����ڸ� ���� ������Ǯ ��ü ����
	public CallbackExample (){
		executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
		);
	}
	
	//Callback ����� �̿�
	private CompletionHandler<Integer, Void> callback = 
		new CompletionHandler<Integer, Void>() {
			
			@Override
			public void completed(Integer result, Void attachment) {
				System.out.println("completed() ����" + result);
			}
			
			@Override
			public void failed(Throwable exc, Void attachment) {
				System.out.println("failed() ����" + exc);
			}
	};
	
	//���� �����κ�
	public void doWork(String x , String y) {
		//CallbackExample ��ü�� �޼ҵ��, ��ü�� main Thread���� ������ ��, ������Ǯ�� �����ǰ�
		//doWork�޼ҵ带 ���� �Ķ���� �ΰ��� �ش�.
		//��ü�� CompletionHandler�� �����Ǿ��־ callback����� �����ϴ�.
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					int intx = Integer.parseInt(x);
					int inty = Integer.parseInt(y);
					int result = intx + inty;
					callback.completed(result, null);					
				} catch (NumberFormatException e) {
					callback.failed(e, null);
				}
			}
		};
		
		executorService.submit(task);
		//blocking��Ŀ����� Future.get()�� �̿��Ͽ� ���ϰ��� main���� ���� ������,
		//Runnable Task���� Callback.completed() / Callback.failed()�� ����Ǹ�
		//main���� �������°� �ƴ϶� CompletionHandler���� ���� �����Ѵ�.
	}
	
	public void finish() {
		executorService.shutdown();
	}
	
	public static void main(String[] args) {
		CallbackExample callbackExample = new CallbackExample();
		callbackExample.doWork("3",	"4");
		callbackExample.doWork("3",	"��");
		callbackExample.finish();
	}
}
