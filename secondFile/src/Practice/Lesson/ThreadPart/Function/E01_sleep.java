package Practice.Lesson.ThreadPart.Function;

import java.awt.Toolkit;

public class E01_sleep {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 10	; i++) {
			toolkit.beep();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

//Thread.sleep(1000);   :   main �����带 1000millis ���� �Ͻ����� ���·� �����,
//�ð��� ������ �ٽ� ���� ��� ���·� ������.