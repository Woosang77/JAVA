package Practice.Lesson.GenericPart.generic_method2;

public class compareMethodExample {

	public static void main(String[] args) {
		
		Pair<Integer, String> p1 = new Pair<>(1, "���");
		Pair<Integer, String> p2 = new Pair<>(1, "���");
	
		boolean result1 = Util.<Integer,String>compare(p1, p2);
		if (result1) {
			System.out.println("����");
		} else {
			System.out.println("�񵿵�");
		}
		
		
		
		Pair<String, String> p3 = new Pair<>("user1", "ȫ�浿");
		Pair<String, String> p4 = new Pair<>("user2", "ȫ�浿");
	
		boolean result2 = Util.compare(p3, p4);
		
		if (result2) {
			System.out.println("����");
		} else {
			System.out.println("�񵿵�");
		}
	}

}