package Practice.Lesson.CountTxt;

import java.util.Scanner;

public class CharCounter {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("�޸��忡 �ڼҼ��� �Է��Ͻø� ���ڼ��� �����ݴϴ�.");
		System.out.println("�Է��� ������ �����Ͻð� â�� �ݾ��ּ���.");
		DirectTyping.InputString(args);
		
		System.out.println("���ڼ��� ����帱���? ���� 1�� �����ּ���.");
		int yes = scan.nextInt();
		if (yes == 1) {FileReadChar.countChar(args);}
		else {System.out.println("���� 1�� ������ �ʾƼ� ����˴ϴ�.");}
		scan.close();
	}

}
