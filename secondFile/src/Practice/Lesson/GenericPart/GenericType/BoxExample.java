package Practice.Lesson.GenericPart.GenericType;

public class BoxExample {

	public static void main(String[] args) {
		//Box box = new Box(); 	�̷��� �ƹ� Ÿ���� �������� ������ Object�� �����ȴ�.
		
		Box<String> box = new Box<String>();
		//box ������ ��� Box��ü�� ��� �޼ҵ�� String�� �޴´�.
		
		box.set("�ȳ�");
		String hi = box.get();
		
		
		Box<Integer> box2 = new Box<>();
		box2.set(150);
		int num = box2.get();
		
	}

}
