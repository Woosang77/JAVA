package HorseRacingGame;

public class Horse{
	
	public int number;
	public static int[] rankArray;
	public int ranking;
	public  static int Num = 1;
	private static int Rank = 0;
	public int meter = 100;
	
	public Horse(int number) {
		this.number = number;
	}

	public static void cleanMemory() {
		Num = 1;
		Rank = 0;
	}
	
}
