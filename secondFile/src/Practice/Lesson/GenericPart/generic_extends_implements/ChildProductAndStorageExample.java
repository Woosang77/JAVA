package Practice.Lesson.GenericPart.generic_extends_implements;

public class ChildProductAndStorageExample {

	public static void main(String[] args) {
		ChildProduct<TV, String, String> childProduct = new ChildProduct<>();
		childProduct.setKind(new TV());
		childProduct.setModel("smartTv");
		childProduct.setCompany("samsung");
		
		Storage<TV> storage = new StorageImpl<>(10);
		storage.add(new TV(), 5);
		TV tv = storage.get(5);
	}

}
