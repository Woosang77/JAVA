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
			System.out.println("배열의 크기에 맞는 값을 입력하세요!");
			e.printStackTrace();
		} finally {
			System.err.println("Finally 문장은 catch여부와 관계없이 실행~~");
		}
	}
}
