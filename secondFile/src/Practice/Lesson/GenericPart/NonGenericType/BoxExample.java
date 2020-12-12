package Practice.Lesson.GenericPart.NonGenericType;

public class BoxExample {

	public static void main(String[] args) {
		Box box = new Box();
		
		box.set("홍길동");
		//String의 홍길동이 저장되면서 Object으로 업캐스팅됨
		
		//String boj = box.get();	 Cannot convert from Object to String
		String name = (String)box.get(); //강제 타입변환이 필요함
		
		box.set(new Apple());  		//Apple객체 또한 Object를 상속받기 때문에 대입에 에러가 없다.
		
	}

}
