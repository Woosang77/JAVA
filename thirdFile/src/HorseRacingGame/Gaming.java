package HorseRacingGame;

import java.util.Scanner;

public class Gaming {
	Scanner sc = new Scanner(System.in);
	private Identify userIdentify;
	private int money;
	private int expectWin;
	Management method = new Management();
	
	//management에서 1번 누르고 아이디 가지고 들어옴
	public void gameStarting(Identify identify) {
		boolean flag = true;
		userIdentify = identify;
		boolean playable = false;
		do {
			int account = userIdentify.getMoney();
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
				System.out.println("현재 잔고 : " + account + "원");
				if (account < 100) {
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
				userIdentify.setMoney(account - money);
				playable = true;
				break;
			
			case 2:
				//경기장	
				if (playable) {
					System.out.println("현재 배팅액 : " + money + "원");
					System.out.print("몇번 말에게 배팅하시겠습니까?(1~10) : ");
					expectWin = sc.nextInt();
					sc.nextLine();
					if (expectWin < 1 || expectWin > 10) {
						System.out.println("1~10번 사이의 말을 선택해주십시오");
						continue;
					}
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
					money = (int)playing(expectWin, money);
					Horse.cleanMemory();
					userIdentify.setMoney(userIdentify.getMoney() + money);
					System.out.println(userIdentify.getMoney());
					playable = false;
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
	
	//말 달리기
	void racing() {
		
		Thread horseThread1 = new Horse("1");
		Thread horseThread2 = new Horse("2");
		Thread horseThread3 = new Horse("3");
		Thread horseThread4 = new Horse("4");
		Thread horseThread5 = new Horse("5");
		Thread horseThread6 = new Horse("6");
		Thread horseThread7 = new Horse("7");
		Thread horseThread8 = new Horse("8");
		Thread horseThread9 = new Horse("9");
		Thread horseThread10 = new Horse("10");
		
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
		} catch (InterruptedException e) {}
		System.out.println("=====경기결과=====");
		Horse.getRankArray();
	}
	
	//돈 넣고 돈 따기
	double playing(int horseNum, int money) {
		
		String num = "" + horseNum;
		String[] arr = Horse.rankArray;
		double betMoney = money;
		int myHorseRank = 1;
		
		for (int i = 0; i < arr.length; i++) {
			if (num.equals(arr[i])) {
				break;
			}else {
				myHorseRank++;
			}
		}
		switch (myHorseRank) {
		case 1:
			betMoney = betMoney * 8;
			break;
			
		case 2:
			betMoney = betMoney * 5;
			break;
			
		case 3:
			betMoney = betMoney * 3;
			break;
		
		case 4:
			betMoney = betMoney * 1.5;
			break;
			
		case 5:
			betMoney = betMoney * 1;
			break;
			
		case 6:
			betMoney = betMoney * 0.85;
			break;
			
		case 7:
			betMoney = betMoney * 0.6;
			break;
			
		case 8:
			betMoney = betMoney * 0.45;
			break;
			
		case 9:
			betMoney = betMoney * 0.3;
			break;
			
		case 10:
			betMoney = betMoney * 0;
			break;
		}
		
		return betMoney;
	}
}
