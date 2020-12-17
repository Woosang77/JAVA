package Practice.Lesson.collection_framework.map.hashtable;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashTableExample {

	public static void main(String[] args) {
		Map<String, String> map = new Hashtable<>();
		//HashTable은 list에서 Vector처럼 기능은 다른 Map과 같지만, 동기화되어있어서 멀티스레드 환경에서 유리하다.
		//하지만, 단일스레드에서는 기본적인 잠금이 걸려있어서 HashMap에 비해 비효율적이다.
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
	
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("ID와 비밀번호를 입력해주세요 : ");
			System.out.print("아이디 : ");
			String id = scanner.nextLine();
			
			System.out.print("비밀번호 : ");
			String password = scanner.nextLine();
			System.out.println();
			
			if (map.containsKey(id)) {
				if (map.get(id).equals(password)) {
					System.out.println("로그인 되었습니다.");
					break;
				}else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			}else {
				System.out.println("입력하신 아이디가 없습니다.");
			}
		}
	}

}
