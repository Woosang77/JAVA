package Practice.running;

public class HankookTire extends Tire{
	
	//������
	public HankookTire(String location, int maxRotaion) {
		super(location, maxRotaion);
	}
	
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if (accumulatedRotation < maxRotation) {
			System.out.println(location + "HankookTire ���� : " +
					(maxRotation - accumulatedRotation) + "ȸ");
			return true;
		} else {
			System.out.println("*** " + location + "��ũ ***");
			return false;
		}
	}
}
