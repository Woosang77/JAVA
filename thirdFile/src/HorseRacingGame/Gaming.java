package HorseRacingGame;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


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
				if(playable) {
					System.out.println("기존에 배팅한 금액을 반환합니다.");
					userIdentify.setMoney(userIdentify.getMoney() + money);
				}
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
				System.out.print("배팅을 하시겠습니까? ( Y / N ) : ");
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
					System.out.println();
					System.out.println("배팅 후 잔액 : " + userIdentify.getMoney());
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
			System.out.println("배팅 완료되었습니다.");
			return money;
		} while (true);
	}
	
	//경기 시작
	void racing() {
		
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors());
		CompletionService<Integer> completionService = new 
				ExecutorCompletionService<>(executorService);
		
		for (int i = 1; i <= 10; i++) {
			completionService.submit(new Callable<Integer>() {
				Horse horse = new Horse(Horse.Num++);
				
				@Override
				public Integer call() throws Exception {
					while (true) {
						int distance = (int)(Math.random() * 5) + 1;
						horse.meter -= distance;
						if (horse.meter <= 0) {
							break;
						}
						System.out.println(horse.number + "번 말 남은 거리 : " + horse.meter);
						int second = (int)(Math.random() * 3) + 1;
						try {
							Thread.sleep(second * 1000);
						} catch (InterruptedException e) {				
						}
					}
					System.out.println("       " + horse.number + "번 말 결승선 통과");
					return horse.number;
				}
			});
		}
		
		Future<int[]> future = executorService.submit(new Callable<int[]>() {
			@Override
			public int[] call() throws Exception {
				int count = 0;
				int[] arr = new int[10];
				while (true) {
					try {
						Future<Integer> future =  completionService.take();
						int value = future.get();
						if (value != 0) {
							arr[count] = value;
							count += 1;
						}
						if (count == 10) {
							System.out.println("=====경기 결과=====");
							for (int i = 0; i < 10; i++) {
								System.out.println("       " + (i + 1) + "등 : " + arr[i] + "번 말");
							}
							break;
						}
					} catch (Exception e) {}
				}
				return arr;
			}
		});

		try {
			int[]	result = future.get();
			Horse.rankArray = result;
		} catch (Exception e) {
		}
		executorService.shutdown();
	}
	
	//돈 넣고 돈 따기
	double playing(int horseNum, int money) {
		
		int[] arr = Horse.rankArray;
		double betMoney = money;
		int myHorseRank = 1;
		
		for (int i = 0; i < arr.length; i++) {
			if (horseNum == arr[i]) {
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
