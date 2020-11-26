package Practice.Lesson;

class A {
	public int id;
	A (int id) {
		this.id = id;
	}
}


public class ReferenceDemo1 {

	public static void runValue() {
		int a = 1;	//기본형 데이터타입			1(기본형 데이터타입)을 변수(박스)a에 담는다. 
		int b = a;								//		a를 변수 b에 담는 것처럼 보이지만, a에 담겨진 1을 복제하여 b의 담는 것이다. 
		b = 2;									// 	1이 담겨진 b변수의 값을 2로 변경한다.
		System.out.println("runValue : " + a);				//	a를 출력하면 당연히 1이 나온다.
	}
	
	public static void runReference() {
		A a = new A(1);		//참조형 데이터타입		A인스턴스를 생성한 참조(주소)값을 a변수에 담는다.
		A b = a;										// 	b = a는 a가 가지는 주소값을 b에 담아서 b 또한 같은 인스턴스의 주소값을 가르킨다.
		b.id = 2;									//		A인스턴스의 id를 2로 지정한다.
		System.out.println("runReference : " + a.id);			//a.id를 호출하는 것은 A인스턴스의 id(2)를 호출하는 것이기 때문에 2가 나온다.
	}
	
	public static void main(String[] args) {	
		runValue();					//결과 : runValue : 1				기본형은 복사본같은 느낌
		runReference();				// 결과 : runReference : 2		참조형은 바로가기 같은 느낌
										//참조형과 기본형은 값을 담는 방식부터 다르기 때문에 복제의 유무 또한 차이난다.
	}

}
