package Practice.Lesson;
//�ڵ��� ��� �񱳸� ���� �������̽��� ��� Ŭ������ ����
abstract class handsphone {
	
	public void call() {
		System.out.println("������");
	}
	
	public void message() {
		System.out.println("�� ��");
	}
	
	public abstract void ai();
}

class Galaxy extends handsphone implements Payment{
	public void ai() {
		System.out.println("�򽺺�");
	}
	
	public void pay() {
		System.out.println("�Ｚ���̷� ����");
	}
}

class Iphone extends handsphone {
	public void ai() {
		System.out.println("�ø�");
	}
}

class V50 extends handsphone implements Payment{
	public void ai() {
		System.out.println("����");
	}
	
	public void pay() {
		System.out.println("LG���̷� ����");
	}
}

interface Payment {
	public void pay();
}

class Card implements Payment {
	public void pay() {
		System.out.println("�ܸ��� ����");
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
