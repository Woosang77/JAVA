package Practice.Lesson.MapPart;
//Map을 통해 영어단어 연습장 만들기

import java.lang.reflect.Array;
import java.util.HashMap;import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapPractice {
	Scanner scan = new Scanner(System.in);
	HashMap<String	, String> EnglishNote = new HashMap<>();
	public void start() {
		int num = 0;
		//포괄적인 기능의 수행을 반복시키기 위해서는 Do-while문도 좋다.
		do {
			System.out.println("======영어단어장======"
					+ "\n1. 단어추가"
					+ "\n2. 영단어 검색"
					+ "\n3. 단어장펼치기");
			System.out.println("사용하실 기능의 번호를 입력해주세요 : ");
			num = scan.nextInt();
			scan.nextLine(); 	
			//scan.nextLine();이게 ㅈㄴ 중요함, 프로그램 실행순서에서 nextInt 다음에 nextLine이 오면 엔터값이 씹히면서 문제가 발생한다. 그래서 nextInt다음에 저걸 써서 엔터값 제거
			if( num > 0 && num < 4) {
				switch (num) {
				case 1:
					input();
					break;
				case 2:
					search();
					break;
				case 3:
					listing(EnglishNote);
					break;
				}
			} else {
				System.out.println("숫자를 잘못입력하셨습니다.");
			}
			
		} while(true);	
	}
	
	void input() {
		while(true) {
			System.out.println("추가할 영어단어 : ");
			String eng = scan.nextLine();
			System.out.println("" + eng + "의 뜻 : ");
			String kor = scan.nextLine();
			EnglishNote.put(eng, kor);
			System.out.println("저장되었습니다.");
			break;
		}
	}
	
	void search() {
		while (true) {
			System.out.println("검색할 영어단어 : ");
			String engq = scan.nextLine();
			if(EnglishNote.containsKey(engq)) {
				System.out.println("뜻 : " + EnglishNote.get(engq));
				break;
			}else {
				System.out.println("저장정보 없음");
			}
		}
	}
	
	void listing(HashMap map){ 
		Set<Map.Entry<String, String>> entries = EnglishNote.entrySet();
		for(Map.Entry<String, String> entry : entries) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
