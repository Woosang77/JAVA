package Practice.Lesson.ExceptionPart;

class DivideException extends Exception {		//RuntimeException�� ��ӹ޾� ���ο� ���ܸ� ����� ���ܿ��� catch�� ���ص� �Ǳ⶧��  
	DivideException() {
		super()	;
	}
	DivideException(String message){
		super(message);
	}
}	

class Calculor {
	int left, right;
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	public void Division() {
		if (right == 0) {
			try {
				throw new DivideException("0���� ������ ���� ������� �ʽ��ϴ�.");	
			} catch (Exception e) {
				e.printStackTrace();			//������ �ٿ����� ã�´�.
			}
		}
		System.out.println(left / right);
	}
}
public class ExceptionDemo5 {

	public static void main(String[] args) {
		Calculor cal = new Calculor();
		cal.setOprands(10, 0);
		cal.Division();
	}

}
