package Practice.Lesson.GenericPart.NonGenericType;

public class BoxExample {

	public static void main(String[] args) {
		Box box = new Box();
		
		box.set("ȫ�浿");
		//String�� ȫ�浿�� ����Ǹ鼭 Object���� ��ĳ���õ�
		
		//String boj = box.get();	 Cannot convert from Object to String
		String name = (String)box.get(); //���� Ÿ�Ժ�ȯ�� �ʿ���
		
		box.set(new Apple());  		//Apple��ü ���� Object�� ��ӹޱ� ������ ���Կ� ������ ����.
		
	}

}
