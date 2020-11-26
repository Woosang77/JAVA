package Practice.Lesson;
//������(enum)�� �����Ǿ� �ִ� ����� ���� (��ǻ� Ŭ����) --- ������, �ʵ�, �޼ҵ带 ������ �� �ִ�.
public class EnumDemo {
/*	
class Fruit	{
	public static final Fruit APPLE = new Fruit(); 		������ Ÿ���� Fruit���� ������ �� ���� ������ ���� �ٸ� ���� ������ �ִ�.
	public static final Fruit PEACH	= new Fruit();
	public static final Fruit BANANA = new Fruit();
}
*/		
	//���Ʒ� Ŭ������ �̳��� ���� ��ġ�Ѵ�.
	
enum Fruit {				//
	APPLE("red"), PEACH("pink"), BANANA("yellow");	//		(  "�Ű�����"  )
	private	String color;
	
	public String getColor() {
		return this.color;
	}
	
	Fruit(String color) {
		System.out.println("Call Constructor" + this);
		this.color = color;
	}
	
}
/*													Call Constructor
		������ �ɹ��� �ܼ��� ������		Call Constructor		-----�� ���� switch������ ������ ���̽��� �ϳ��� �����ϸ鼭 ������ ȣ���� �� ���ο� ��ü�� ����� ���� �����ڰ� ����ȴٴ� ���̴�.
													Call Constructor
													57kcal	
*/

enum Company {				//
	GOOGLE, APPLE, ORACLE
}
	
	public static void main(String[] args) {
		Fruit type = Fruit.APPLE;
		switch (type) {
		case APPLE:
			System.out.println(57 + "kcal, color " + Fruit.APPLE.getColor());
			break;
		case PEACH:
			System.out.println(34 + "kcal, color " + Fruit.PEACH.getColor());
			break;
		case BANANA:
			System.out.println(93 + "kcal, color " + Fruit.BANANA.getColor());
			break;
		}
		
		
		for (Fruit f : Fruit.values()) {		//������(enum)�� �������� ������ �ִ� �ʵ���� values()�� ����ؼ� ��� Ȯ���� �� �ִ�.
			System.out.println(f);
		}
	}

}
