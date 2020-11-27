package Practice.Lesson.ThreadPart.Function.E03_join;

public class SumThread extends Thread{
	private long sum;
	
	public long getSum() {
		return sum;
	}
	
	public void setSum(long sum) {
		this.sum = sum;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 500; i++) {
			sum += i;
		}
	}
}
