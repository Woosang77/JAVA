package HorseRacingGame;

import java.util.*;

public class Management {
	HashMap<String, Identify> members = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	Identify getIdentify;
	Gaming gaming;
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
				getIdentify = new Identify();
				System.out.print("등록되어있는 아이디와 비밀번호를 입력해주세요"
						+ "\nID : ");
				String str = sc.nextLine();
				if (idchecking(str)) {
					getIdentify = members.get(str);
					System.out.print("PW : ");
					int try_pw = sc.nextInt();
					sc.nextLine();
					if (try_pw == getIdentify.getPin()) {
						gaming = new Gaming();
						gaming.gameStarting(getIdentify);
						break;
					}else {
						System.out.print("비밀번호를 다시 입력하시겠습니까? ( Y / N )");
						String answer  = sc.nextLine();
						if (answer.equals("N") || answer.equals("n")) {
							System.out.println("메인메뉴로 이동합니다.");
							break;
						}
					}
				}else {
					System.out.println("등록되지 않은 아이디입니다.");
					break;
				}
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
				//유저 정보수정
				modifying();
				break;
			}
		} while (true);
	}
	
	//게임 사용자 등록
	void signing() {
		Identify setIdentify = new Identify();
		String name;
		String sex;
		String age;
		String id;
		int pin;
		boolean flags = true;
		
		breakOut :
		do {	
			System.out.println("=================");
			System.out.print("신규 이용자 가입을 하시겠습니까? ( Y / N ) : ");
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
			setIdentify.setName(name);
			
			//성별
			System.out.print("성별( 남 / 여 ) : ");
			sex = sc.nextLine();
			try {
				setIdentify.setSex(sex);
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
				setIdentify.setAge(age);					
			} catch (IllegalAgeException e) {
				System.out.println(e.getMessage() +
						"\n처음으로 돌아갑니다.");
				continue;
			}			
			//아이디 설정
			do {
				System.out.println("===============");
				System.out.print("등록할 아이디를 눌러주세요 : ");
				id = sc.nextLine();
				flags = idchecking(id);
				if (flags) {
					System.out.println("중복되는 아이디가 존재합니다.");
				}
			} while (flags);
			setIdentify.setId(id);
			System.out.println("아이디 등록이 완료되었습니다.");
			
			//비밀번호 설정(pin 4자리)
			do {
				System.out.println("===============");
				System.out.print("사용할 비밀번호 4자리 숫자를 입력해주세요 : ");
				pin = sc.nextInt();
				sc.nextLine();
				if (!((pin / 1000) >= 1)) {
					System.out.println("다시 입력해주세요.");
					continue;
				}else {
					setIdentify.setPin(pin);
					break;
				}
			} while (true);
			//이름 나이 성별 아이디 비밀번호 모두 입력받았다면?
			do {
				System.out.println("===============");
				boolean check = true;
				System.out.print("회원가입을 확정하시겠습니까? ( Y / N ) : ");
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
			members.put(id, setIdentify);
			System.out.println("성공적으로 가입되셨습니다.");
			System.out.println("	<회원정보>		"
					+ "\n1. 이름 : " + setIdentify.getName()
					+ "\n2. 성별 : " + setIdentify.getSex()
					+ "\n3. 나이 : " + setIdentify.getAge()
					+ "\n4. 아이디 : " + setIdentify.getId()
					+ "\n5. 비밀번호 : " + setIdentify.showPin() + "\n"
					+ "\n 기본적으로 1,000원이 주어집니다." + "\n");
			break;
		} while (true);
	}
	
	//사용자 정보조회
	void UserLookup() {
		getIdentify = new Identify();
		do {
			boolean check;
			System.out.println("===============");
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
			check = idchecking(findId);
			if (check) {
				getIdentify = members.get(findId);
				System.out.println("===============");
				getIdentify.getAllInfo();
				break;
			}else if (!check) {
				System.out.println("ID doesn't exist.");
			}
		} while (true);
	}
	
	//유저 정보 수정
	void modifying() {
		getIdentify = new Identify();
		Identify changeIdentify = new Identify();
		String m_ID = null;
		int try_pw;
		int count;
		boolean check =  true;
		boolean flags;
		
		do {
			System.out.println("===============");
			System.out.print("ID : ");
			m_ID = sc.nextLine();
			flags = idchecking(m_ID);
			if (!flags) {
				System.out.println("ID doesn't exist.");
				continue;
			}
			getIdentify = members.get(m_ID);
			int real_pw = getIdentify.getPin();
			for (count = 0; count < 5; count++) {
				System.out.print("PW : ");
				 try_pw = sc.nextInt();
				 sc.nextLine();
				 if (try_pw == real_pw) {
					 System.out.println("정보수정으로 이동합니다.");
					 break;
				}else {
					System.out.println("비밀번호를 "+(count +1)+ "회 틀리셨습니다.");
					System.out.print("비밀번호를 다시 입력하시겠습니까? ( Y / N )");
					String answer  = sc.nextLine();
					if (answer.equals("N") || answer.equals("n")) {
						System.out.println("메인메뉴로 이동합니다.");
						check = false;
						break;
					}
				}
			}
			if (count == 4) {
				System.out.println("메인메뉴로 이동합니다.");
				break;
			}
			//여기부터 정보수정
			while (check) {
				String str;
				System.out.println("===============");
				getIdentify.getAllInfo();
				System.out.print("변경하실 정보의 번호를 눌러주세요 : ");
				int modifyInfo = sc.nextInt();
				sc.nextLine();
				if(modifyInfo < 1 || modifyInfo > 6) {
					System.out.println("번호를 다시 눌러주세요.");
					continue;
				}else if (modifyInfo == 6) {
					System.out.println("게임머니는 수정할 수 없습니다.");
					continue;
				}
				switch (modifyInfo) {
				case 1:
					//아이디 변경
					while (true) {
						String id = getIdentify.getId();
						System.out.print("<ID 변경>" 
								+"\n변경 전 : " + id
								+ "\n변경 : ");
						str = sc.nextLine();
						if (idchecking(str)) {
							System.out.println("동일한 아이디가 존재합니다.");
							continue;
						}
						try {
							//value값 Identify객체 깊은 복사
							getIdentify.setId(str);
							changeIdentify = (Identify)getIdentify.clone();
						} catch (CloneNotSupportedException e) {
							System.out.println(e.getStackTrace());
						}
						members.put(str, changeIdentify);
						members.remove(id);
						System.out.println( "<변경완료>"
								+ "\nID : " + changeIdentify.getId());
						System.out.println("아이디 변경은 재부팅이 필요하여 메인메뉴부터 시작해주십이오.");
						break;
					}
					break;
				case 2:
					//이름 변경
					System.out.print("<이름 변경>" 
					+"\n변경 전 : " + getIdentify.getName() 
					+ "\n변경 : ");
					str = sc.nextLine();
					getIdentify.setName(str);
					System.out.println( "<변경완료>"
							+ "\nUser Name : " + getIdentify.getName());
					break; 
				case 3:
					//생년월일변경
					while (true) {
						System.out.print("<생년월일 변경>" 
								+"\n변경 전 : " + getIdentify.getAge()
								+ "\n변경 : ");
						str = sc.nextLine();
						try {
							getIdentify.setAge(str);							
						} catch (IllegalAgeException e) {
							e.getMessage();
							System.out.println("다시 입력해주세요.");
							continue;
						}
						System.out.println( "<변경완료>"
								+ "\nAge : " + getIdentify.getAge());
						break;
					}
					break;
				case 4:
					//성별 변경
					while (flags) {						
						System.out.print("<성별 변경>" 
								+"\n변경 전 : " + getIdentify.getSex() 
								+ "\n변경 ( 남 / 여 ) : ");
						str = sc.nextLine();
						try {
							getIdentify.setSex(str);						
						} catch (SexUnclearException e) {
							e.getMessage();
							continue;
						}
						System.out.println( "<변경완료>"
								+ "\nSex : " + getIdentify.getSex());
						break;
					}
					break;
				case 5:
					//비밀번호 변경
					do {
						System.out.print("<비밀번호 변경>" 
								+"\n변경 전 : " + getIdentify.getPin() 
								+ "\n변경  : ");
						int pw = sc.nextInt();
						sc.nextLine();
						if (!((pw / 1000) >= 1)) {
							System.out.println("다시 입력해주세요.");
							continue;
						}else {
							getIdentify.setPin(pw);
							break;
						}
					} while (true);
					break;
				}
				System.out.print("다른 정보를 추가로 수정하시겠습니까? ( Y / N ) : ");
				str = sc.nextLine();
				try {
					check = checkYesNo(str);					
				} catch (WrongAnswerException e) {
					System.out.println("Y / N 로 응답해주십시오.");
					check = false;
				}
			}
		} while (flags && check);
	}
	
	//아이디 확인
	boolean idchecking(String id) {
		Set<String> set = members.keySet();
		for (String string : set) {
			if (id.equals(string)) {
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