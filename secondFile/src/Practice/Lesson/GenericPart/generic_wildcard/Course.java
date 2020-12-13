package Practice.Lesson.GenericPart.generic_wildcard;

public class Course <T>{
	private String name;
	private T[] students;
	
	public Course(String name, int capacity) {
		this.name = name;
		students = (T[])(new Object[capacity]);
		//students = new T[capacity]; 는 에러가 발생한다. 
		//T가 결정이 되지 않았는데 new를 통해 배열을 만들 수 없다.
		//Object로 만들고 강제 형변환을 해야한다.
		
	}
	
	public String getName() {return name;}
	public T[] getStudents()	{return students;}
	
	public void add(T t) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}
}
