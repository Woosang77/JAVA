package Practice;
public class TabToSpacebar {
	public static void main(String[] args) {
		String text = "Hi my name is Java\tI'm your friend\tand i'm so proud of you.";
		System.out.println(text);
		System.out.println(TabChanger(text));
	}
	private static String TabChanger(String text) {
		String ChangeTab = text.replaceAll("\t", "    "); 			//문자열에서 특정 데이터를 치환할 때
		return ChangeTab;													   // .replace(A, B) --A를 B로 수정한다.
	}																					   // .replaceAll(A, B) -- A전체를 B로 수정한다.   ===위의 두개의 차이점은 replace는 특수문자로 치환가능 , replaceAll은 불가능
}																						   //.replaceFirst(A, B) ---문자열에서 가장먼저 나타나는 A를 B로 수정한다.