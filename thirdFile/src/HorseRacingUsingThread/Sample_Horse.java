package HorseRacingUsingThread;

public class Sample_Horse extends Thread{
	
	int meter = 100;
	String h_name;
	static int count = 1;
	Sample_Rank rank;
	int distance;
	
	public Sample_Horse(String h_name, Sample_Rank rank) {
		this.h_name = h_name;
		this.rank = rank;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep((int)(Math.random() * 2) * 1000);				
			} catch (InterruptedException e) {
				e.getStackTrace();
			}
			if(meter >0) {
				distance = (int)(Math.random() * 10 + 1);
				meter -= distance;
				System.out.println(h_name + " 남은 거리 : " + meter);
			}
		}
		
	}

}