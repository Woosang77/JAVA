package Practice.Lesson.GenericPart.multi_type_parameter;

public class ProductExample {

	public static void main(String[] args) {
		
		Product<Tv, String> product = new Product<>();
		//Ŭ������ �������̽��� ������ �� ���� �Ķ���͸� �����Ӱ� ���׸��� ����Ͽ� ���ϰ� ������ �� �ִ�.
		
		product.setKind(new Tv());
		product.setModel("����ƮTV");
		Tv tv = product.getKind();
		String tvModel = product.getModel();
		
		
		Product<Car, String> product2 = new Product<>();
		product2.setKind(new Car());
		product2.setModel("������ī");
		Car car = product2.getKind();
		String carModel = product2.getModel();
		
	}

}
