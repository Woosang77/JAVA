package HorseRacingGame;

import java.util.Scanner;

public class Gaming {
	Scanner sc = new Scanner(System.in);
	private Identify userIdentify;
	private int money;
	Management method = new Management();
	
	//management에서 1번 누르고 아이디 가지고 들어옴
	public void gameStarting(Identify identify) {
		boolean playable = false;
		boolean flag = true;
		userIdentify = identify;
		do {
			System.out.println("===============");
			System.out.println(userIdentify.getName() + "님 환영합니다.");
			System.out.println("===============");
			System.out.println(
					"1. 배팅장" + 
					"\n2. 경기장" + 
					"\n3. 나가기"
					);
			System.out.print("번호를 눌러주세요 : ");
			int num = sc.nextInt(	);
			sc.nextLine();
			if (num == 3) {
				System.out.println("메인 화면으로 이동합니다.");
				break;
			}
			switch (num) {
			case 1:
				//배팅장
				System.out.println("배팅장에 오신걸 환영합니다.");
				System.out.println("현재 잔고 : " + userIdentify.getMoney() + "원");
				if (userIdentify.getMoney() < 100) {
					System.out.println("현재 재고가 최소배팅금액보다 적으므로 참여하실 수 없습니다.");
					break;
				}
				System.out.print("배팅을 하시겠습니까? ( Y / N )");
				String yn = sc.nextLine();
				try {
					flag = method.checkYesNo(yn);
				} catch (Exception e) {
					System.out.println("Y(y) 또는 N(n)을 입력해주세요.");
				}
				if (!flag) {
					System.out.println("이전화면으로 이동합니다.");
					break;
				}
				money = betting(userIdentify);
				playable = true;
				//오류 확인용
				System.out.println("현재 배팅액 : " + money + "원");
				break;
			
			case 2:
				//경기장	
				if (playable) {
					System.out.println("현재 배팅액 : " + money + "원");
					System.out.print("몇번 말에게 배팅하시겠습니까?(1~10) : ");
					int expectWin = sc.nextInt();
					sc.nextLine();
					System.out.print("경기를 시작하시겠습니까? ( Y / N ) : ");
					String answer = sc.nextLine();
					try {
						flag = method.checkYesNo(answer);
					} catch (Exception e) {
						System.out.println("Y(y) 또는 N(n)을 입력해주세요.");
					}
					if (!flag) {
						System.out.println("이전화면으로 이동합니다.");
						break;
					}
					racing();
				}else {
					System.out.println("배팅을 하지 않으면 게임에 참여하실 수 없습니다.");
				}
				break;

			}
		} while (true);
	}
	//배팅금액 기준
	int betting(Identify identify) {
		do {
			userIdentify = identify;
			System.out.println("최소 배팅금액은 100원이며 20원단위로 올라갑니다.");
			System.out.print("현재 잔고 : " + userIdentify.getMoney() + "원"
					+ "\n배팅액 : ");
			money = sc.nextInt();
			sc.nextLine();
			if (money < 100) {
				System.out.println("최소 배팅금액은 100원입니다.");
				continue;
			}
			if (money % 20 != 0) {
				System.out.println("20원단위로 배팅해주십시오.");
				continue;
			}
			return money;
		} while (true);
	}
	
	void racing() {
		
		Thread horseThread1 = new Horse("1번 말");
		Thread horseThread2 = new Horse("2번 말");
		Thread horseThread3 = new Horse("3번 말");
		Thread horseThread4 = new Horse("4번 말");
		Thread horseThread5 = new Horse("5번 말");
		Thread horseThread6 = new Horse("6번 말");
		Thread horseThread7 = new Horse("7번 말");
		Thread horseThread8 = new Horse("8번 말");
		Thread horseThread9 = new Horse("9번 말");
		Thread horseThread10 = new Horse("10번 말");
		
		horseThread1.start();
		horseThread2.start();
		horseThread3.start();
		horseThread4.start();
		horseThread5.start();
		horseThread6.start();
		horseThread7.start();
		horseThread8.start();
		horseThread9.start();
		horseThread10.start();
		
		try {
			horseThread1.join();
			horseThread2.join();
			horseThread3.join();
			horseThread4.join();
			horseThread5.join();
			horseThread6.join();
			horseThread7.join();
			horseThread8.join();
			horseThread9.join();
			horseThread10.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("=====경기결과=====");
		Horse.getRankArray();
	}
}
