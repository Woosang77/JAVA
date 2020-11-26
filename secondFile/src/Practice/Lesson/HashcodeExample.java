package Practice.Lesson;

import java.util.Objects;

public class HashcodeExample {

	public static void main(String[] args) {
		Student s1 = new Student(1,  "ȫ�浿"); 						// �ؽ��ڵ� : 54151054		s1�� s2�� new�� ������ �ٸ� ��ü���� hashCode��
		Student s2 = new Student(1, "ȫ�浿");						// �ؽ��ڵ� : 54151054		equals�� �������̵��� ���� ��������.	 
		System.out.println(s1.hashCode());							
		System.out.println(Objects.hashCode(s2));
	}
	
	static class Student {
		int sno;
		String name;
		
		public Student(int sno, String name) {
			this.sno = sno;
			this.name = name;
		}			

		/*
		 * ���� ����񱳸� ���ؼ��� �����ڰ� ���ϴ� �κ��� ����񱳸� �ؾ��ϹǷα��� API���� �����ϴ� ���� ����ϸ� �������̴�.
		 * .hash(�Ķ����) �޼ҵ�� �Ķ���͵�� �迭�� �����ϰ� Arrays.hashCode(Object[])�� ȣ���ؼ� �ؽ��ڵ带 �����Ѵ�.
		 * .hashCode()�� �׷��� ������� �ؽ��ڵ带 �����Ѵ�.
		 * .hash()�� �Ķ���͸� �������̵��� ���� �츮�� ���ϴ� �ɹ��� �����Ѵٸ�, ��ü���� ����ٸ� �ؽð��� �ƴ϶� �ش� �ɹ����� ���ٸ� ���� �ؽð��� ���Եȴ�.
		*/
		@Override
		public int hashCode() {
			return Objects.hash(sno, name);
		}
		
		/*
		 * equals ���� ������ ==�� �Ȱ���, ������Ÿ���� �ּҰ����� ���ϱ� ������ ���� ������ ���� �ٸ� ��ü�� false(������ �ʴ� ��)�� �����ߴ�.
		 * ��ü�� ���ϰ� ���� �ɹ����� �����ڰ� ���ϰ� �̿� �°� �������̵��� �ؾ��Ѵ�.
		 */
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Student)	{
				Student s = (Student) obj;
				if(s.sno == this.sno) {
					if(s.name.equals(this.name)) {
						return true;
					}
				}
			}
			return false;
		} 
	}
	

}
