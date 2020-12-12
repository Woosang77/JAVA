package Practice.Lesson.GenericPart.GenericType;

public class BoxExample {

	public static void main(String[] args) {
		//Box box = new Box(); 	이렇게 아무 타입을 지정하지 않으면 Object로 지정된다.
		
		Box<String> box = new Box<String>();
		//box 변수에 담긴 Box객체의 모든 메소드는 String을 받는다.
		
		box.set("안녕");
		String hi = box.get();
		
		
		Box<Integer> box2 = new Box<>();
		box2.set(150);
		int num = box2.get();
		
	}

}
