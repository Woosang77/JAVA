/*Clone : ���� 	-- �ܼ��ϰ� �����ؼ� "���"�̶�� ��ü�� �ϳ� �� ����� �Ǵ°� �ƴѰ� ������ ��� ������, ������ �ڵ尡 �����ؼ� �׷��� ������ �ڵ带 �����ϱ⿡�� �������ϴ�.
 *clone() ���� Object �Ҽ� �޼ҵ��̴�.
 */
// public interface Cloneable {}		�̰��� ���� �������̽��ȿ� �����̴�. ������ �����ؾ��ϴ� ������ ������ �����ϴ� ������ studentŬ������ ���������ϴٴ� ���� ǥ���ϴ� ���̴�.

package Practice.Lesson.ObjectClassPart;
class NameStudent implements Cloneable {			//StudentŬ������ Cloneable�� �����ϰ� �ִ�.
	String name;
	NameStudent (String name) {
		this.name = name;
	}
	public Object clone() throws CloneNotSupportedException{
		return super.clone();					//clone()�� �޼ҵ� ��ü�� protected�� �������̵��� �� �� super�� ���� ����Ŭ����(Object)�� clone�� ����Ѵ�.
														//���� clone()�� ���� ������ Ÿ���� Object�� ���� ����ؼ� 21���ٿ��� studenT�� ���� ����ȯ�� �Ͽ���.	
	}													//clone�� CloneNotSupportedException�� ����ؾ��ϴµ� ���ܴ� runtime�� ���������� �ƴ϶� �ݵ�� catch�ؾ��Ѵ�.
}
public class ObjectClassDemo3 {
	public static void main(String[] args) {
		NameStudent s1 = new NameStudent("���");
		try {
			NameStudent s2 = (NameStudent)s1.clone();			
			System.out.println(s1.name);
			System.out.println(s2.name);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}	
	}
}
