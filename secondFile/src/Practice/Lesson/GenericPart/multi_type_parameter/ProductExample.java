package Practice.Lesson.GenericPart.multi_type_parameter;

public class ProductExample {

	public static void main(String[] args) {
		
		Product<Tv, String> product = new Product<>();
		//클래스나 인터페이스를 생성할 때 여러 파라미터를 자유롭게 제네릭을 사용하여 강하게 지정할 수 있다.
		
		product.setKind(new Tv());
		product.setModel("스마트TV");
		Tv tv = product.getKind();
		String tvModel = product.getModel();
		
		
		Product<Car, String> product2 = new Product<>();
		product2.setKind(new Car());
		product2.setModel("스포츠카");
		Car car = product2.getKind();
		String carModel = product2.getModel();
		
	}

}
