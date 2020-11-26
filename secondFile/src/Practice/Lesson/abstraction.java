package Practice.Lesson;

//추상화는 기본적으로 상속관계하에 이루어진다. 
//상위클래스 맴버 중 추상으로 지정된 맴버는 하위클래스를 생성하면 무조건적으로 실행해야하는 맴버이다.
//상위클래스의 모든 맴버가 추상화로 지정될 필요는 없으며, 하나 이상의 맴버가 추상으로 지정되면 클래스명 앞에 abstract가 붙는다.
//여러개의 하위클래스를 만들어야할 경우 각각의  하위클래스가 다른 내용이지만 공통적으로 가져야할 것들을 필수적으로 정의

abstract class supClass {
	
	int left, right;
	public void setOprands (int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	public abstract void sum();
	public abstract void avg();
	public void run() {
		sum();
		avg();
	}
}
//하위클래스 1 
class subClassPlus extends supClass {
	public void sum() {
		System.out.println("+ sum :" + (this.left + this.right));
	}
	public void avg() {
		System.out.println("+ avg :" + (this.left + this.right) / 2);
	}
}
//하위클래스 2
class subClassMinus extends supClass {
	public void sum() {
		System.out.println("- sum :" + (this.left + this.right));
	}
	public void avg() {
		System.out.println("- avg :" + (this.left + this.right) / 2);
	}
}
//메인 클래스
public class abstraction {
	public static void main(String[] args) {
		//하위1 호출
		subClassPlus sbp = new subClassPlus();
		sbp.setOprands(10, 30);
		sbp.sum();
		sbp.avg();
	
		//하위2 호출
		subClassMinus sbm = new subClassMinus();
		sbm.setOprands(50, 60);
		sbm.sum();
		sbm.avg();
	}

}
