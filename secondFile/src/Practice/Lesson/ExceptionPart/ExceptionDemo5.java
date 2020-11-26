package Practice.Lesson.ExceptionPart;

class DivideException extends Exception {		//RuntimeException을 상속받아 새로운 예외를 만들면 예외에서 catch를 안해도 되기때문  
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
				throw new DivideException("0으로 나누는 것을 허용하지 않습니다.");	
			} catch (Exception e) {
				e.printStackTrace();			//에러의 근원지를 찾는다.
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
