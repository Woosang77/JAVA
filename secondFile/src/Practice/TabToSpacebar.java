package Practice;
public class TabToSpacebar {
	public static void main(String[] args) {
		double num = 1;

		for (int i = 0; i < 10; i++) {
			num *= 1.5;
			System.out.println(num);
		}
	}
																		   // .replaceAll(A, B) -- A전체를 B로 수정한다.   ===위의 두개의 차이점은 replace는 특수문자로 치환가능 , replaceAll은 불가능
}																						   //.replaceFirst(A, B) ---문자열에서 가장먼저 나타나는 A를 B로 수정한다.