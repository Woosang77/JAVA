package HorseRacingUsingThread;

import javax.swing.JOptionPane;

public class Sample_Rank {
	int rank;
	
	public void finishline(String h_name) {
		rank = Sample_Horse.count++;
		System.out.println(h_name + "��" + rank + "������ ��¼� ���");
		if(rank ==1 ) {
			JOptionPane.showMessageDialog(null, "1�� ����" + h_name + "�Դϴ�!!");
		}
	}
}
