package Practice.Lesson.ThreadPart.ThreadPool.callback;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackExample {
	
	//클래스에서 작동할 수 있는 스레드풀 변수 생성
	private ExecutorService executorService;
	
	//생성자를 통해 스레드풀 객체 생성
	public CallbackExample (){
		executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
		);
	}
	
	//Callback 방식을 이용
	private CompletionHandler<Integer, Void> callback = 
		new CompletionHandler<Integer, Void>() {
			
			@Override
			public void completed(Integer result, Void attachment) {
				System.out.println("completed() 실행" + result);
			}
			
			@Override
			public void failed(Throwable exc, Void attachment) {
				System.out.println("failed() 실행" + exc);
			}
	};
	
	//실제 구동부분
	public void doWork(String x , String y) {
		//CallbackExample 객체의 메소드로, 객체를 main Thread에서 생성할 때, 스레드풀이 생성되고
		//doWork메소드를 통해 파라미터 두개를 준다.
		//객체에 CompletionHandler가 생성되어있어서 callback사용이 가능하다.
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
		//blocking방식에서는 Future.get()을 이용하여 리턴값을 main에서 실행 했지만,
		//Runnable Task에서 Callback.completed() / Callback.failed()가 실행되면
		//main으로 가져오는게 아니라 CompletionHandler에서 직접 실행한다.
	}
	
	public void finish() {
		executorService.shutdown();
	}
	
	public static void main(String[] args) {
		CallbackExample callbackExample = new CallbackExample();
		callbackExample.doWork("3",	"4");
		callbackExample.doWork("3",	"사");
		callbackExample.finish();
	}
}
