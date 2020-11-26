package Practice.Lesson;

import java.util.Objects;

public class HashcodeExample {

	public static void main(String[] args) {
		Student s1 = new Student(1,  "홍길동"); 						// 해시코드 : 54151054		s1과 s2는 new로 생성된 다른 객체지만 hashCode와
		Student s2 = new Student(1, "홍길동");						// 해시코드 : 54151054		equals의 오버라이딩을 통해 같아진다.	 
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
		 * 논리적 동등비교를 위해서는 개발자가 원하는 부분을 동등비교를 해야하므로기존 API에서 제공하던 것을 사용하면 제한적이다.
		 * .hash(파라미터) 메소드는 파라미터들로 배열을 생성하고 Arrays.hashCode(Object[])를 호출해서 해시코드를 리턴한다.
		 * .hashCode()는 그렇게 만들어지 해시코드를 리턴한다.
		 * .hash()에 파라미터를 오버라이딩을 통해 우리가 원하는 맴버로 설정한다면, 객체마다 각기다른 해시값이 아니라 해당 맴버들이 같다면 같은 해시값을 갖게된다.
		*/
		@Override
		public int hashCode() {
			return Objects.hash(sno, name);
		}
		
		/*
		 * equals 또한 원래는 ==과 똑같고, 참조형타입은 주소값만을 비교하기 때문에 같은 정보를 가진 다른 객체면 false(원하지 않는 값)을 도출했다.
		 * 객체의 비교하고 싶은 맴버들을 개발자가 정하고 이에 맞게 오버라이딩을 해야한다.
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
