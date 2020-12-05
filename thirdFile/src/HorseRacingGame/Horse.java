package HorseRacingGame;

public class Horse extends Thread{
	
	private int number;
	public int ranking;
	private static int Num = 0;
	private static int Rank = 0;
	private int meter = 100;
	
	public Horse() {
		this.number = ++Num;
		run();
	}
	
	public void run() {
		while (true) {
			int distance = (int)(Math.random() * 5) + 1;
			meter -= distance;
			if (meter <= 0) {
				break;
			}
			System.out.println(number + "번 말 남은 거리 : " + meter + "M");
			int second = (int)(Math.random() * 3) + 1;
			try {
				Thread.sleep(second * 1000);
			} catch (InterruptedException e) {
			}
		}
		ranking = ++Rank;
		System.out.println(ranking + "등 : " + number + "번 말");

	}


	
}
