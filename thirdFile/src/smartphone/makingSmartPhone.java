package smartphone;
public class makingSmartPhone {
	public static void main(String[] args) {
		Tool sp = new Tool();
		boolean unlock = sp.unlocking();
		while (unlock == true) {
			sp.smartPhoneStart();
		}
	}
}
