package Practice.Lesson.ExceptionPart;

public class ExceptionDemo2 {

	public static void main(String[] args) {
		String [] name = new String[2];
		
		try {
			name[0] = "수지";
			System.out.println("이름 :" + name[0]);
			
			name[1] = "아이유";
			System.out.println("이름 :" + name[1]);
			
			name[2] = "윤하	";
			System.out.println("이름 :" + name[2]);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 참조 에러 발생");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("시스템 종료");
		}
	}

}
