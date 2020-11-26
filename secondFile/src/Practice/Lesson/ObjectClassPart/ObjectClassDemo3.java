/*Clone : 복제 	-- 단순하게 생각해서 "우상"이라는 객체를 하나 더 만들면 되는거 아닌가 생각이 들수 있지만, 지금은 코드가 간단해서 그렇지 복잡한 코드를 복제하기에는 부적절하다.
 *clone() 또한 Object 소속 메소드이다.
 */
// public interface Cloneable {}		이것이 실제 인터페이스안에 내용이다. 강제로 구현해야하는 내용이 없지만 구현하는 이유는 student클래스가 복제가능하다는 것을 표시하는 것이다.

package Practice.Lesson.ObjectClassPart;
class NameStudent implements Cloneable {			//Student클래스가 Cloneable을 구현하고 있다.
	String name;
	NameStudent (String name) {
		this.name = name;
	}
	public Object clone() throws CloneNotSupportedException{
		return super.clone();					//clone()은 메소드 자체가 protected라서 오버라이딩을 할 때 super를 통해 상위클래스(Object)의 clone을 사용한다.
														//또한 clone()의 리턴 데이터 타입이 Object인 것을 고려해서 21번줄에서 studenT로 강제 형변환을 하였다.	
	}													//clone은 CloneNotSupportedException을 사용해야하는데 예외는 runtime의 하위오류가 아니라서 반드시 catch해야한다.
}
public class ObjectClassDemo3 {
	public static void main(String[] args) {
		NameStudent s1 = new NameStudent("우상");
		try {
			NameStudent s2 = (NameStudent)s1.clone();			
			System.out.println(s1.name);
			System.out.println(s2.name);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}	
	}
}
