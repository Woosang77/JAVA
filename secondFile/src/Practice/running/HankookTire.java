package Practice.running;

public class HankookTire extends Tire{
	
	//생성자
	public HankookTire(String location, int maxRotaion) {
		super(location, maxRotaion);
	}
	
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if (accumulatedRotation < maxRotation) {
			System.out.println(location + "HankookTire 수명 : " +
					(maxRotation - accumulatedRotation) + "회");
			return true;
		} else {
			System.out.println("*** " + location + "펑크 ***");
			return false;
		}
	}
}
