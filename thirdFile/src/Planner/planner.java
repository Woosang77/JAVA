package Planner;

import java.util.*;

public class planner {
	
	final public int INFO = 3;
	Scanner sc = new Scanner(System.in);
	ArrayList<planElement> mainplan = new ArrayList<>();
	planElement subplan;		//mainplan의 개별의 객체로 저장된다.
	
	public void click() {
		int num = 0;
		do {
			System.out.println("=====날 함잡자!====="
					+ "\n1. 나의 일정 추가"
					+ "\n2. 나의 일정 변경"	
					+ "\n3. 전체 일정 보기"
					+ "\n4. 나의 일정 삭제"
					+ "\n5. 사용 종료");
			System.out.print("사용하실 기능의 번호를 누르세요 : ");
			try {
				num = sc.nextInt();		
			} catch (Exception e) {			
				System.out.println("써있는 숫자만 누르세요.");
			}
			sc.nextLine();
			if(num == 5) {System.out.println("사용 종료");break;}
			switch (num) {
			case 1:
				planning();
				break;
			case 2:
				managing();
				break;
			case 3:
				showing();
				break;
			case 4:
				deliting();
				break;
			}
		} while (true);
	}
	
	// 일정 추가하기
	void planning() {		
		while(true) {
			int month = 0, date = 0, time = 0;
			String text = "";
			System.out.println("등록할 일정의 정보를 적어주세요.\n" + 
					"월 / 일  / 시간 순으로 입력해주세요.\n" +
					"EX) 6 12 18 ");
			month = sc.nextInt();
			date = sc.nextInt();
			time = sc.nextInt();
			sc.nextLine();
			if(month < 1 || month > 12 ) {
				System.out.println("1~12월 안에서 입력해주세요.");
				continue;}
			if(date < 1 || date > 31) {
				System.out.println("1~31일 안으로 입력해주세요.");
				continue;	}
			if (time < 1 || time > 24) {
				System.out.println("1~24시 안으로 입력해주세요.");
				continue;}
			System.out.println(month + "월 " + date + "일 "+ time + "시 ");
			if(month != 0 && date != 0 && time !=0 ) {
				System.out.print("일정의 내용을 작성해주세요. : ");
				text = sc.nextLine();
				subplan = new planElement(month, date, time, text);
				mainplan.add(subplan);
			}
			Collections.sort(mainplan);	//무작위로 등록된 일정을 시간순으로 정렬
			System.out.println("추가로 일정을 등록하시겠습니까? ( Y / N )");
			String flag  = sc.nextLine();
			if (flag.equals("Y") || flag.equals("y")) {
				continue;
			}else if(flag.equals("N") || flag.equals("n")){
				System.out.println("기본 메뉴로 이동합니다.");
				break;
			}
		}
	}
	
	//기존 일정 변경하기
	void managing() {
		boolean bool = true;
		do {
			showing();
			System.out.println("===================");
			System.out.print("수정하실 일정의 번호를 눌러주세요 : ");
			planElement pe = mainplan.get(sc.nextInt() - 1);
			System.out.print("1. 월" + "\n2. 일" + "\n3. 시간" + "\n4. 내용" 
					+ "\n수정할 목록의 번호를 눌러주세요 : " );
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.println("수정 전 : " + pe.getMonth() + "월");
				System.out.print("수정 : ");
				pe.setMonth(sc.nextInt());
				System.out.println("수정되었습니다. : " + pe.getMonth() + "월");
				break;
			case 2:
				System.out.println("수정 전 : " + pe.getDate() + "일");
				System.out.print("수정 : ");
				pe.setDate(sc.nextInt());
				System.out.println("수정되었습니다. : " + pe.getDate() + "일");
				break;
			case 3:
				System.out.println("수정 전 : " + pe.getTime() + "시");
				System.out.print("수정 : ");
				pe.setTime(sc.nextInt());
				System.out.println("수정되었습니다. : " + pe.getTime() + "시");
				break;
			case 4:
				System.out.println("수정 전 내용 : " + pe.getText());
				System.out.print("수정 : ");
				pe.setText(sc.nextLine());
				System.out.println("수정되었습니다. : " + pe.getText());
				break;
			}
			Collections.sort(mainplan);
			System.out.print("다른 부분도 수정하시겠습니까? (예 : 1 / 아니요 : 2)");
			choice =  sc.nextInt();
			if(choice == 2) {
				bool = false;
				System.out.println("메인 메뉴로 이동합니다.");
			}
		} while (bool);
	}

	//기록해둔 모든 일정 표시
	void showing() {
		for(int i = 0; i < mainplan.size(); i ++) {
			subplan = mainplan.get(i);
			int m = subplan.getMonth();
			int d = subplan.getDate();
			int t = subplan.getTime();
			String txt = subplan.getText();
			System.out.println((i + 1) + ". " + m + "월 " + d + "일 " + t + "시  : " + txt + "");
		}
	}
	
	//기존일정 삭제하기
	void deliting() {
		while (true) {
			showing();
			System.out.println("===================");
			System.out.print("삭제할 일정의 번호를 선택해주세요 : ");
			int choice = sc.nextInt();
			planElement p = mainplan.get(choice - 1);
			System.out.println(p.getMonth() + "월 " + p.getDate() + "일 "
					+ p.getTime() + "시 : " + p.getText() + "를 삭제하시겠습니까? ( 예 : 1 / 아니요 : 2)");
			int number = sc.nextInt();
			if (number == 1) {
				mainplan.remove(choice - 1);
				System.out.println("선택하신 일정이 삭제되었습니다.");
				System.out.println("다른 일정도 삭제하시겠습니까? (예 : 1 / 아니요 : 2)");
				if(2 == sc.nextInt()) {
					System.out.println("메인 메뉴로 이동합니다.");
					break;
				}
			}else if(number == 2) {
				System.out.println("메인메뉴로 이동합니다.");
				break;
			}
		}
	}
}
