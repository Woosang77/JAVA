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
	
	//management���� 1�� ������ ���̵� ������ ����
	public void gameStarting(Identify identify) {
		boolean flag = true;
		userIdentify = identify;
		boolean playable = false;
		do {
			int account = userIdentify.getMoney();
			System.out.println("===============");
			System.out.println(userIdentify.getName() + "�� ȯ���մϴ�.");
			System.out.println("===============");
			System.out.println(
					"1. ������" + 
					"\n2. �����" + 
					"\n3. ������"
					);
			System.out.print("��ȣ�� �����ּ��� : ");
			int num = sc.nextInt(	);
			sc.nextLine();
			if (num == 3) {
				if(playable) {
					System.out.println("������ ������ �ݾ��� ��ȯ�մϴ�.");
					userIdentify.setMoney(userIdentify.getMoney() + money);
				}
				System.out.println("���� ȭ������ �̵��մϴ�.");
				break;
			}
			switch (num) {
			case 1:
				//������
				System.out.println("�����忡 ���Ű� ȯ���մϴ�.");
				System.out.println("���� �ܰ� : " + account + "��");
				if (account < 100) {
					System.out.println("���� ��� �ּҹ��ñݾ׺��� �����Ƿ� �����Ͻ� �� �����ϴ�.");
					break;
				}
				System.out.print("������ �Ͻðڽ��ϱ�? ( Y / N ) : ");
				String yn = sc.nextLine();
				try {
					flag = method.checkYesNo(yn);
				} catch (Exception e) {
					System.out.println("Y(y) �Ǵ� N(n)�� �Է����ּ���.");
				}
				if (!flag) {
					System.out.println("����ȭ������ �̵��մϴ�.");
					break;
				}
				money = betting(userIdentify);
				userIdentify.setMoney(account - money);
				playable = true;
				break;
			
			case 2:
				//�����	
				if (playable) {
					System.out.println("���� ���þ� : " + money + "��");
					System.out.print("��� ������ �����Ͻðڽ��ϱ�?(1~10) : ");
					expectWin = sc.nextInt();
					sc.nextLine();
					if (expectWin < 1 || expectWin > 10) {
						System.out.println("1~10�� ������ ���� �������ֽʽÿ�");
						continue;
					}
					System.out.print("��⸦ �����Ͻðڽ��ϱ�? ( Y / N ) : ");
					String answer = sc.nextLine();
					try {
						flag = method.checkYesNo(answer);
					} catch (Exception e) {
						System.out.println("Y(y) �Ǵ� N(n)�� �Է����ּ���.");
					}
					if (!flag) {
						System.out.println("����ȭ������ �̵��մϴ�.");
						break;
					}
					racing();
					money = (int)playing(expectWin, money);
					Horse.cleanMemory();
					userIdentify.setMoney(userIdentify.getMoney() + money);
					System.out.println();
					System.out.println("���� �� �ܾ� : " + userIdentify.getMoney());
					playable = false;
				}else {
					System.out.println("������ ���� ������ ���ӿ� �����Ͻ� �� �����ϴ�.");
				}
				break;
			}
		} while (true);
	}
	
	//���ñݾ� ����
	int betting(Identify identify) {
		do {
			userIdentify = identify;
			System.out.println("�ּ� ���ñݾ��� 100���̸� 20�������� �ö󰩴ϴ�.");
			System.out.print("���� �ܰ� : " + userIdentify.getMoney() + "��"
					+ "\n���þ� : ");
			money = sc.nextInt();
			sc.nextLine();
			if (money < 100) {
				System.out.println("�ּ� ���ñݾ��� 100���Դϴ�.");
				continue;
			}
			if (money % 20 != 0) {
				System.out.println("20�������� �������ֽʽÿ�.");
				continue;
			}
			System.out.println("���� �Ϸ�Ǿ����ϴ�.");
			return money;
		} while (true);
	}
	
	//��� ����
	void racing() {
		//������ Ǯ�� ���� ��Ƽ������
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);
		
		for (int i = 1; i <= 10; i++) {
			completionService.submit(new Callable<Integer>() {
				Horse horse = new Horse(Horse.Num++);
				
				@Override
				public Integer call() throws Exception {
					while (true) {
						horse.meter -= (int)(Math.random() * 5) + 1;
						if (horse.meter <= 0) {
							break;
						}
						System.out.println(horse.number + "�� �� ���� �Ÿ� : " + horse.meter);
						int sleepSec = (int)(Math.random() * 3) + 1;
						try {
							Thread.sleep(sleepSec * 1000);
						} catch (InterruptedException e) {				
						}
					}
					System.out.println("       " + horse.number + "�� �� ��¼� ���");
					return horse.number;
				}
			});
		}
		
		Future<int[]> future = executorService.submit(new Callable<int[]>() {
			@Override
			public int[] call() throws Exception {
				int count = 0;
				int[] rankArr = new int[10];
				while (true) {
					try {
						Future<Integer> future =  completionService.take();
						int value = future.get();
						if (value != 0) {
							rankArr[count] = value;
							count += 1;
						}
						if (count == 10) {
							System.out.println("=====��� ���=====");
							for (int rank : rankArr) {
								System.out.println("\t" + (rank + 1) + "�� : " + rankArr[rank] + "�� ��");
							}
							break;
						}
					} catch (Exception e) {}
				}
				return rankArr;
			}
		});

		try {
			int[]	result = future.get();
			Horse.rankArray = result;
		} catch (Exception e) {
		}
		executorService.shutdown();
	}
	
	//�� �ְ� �� ����
	double playing(int horseNum, int money) {
		
		int[] arr = Horse.rankArray;
		double betMoney = money;
		int betHorseRank = 1;
		
		for (int i : arr) {
			if (horseNum == arr[i]) {break;}
			else {betHorseRank++;}
		}
		switch (betHorseRank) {
		case 1:
			betMoney *= 8;
			break;
			
		case 2:
			betMoney  *= 5;
			break;
			
		case 3:
			betMoney *= 3;
			break;
		
		case 4:
			betMoney *= 1.5;
			break;
			
		case 5:
			betMoney *= 1;
			break;
			
		case 6:
			betMoney *= 0.85;
			break;
			
		case 7:
			betMoney *= 0.6;
			break;
			
		case 8:
			betMoney *= 0.45;
			break;
			
		case 9:
			betMoney *= 0.3;
			break;
			
		case 10:
			betMoney *= 0;
			break;
		}
		return betMoney;
	}
}
