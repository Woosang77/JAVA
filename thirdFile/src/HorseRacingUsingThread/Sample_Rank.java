package HorseRacingUsingThread;

import javax.swing.JOptionPane;

public class Sample_Rank {
	int rank;
	
	public void finishline(String h_name) {
		rank = Sample_Horse.count++;
		System.out.println(h_name + "말" + rank + "등으로 결승선 통과");
		if(rank ==1 ) {
			JOptionPane.showMessageDialog(null, "1등 말은" + h_name + "입니다!!");
		}
	}
}
