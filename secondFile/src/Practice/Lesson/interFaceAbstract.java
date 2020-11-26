package Practice.Lesson;
//핸드폰 기능 비교를 통한 인터페이스와 상속 클래스의 차이
abstract class handsphone {
	
	public void call() {
		System.out.println("따르릉");
	}
	
	public void message() {
		System.out.println("띵동 띵동");
	}
	
	public abstract void ai();
}

class Galaxy extends handsphone implements Payment{
	public void ai() {
		System.out.println("빅스비");
	}
	
	public void pay() {
		System.out.println("삼성페이로 결제");
	}
}

class Iphone extends handsphone {
	public void ai() {
		System.out.println("시리");
	}
}

class V50 extends handsphone implements Payment{
	public void ai() {
		System.out.println("구글");
	}
	
	public void pay() {
		System.out.println("LG페이로 결제");
	}
}

interface Payment {
	public void pay();
}

class Card implements Payment {
	public void pay() {
		System.out.println("단말기 결제");
	}
}
public class interFaceAbstract {
		
	public static void main(String[] args) {
			Galaxy s20 = new Galaxy();
			s20.ai();
			s20.call();
			s20.message();
			s20.pay();
			
			Iphone i12 = new Iphone();
			i12.ai();
			i12.call();
			i12.message();
			//i12.pay();
			
			V50 v505 = new V50();
			v505.ai();
			v505.call();
			v505.message();
			v505.pay();
			
			Card shinhan = new Card();
			shinhan.pay();
	}

}
