package Practice.Lesson;

//�߻�ȭ�� �⺻������ ��Ӱ����Ͽ� �̷������. 
//����Ŭ���� �ɹ� �� �߻����� ������ �ɹ��� ����Ŭ������ �����ϸ� ������������ �����ؾ��ϴ� �ɹ��̴�.
//����Ŭ������ ��� �ɹ��� �߻�ȭ�� ������ �ʿ�� ������, �ϳ� �̻��� �ɹ��� �߻����� �����Ǹ� Ŭ������ �տ� abstract�� �ٴ´�.
//�������� ����Ŭ������ �������� ��� ������  ����Ŭ������ �ٸ� ���������� ���������� �������� �͵��� �ʼ������� ����

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
//����Ŭ���� 1 
class subClassPlus extends supClass {
	public void sum() {
		System.out.println("+ sum :" + (this.left + this.right));
	}
	public void avg() {
		System.out.println("+ avg :" + (this.left + this.right) / 2);
	}
}
//����Ŭ���� 2
class subClassMinus extends supClass {
	public void sum() {
		System.out.println("- sum :" + (this.left + this.right));
	}
	public void avg() {
		System.out.println("- avg :" + (this.left + this.right) / 2);
	}
}
//���� Ŭ����
public class abstraction {
	public static void main(String[] args) {
		//����1 ȣ��
		subClassPlus sbp = new subClassPlus();
		sbp.setOprands(10, 30);
		sbp.sum();
		sbp.avg();
	
		//����2 ȣ��
		subClassMinus sbm = new subClassMinus();
		sbm.setOprands(50, 60);
		sbm.sum();
		sbm.avg();
	}

}
