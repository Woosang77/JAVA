package Practice.Lesson.ExceptionPart;


public class ExceptionDemo {
	public void call(int j) throws ArrayIndexOutOfBoundsException{
			int [] i = {1,2,3};
			System.out.println("call value		" + i[j]);
	}
	
	public static void main(String[] args) {
		ExceptionDemo ed = new ExceptionDemo();
		try {
			ed.call(1);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭�� ũ�⿡ �´� ���� �Է��ϼ���!");
			e.printStackTrace();
		} finally {
			System.err.println("Finally ������ catch���ο� ������� ����~~");
		}
	}
}
