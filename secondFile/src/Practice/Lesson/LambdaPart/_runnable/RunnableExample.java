package Practice.Lesson.LambdaPart._runnable;

public class RunnableExample {

	public static void main(String[] args) {

//		Runnable runnable = () -> {
//			for (int i = 0; i < 10; i++) {
//				System.out.println(i);
//			}
//		};
//		
//		Thread thread = new Thread(runnable);
//		
//		thread.start();
		
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(i);
				}
			}
		});

	}

}
	  