package Practice;
public class TabToSpacebar {
	public static void main(String[] args) {
		String text = "Hi my name is Java\tI'm your friend\tand i'm so proud of you.";
		System.out.println(text);
		System.out.println(TabChanger(text));
	}
	private static String TabChanger(String text) {
		String ChangeTab = text.replaceAll("\t", "    "); 			//���ڿ����� Ư�� �����͸� ġȯ�� ��
		return ChangeTab;													   // .replace(A, B) --A�� B�� �����Ѵ�.
	}																					   // .replaceAll(A, B) -- A��ü�� B�� �����Ѵ�.   ===���� �ΰ��� �������� replace�� Ư�����ڷ� ġȯ���� , replaceAll�� �Ұ���
}																						   //.replaceFirst(A, B) ---���ڿ����� ������� ��Ÿ���� A�� B�� �����Ѵ�.