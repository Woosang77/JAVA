package Practice.Lesson.GenericPart.bounded_type;

public class BoundedTypParameterExample {

	public static void main(String[] args) {
		//int result1 = Util.compare("A", "B");  //Number�� �ڽ�Ŭ������ �ƴϹǷ� ������ �߻�
		int result1 = Util.compare(10,20); 
		System.out.println(result1);
		
		
		int result2 = Util.compare(4.5, 3); //double�̴� int�� ������� NumberŸ���� �ڽ��̸� �� ����
		System.out.println(result2);
	}

}
