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
				signing();
				break;
			case 3:
				//마이페이지
				break;
			}
		} while (true);
	}
	
	//게임 사용자 등록(이름, 성별, 나이 // 이상 없으면 비밀번호 입력받기(마이페이지 이용하기))
	void signing() {
		Identify identify = new Identify();
		String name;
		String sex;
		String age;
		do {
			System.out.print("신규 이용자 가입을 하시겠습니까? ( Y / N )");
			String answer = sc.nextLine();
			if(answer.equals("Y") || answer.equals("y")) {
				//이름
				System.out.print("이름 : ");
				name = sc.nextLine();
				identify.setName(name);
				//성별
				System.out.print("성별( 남 / 여 ) : ");
				sex = sc.nextLine();
				try {
					identify.setSex(sex);
				} catch (SexUnclearException e) {
					System.out.println(e.getMessage()
							 + "\n처음으로 돌아갑니다.");
					continue;
				}
				//생년월일 
				System.out.print("생년월일을 입력해주세요."
						+ "\nEx) 1999-06-12"
						+ "\n입력 : ");
				age = sc.nextLine();
				try {
					identify.setAge(age);					
				} catch (IllegalAgeException e) {
					System.out.println(e.getMessage() +
							"\n처음으로 돌아갑니다.");
					continue;
				}
				System.out.println("이름 : " + identify.getName()
						+ "\n성별 : " + identify.getSex()
						+ "\n생년월일 : " + identify.getAge());
			}else if(answer.equals("N") || answer.equals("n")) {
				System.out.println("메인 메뉴로 이동합니다.");
				break;
			}else {
				System.out.println("잘못 누르셨습니다. 다시 눌러주세요.");
			}
		} while (true);
	}
}
