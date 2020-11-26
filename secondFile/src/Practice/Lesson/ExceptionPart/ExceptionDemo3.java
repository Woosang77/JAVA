package Practice.Lesson.ExceptionPart;
class ExceptionCal {
	int left, right;
	
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
		if (right == 0) {
			throw new IllegalArgumentException("두 번째 인자값은 0이 될 수 없습니다.");		//예상되는 예외는 new를 사용해 새로 생성이 가능하다. 또한, 괄호 안에는 예외와 함께 전달한 내용을 포함할 수 있다.
		}
	}
	
	public void divide() {
		try {
			System.out.println("계산결과는 ");
			System.out.println(left / right);
			System.out.println(" 입니다.");
		} catch (Exception e) {
			System.out.println("\n\ne.getMessage()\n" + e.getMessage());			// .getMessage(); = 오류에 대한 기본적인 메세지, 상세하지 않다. (뭐 때문에 오류다. 이런느낌)
			System.out.println("\n\ne.toString()\n"+ e.toString());			   // .toString()  =  java.lang.ArithmeticException: / by zero   // .getMessage()보다 자세한 설명과 어떤 예외인지와 같이 예외의 종류를 설명한다.
			System.out.println("\n\ne.printStackTrace()\n");			
			e.printStackTrace();  		//위의 두개와 다르게 .printStackTrace();는 리턴값이 없다.이 메소드를 호출하면 내부적으로 예외의 결과들을 출력한다. //가장 자세한 정보가 나온다.
		} finally {
			System.out.println("계산 종료~");		//finally 안의 문장은 catch문의 실행 여부에 관계없이 실행되는 문장이다. 예를 들어 DB를 사용한다면 DB 서버에 접속해야하는데,
		}															// 접속을 하고 실행을 하는 중에 예외의 발생여부와 상관없이 DB서버를 종료시켜야하기때문에 사용한다.
	}
}
public class ExceptionDemo3 {
	public static void main(String[] args) {
		ExceptionCal ec = new ExceptionCal();
		ec.setOprands(10, 0);
		ec.divide();
	}
}

//알아두면 좋을 예외들 
/*
 * 		1) IllegalArgumentException : 매개변수가 의도하지 않은 상황을 유발할 때
 * 		2) IllegalStateException : 메소드를 호출하기 위한 상태가 아닐 때
 * 		3) NullPointerException : 매개 변수 값이 null 일 때
 * 		4) IndexOutOfBoundsException : 인덱스 매개 변수 값이 범위를 벗어날 때
 * 		5) ArithmeticException : 산술적인 연산에 오류가 있을때
 */
