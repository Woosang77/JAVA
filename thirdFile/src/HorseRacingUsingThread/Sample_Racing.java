package HorseRacingUsingThread;

public class Sample_Racing {

	public static void main(String[] args) {
		Sample_Horse horse1 = new Sample_Horse("������", new Sample_Rank());
		Sample_Horse horse2 = new Sample_Horse("���丶", new Sample_Rank());
		Sample_Horse horse3 = new Sample_Horse("�渶", new Sample_Rank());
		Sample_Horse horse4 = new Sample_Horse("��", new Sample_Rank());
		Sample_Horse horse5 = new Sample_Horse("����", new Sample_Rank());
		
		horse1.start();
		horse2.start();
		horse3.start();
		horse4.start();
		horse5.start();
		
	}
	
}
