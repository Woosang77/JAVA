package HorseRacingGame;

import java.util.*;

public class Management {
	HashMap<String, Identify> members = new HashMap<>();

	Identify identify = new Identify();
	Scanner sc = new Scanner(System.in);
	
	public void menu() {
		int num = 0;
		System.out.println("=====Welcome=====");
		do {
			System.out.println("=Obok's HorseRacing="
					+"\n"
					+ "\n1. Game start"
					+ "\n2. Sign up"
					+ "\n3. User Lookup"
					+ "\n4. Modify User Information"
					+ "\n5. I'm out");	
			System.out.println();
			System.out.print("Press number : ");
			num = sc.nextInt();
			sc.nextLine();
			if(num < 1 || num > 5) {
				System.out.println("Press number again");
			}else if(num == 5) {
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
				//사용자 조회
				UserLookup();
				break;
			case 4:
				modifying();
				break;
				//유저 정보수정
				
			}
		} while (true);
	}
	
	//게임 사용자 등록(이름, 성별, 나이 // 이상 없으면 비밀번호 입력받기(마이페이지 이용하기))
	void signing() {
		String name;
		String sex;
		String age;
		String id;
		int pin;
		boolean flags = true;
		
		breakOut :
		do {	
			System.out.print("신규 이용자 가입을 하시겠습니까? ( Y / N )");
			String answer = sc.nextLine();
			try {
				flags = checkYesNo(answer);				
			} catch (WrongAnswerException e) {
				System.out.println("Y(y) 또는 N(n)을 입력해주세요.");
				continue;
			}
			if (!flags) {
				System.out.println("메인메뉴로 이동합니다.");
				break;
			}
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
			//아이디 설정
			do {
				System.out.print("등록할 아이디를 눌러주세요 : ");
				id = sc.nextLine();
				flags = idchecking(id);
				if (flags) {
					System.out.println("아이디가 중복되었습니다.");
				}
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
			do {				
				boolean check = true;
				System.out.println("회원가입을 확정하시겠습니까? ( Y / N )");
				answer = sc.nextLine();
				try {				
					check = checkYesNo(answer);
				} catch (WrongAnswerException e) {
					System.out.println("Y(y) 또는 N(n)을 입력해주세요.");
				}
				if (!check) {
					System.out.println("확정을 취소합니다. 메인 메뉴로 이동합니다.");
					break breakOut;
				}else if(check) {break;}
			} while (true);
			members.put(identify.getId(), identify);
			System.out.println("성공적으로 가입되셨습니다.");
			System.out.println("	<회원정보>		"
					+ "\n1. 이름 : " + identify.getName()
					+ "\n2. 성별 : " + identify.getSex()
					+ "\n3. 나이 : " + identify.getAge()
					+ "\n4. 아이디 : " + identify.getId()
					+ "\n5. 비밀번호 : " + identify.showPin() + "\n"
					+ "\n 기본적으로 1,000원이 주어집니다." + "\n");
			break;
		} while (true);
	}
	
	//사용자 정보조회
	void UserLookup() {
		do {
			boolean check;
			Set<String> idSet = members.keySet();
			Iterator<String> iter = idSet.iterator();
			System.out.print("정보조회를 하시겠습니까? ( Y / N )");
			try {
				check = checkYesNo(sc.nextLine());				
			} catch (WrongAnswerException e) {
				System.out.println("Y(y) 또는 N(n)을 입력해주세요.");
				continue;
			}
			if (!check) {
				System.out.println("조회를 취소합니다.");
				break;
			}
			System.out.print("ID : ");
			String findId = sc.nextLine();
			while (iter.hasNext()) {
				String valueId = iter.next();
				if (findId.equals(valueId)) {
					identify = members.get(valueId);
					identify.getAllInfo();
					check = false;
					break;
				}
			}
			if (check) {
				System.out.println("ID doesn't exist.");
			}
		} while (true);
	}
	
	//유저 정보 수정
	void modifying() {
		String m_ID;
		boolean flags;
		int m_pw;
		System.out.print("ID : ");
		m_ID = sc.nextLine();
		flags = idchecking(m_ID);
		if (!flags) {System.out.println("ID doesn't exist.");}
		do {
			for (int i = 0; i < 5; i++) {
				System.out.print("ID : " + m_ID + "" + "\n PW : ");
				 m_pw = sc.nextInt();
			}
		} while (flags);
	}
	
	//아이디 중복확인
	boolean idchecking(String id) {
		Set<String> idSet = members.keySet();
		Iterator<String> iter = idSet.iterator();
		while(iter.hasNext()) {
			String iterId = iter.next();
			if (id.equals(iterId)) {
				return true;
			}
		}
		return false;
	}
	
	//YES or NO
	boolean checkYesNo(String answer) throws WrongAnswerException {
		if (answer.equals("Y") || answer.equals("y")) {
			return true;
		}else if(answer.equals("N") || answer.equals("n")) {
			return false;
		} else {
			throw new WrongAnswerException();
		}
	}
}