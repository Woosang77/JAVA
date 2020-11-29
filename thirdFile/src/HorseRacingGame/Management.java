package HorseRacingGame;

import java.util.*;

public class Management {
	
	Scanner sc = new Scanner(System.in);
	
	public void menu() {
		int num = 0;
		System.out.println("=====Welcome=====");
		do {
			System.out.println("=Obok's HorseRacing="
					+"\n"
					+ "\n1. Game start"
					+ "\n2. Sign up"
					+ "\n3. My page"
					+ "\n4. I'm out");	
			System.out.println();
			System.out.print("Press number : ");
			num = sc.nextInt();
			sc.nextLine();
			if(num < 1 || num > 4) {
				System.out.println("Press number again");
			}else if(num == 4) {
				System.out.println("Bye");
				break;
			}
			switch (num) {
			case 1:
				//게임시작
				break;

			case 2:
				//게임 사용자 등록
				break;
				
			case 3:
				//마이페이지
				break;
			}
		} while (true);
	}
}
