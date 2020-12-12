package Practice.Lesson.GenericPart.generic_method;

public class BoxingMethodExample {

	public static void main(String[] args) {
		Box<Integer>box1 = Util.<Integer>boxing(100);
		int intValue = box1.get();
		System.out.println(intValue);
		
		
		Box<String> box2 = Util.boxing("홍길동");		
		//메소드 이름 앞에 <>를 표시하지 않으면 컴파일러가 파라미터의 타입을 유추해서 지정한다.
		String strValue = box2.get();
		System.out.println(strValue);
	}

}
