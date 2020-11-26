package Practice.Lesson.ExceptionPart;
class ExceptionCal {
	int left, right;
	
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
		if (right == 0) {
			throw new IllegalArgumentException("�� ��° ���ڰ��� 0�� �� �� �����ϴ�.");		//����Ǵ� ���ܴ� new�� ����� ���� ������ �����ϴ�. ����, ��ȣ �ȿ��� ���ܿ� �Բ� ������ ������ ������ �� �ִ�.
		}
	}
	
	public void divide() {
		try {
			System.out.println("������� ");
			System.out.println(left / right);
			System.out.println(" �Դϴ�.");
		} catch (Exception e) {
			System.out.println("\n\ne.getMessage()\n" + e.getMessage());			// .getMessage(); = ������ ���� �⺻���� �޼���, ������ �ʴ�. (�� ������ ������. �̷�����)
			System.out.println("\n\ne.toString()\n"+ e.toString());			   // .toString()  =  java.lang.ArithmeticException: / by zero   // .getMessage()���� �ڼ��� ����� � ���������� ���� ������ ������ �����Ѵ�.
			System.out.println("\n\ne.printStackTrace()\n");			
			e.printStackTrace();  		//���� �ΰ��� �ٸ��� .printStackTrace();�� ���ϰ��� ����.�� �޼ҵ带 ȣ���ϸ� ���������� ������ ������� ����Ѵ�. //���� �ڼ��� ������ ���´�.
		} finally {
			System.out.println("��� ����~");		//finally ���� ������ catch���� ���� ���ο� ������� ����Ǵ� �����̴�. ���� ��� DB�� ����Ѵٸ� DB ������ �����ؾ��ϴµ�,
		}															// ������ �ϰ� ������ �ϴ� �߿� ������ �߻����ο� ������� DB������ ������Ѿ��ϱ⶧���� ����Ѵ�.
	}
}
public class ExceptionDemo3 {
	public static void main(String[] args) {
		ExceptionCal ec = new ExceptionCal();
		ec.setOprands(10, 0);
		ec.divide();
	}
}

//�˾Ƶθ� ���� ���ܵ� 
/*
 * 		1) IllegalArgumentException : �Ű������� �ǵ����� ���� ��Ȳ�� ������ ��
 * 		2) IllegalStateException : �޼ҵ带 ȣ���ϱ� ���� ���°� �ƴ� ��
 * 		3) NullPointerException : �Ű� ���� ���� null �� ��
 * 		4) IndexOutOfBoundsException : �ε��� �Ű� ���� ���� ������ ��� ��
 * 		5) ArithmeticException : ������� ���꿡 ������ ������
 */
