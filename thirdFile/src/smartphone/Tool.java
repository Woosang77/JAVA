 package smartphone;

import java.util.*;
import java.text.SimpleDateFormat;

public class Tool {
	Scanner scan = new Scanner(System.in);
	private String passWord = "486715*";
	String[] manual = {"통화", "사진", "시간", "전화번호등록", "비밀번호변경", "비밀번호확인"};
	
	
	List<String> nameBook = new ArrayList<>();
	List<String> numberBook = new ArrayList<>();
	
	//전화하기
	public void calling () {
		System.out.println("어느분께 전화를 하시겠습니까" + nameBook);
		String name = scan.nextLine();
		System.out.println(name + "님께 전화를 겁니다.");
	}
	
	//사진찍기
	public void takingPhoto() {
		for (int i = 0; i < 3; i++) {
			System.out.println(i+1);
		}
		System.out.println("사진이 촬영되었습니다.");
	}
	//날짜, 시간보기
	public void clock() {
		long time = System.currentTimeMillis();
		SimpleDateFormat simpl = new SimpleDateFormat("yyyy년 MM월 dd일 aa hh시 mm분 ss초");
		String s = simpl.format(time);
		System.out.println(s);
	}
	//비밀번호변경
	public void PwChange() {
		System.out.println("변경하실 비밀번호를 입력해주세요. :");
		this.passWord = scan.nextLine(); 
	}
	
	//비밀번호 확인
	public void PwConfirm() {
		System.out.println(passWord);
	}
	
	//잠금해제하기
	public boolean unlocking() {
		do {
			System.out.println("잠금 비밀번호를 입력해주세요 : ");
			String passnum = scan.nextLine();
				if (!passnum.equals(passWord)) {
					System.out.println("잘못된 비밀번호 입니다.");
				}else {
					System.out.println("잠금해제되었습니다.");
					return true;
				}
		}while(true);
	}
	
	//전화번호등록
	public void registering() {
		//동일번호 검사
		boolean check = true;
		System.out.println("번호를 입력해주세요 : ");
		String number = scan.nextLine();
		for (int i = 0; i < numberBook.size(); i++) {
			if(numberBook.contains(number)) {
				System.out.println("동일한 번호가 저장되어있습니다. " + nameBook.get(i));
				check = false;
				break;
			}
		}
		if(check == true) {
			System.out.println("해당 번호의 이름을 등록해주세요 : ");
			String name = scan.nextLine();
			nameBook.add(0, name);
			numberBook.add(0, number);
			System.out.println("등록이 완료되었습니다.");
		}
	}
	
	//스마트폰 시작하기
		void smartPhoneStart() {
			//메인메뉴
			while (true) {
				System.out.println("원하시는 기능을 선택해 주세요. : " + Arrays.toString(manual));
				String answer = scan.nextLine();
				switch (answer) {
					case "통화":
						calling();
						break;
					case "사진":
						takingPhoto();
						break;
					case "시간":
						clock();
						break;
					case "전화번호등록":
						registering();
						break;
					case "비밀번호변경":
						PwChange();
						break;
					case "비밀번호확인":
						PwConfirm();
						break;
				}
			}
		}
}