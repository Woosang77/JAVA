package Practice.Lesson.ExceptionPart;

public class ExceptionDemo2 {

	public static void main(String[] args) {
		String [] name = new String[2];
		
		try {
			name[0] = "����";
			System.out.println("�̸� :" + name[0]);
			
			name[1] = "������";
			System.out.println("�̸� :" + name[1]);
			
			name[2] = "����	";
			System.out.println("�̸� :" + name[2]);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭 ���� ���� �߻�");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("�ý��� ����");
		}
	}

}
