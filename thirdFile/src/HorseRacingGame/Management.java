package HorseRacingGame;

import java.util.*;

public class Management {
	
	List<Identify> membersIdcheck = new ArrayList<Identify>();
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
		String id;
		int pin;
		boolean flags = true;
		
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
				
				//아이디 설정 (중복있나 확인 할거임)
				do {
					System.out.print("등록할 아이디를 눌러주세요 : ");
					id = sc.nextLine();
					flags = idchecking(id);
				} while (flags);
				identify.setId(id);
				System.out.println("아이디 등록이 완료되었습니다.");
				
				//비밀번호 설정(pin 4자리)
				do {
					System.out.print("사용할 비밀번호 4자리 숫자를 입력해주세요 : ");
					pin = sc.nextInt();
					sc.nextLine();
					if (!((pin / 1000) >= 1)) {
						System.out.println("다시 입력해주세요.");
						continue;
					}else {
						identify.setPin(pin);
						break;
					}
				} while (true);
				//이름 나이 성별 아이디 비밀번호 모두 입력받았다면?
				System.out.println("회원가입을 확정하시겠습니까? ( Y / N )");
				answer = sc.nextLine();
				if (answer.equals("Y") || answer.equals("y")) {
					membersIdcheck.add(identify);
					System.out.println("성공적으로 가입되셨습니다.");
					System.out.println("회원정보"
							+ "\n1. 이름 : " + identify.getId()
							+ "\n2. 성별 : " + identify.getSex()
							+ "\n3. 나이 : " + identify.getAge()
							+ "\n4. 아이디 : " + identify.getId()
							+ "\n5. 비밀번호 : " + identify.getPin()
							+ "\n 기본적으로 1,000원이 주어집니다.");
					break;
				}else if (answer.equals("N") || answer.equals("n")) {
					System.out.println("메인 메뉴로 이동합니다.");
					break;
				}else {
					System.out.println("잘못 누르셨습니다. 다시 눌러주세요.");
				}
				membersIdcheck.add(identify);
			}else if(answer.equals("N") || answer.equals("n")) {
				System.out.println("메인 메뉴로 이동합니다.");
				break;
			}else {
				System.out.println("잘못 누르셨습니다. 다시 눌러주세요.");
			}
		} while (true);
	}
	
	//아이디 중복검사
	boolean idchecking(String id) {
		for (Identify checkmember : membersIdcheck) {
			if (id.equals(checkmember.getId())) {
				System.out.println("아이디가 중복되었습니다. 다른 아이디를 등록해주세요.");
				return true;
			}
		}
		return false;
	}
}
