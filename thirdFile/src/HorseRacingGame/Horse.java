package HorseRacingGame;

public class Horse extends Thread{
	
	public static String[] rankArray = new String[10];
	public int ranking;
	private static int Num = 0;
	private static int Rank = 1;
	private int meter = 100;
	
	public Horse(String name) {
		setName(name);
	}
	
	public static void getRankArray() {
		for (int i = 0; i < rankArray.length; i++) {
			System.out.println((i+1) + "�� : " + rankArray[i] + "�� ��");
		}
	}
	
	public void run() {
		while (true) {
			int distance = (int)(Math.random() * 5) + 1;
			meter -= distance;
			if (meter <= 0) {
				break;
			}
			System.out.println(getName() + "�� �� ���� �Ÿ� : " + meter + "M");
			int second = (int)(Math.random() * 3) + 1;
			try {
				Thread.sleep(second * 1000);
			} catch (InterruptedException e) {
			}
		}
		rankArray[Num++] = getName();
		System.out.println("        " + (Rank++) + "�� : " + getName() + "�� ��"); 	
	}

	public static void cleanMemory() {
		Num = 0;
		Rank = 1;
	}
	
}
