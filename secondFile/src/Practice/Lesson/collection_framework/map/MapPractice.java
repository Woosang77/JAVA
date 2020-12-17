package Practice.Lesson.collection_framework.map;
//Map�� ���� ����ܾ� ������ �����

import java.lang.reflect.Array;
import java.util.HashMap;import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapPractice {
	Scanner scan = new Scanner(System.in);
	HashMap<String	, String> EnglishNote = new HashMap<>();
	public void start() {
		int num = 0;
		//�������� ����� ������ �ݺ���Ű�� ���ؼ��� Do-while���� ����.
		do {
			System.out.println("======����ܾ���======"
					+ "\n1. �ܾ��߰�"
					+ "\n2. ���ܾ� �˻�"
					+ "\n3. �ܾ�����ġ��");
			System.out.println("����Ͻ� ����� ��ȣ�� �Է����ּ��� : ");
			num = scan.nextInt();
			scan.nextLine(); 	
			//scan.nextLine();�̰� ���� �߿���, ���α׷� ����������� nextInt ������ nextLine�� ���� ���Ͱ��� �����鼭 ������ �߻��Ѵ�. �׷��� nextInt������ ���� �Ἥ ���Ͱ� ����
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
				System.out.println("���ڸ� �߸��Է��ϼ̽��ϴ�.");
			}
			
		} while(true);	
	}
	
	void input() {
		while(true) {
			System.out.println("�߰��� ����ܾ� : ");
			String eng = scan.nextLine();
			System.out.println("" + eng + "�� �� : ");
			String kor = scan.nextLine();
			EnglishNote.put(eng, kor);
			System.out.println("����Ǿ����ϴ�.");
			break;
		}
	}
	
	void search() {
		while (true) {
			System.out.println("�˻��� ����ܾ� : ");
			String engq = scan.nextLine();
			if(EnglishNote.containsKey(engq)) {
				System.out.println("�� : " + EnglishNote.get(engq));
				break;
			}else {
				System.out.println("�������� ����");
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
