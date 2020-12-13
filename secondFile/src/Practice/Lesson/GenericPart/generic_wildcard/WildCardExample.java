package Practice.Lesson.GenericPart.generic_wildcard;

import java.util.Arrays;

public class WildCardExample {

	public static void registerCourse(Course<?> course) {
		System.out.println(course.getName() + "수강생" + Arrays.toString(course.getStudents()));
	}
	
	public static void registerCourseStudent (Course<? extends Student> course) {		//<? extends Student>는 상위 클래스 타입을 제한한다.
		System.out.println(course.getName() + "수강생" + Arrays.toString(course.getStudents()));
	}
	
	public static void registerCourseWorker (Course<? super Worker> course) {		//<? extends Student>는 하위 클래스 타입을 제한한다.
		System.out.println(course.getName() + "수강생" + Arrays.toString(course.getStudents()));
	}
	
	public static void main(String[] args) {
	
		Course<Person> personCourse = new Course<>("일반인 과정", 5);
		personCourse.add(new Person("일반인"));
		personCourse.add(new Person("직장인"));
		personCourse.add(new Person("학생"));
		personCourse.add(new Person("고등학생"));
		
		Course<Worker> workerCourse = new Course<>("직장인 과정", 5);
		workerCourse.add(new Worker("직장인"));
		
		Course<Student> studentCourse = new Course<>("학생과정", 5);
		studentCourse.add(new Student("학생"));
		studentCourse.add(new HighStudent("고등학생"));
		
		
		Course<HighStudent> highStudentCourse = new Course<>("고등학생과정", 5);
		highStudentCourse.add(new HighStudent("고등학생"));
		
		
		System.out.println();
		registerCourse(highStudentCourse);
		registerCourse(studentCourse);
		registerCourse(workerCourse);
		registerCourse(personCourse);
		// 와일드 카드 타입으로 <?>가 온다면 어떤 것이든 상관없이 가능하다. 
		
		System.out.println();
		registerCourseStudent(highStudentCourse);
		registerCourseStudent(studentCourse);
		//registerCourseStudent(workerCourse);
		//registerCourseStudent(personCourse);
		//아래의 두개는 에러가 발생한다. Student클래스 기준으로 상위 클래스들을 제한하기 때문에 Student나 그의 상속 클래스만 가능함
		
		
		System.out.println();
		registerCourseWorker(workerCourse);
		registerCourseWorker(personCourse);
		//registerCourseWorker(studentCourse);
		//registerCourseWorker(highStudentCourse);
		//아래의 두개는 에러가 발생한다. Worker클래스 기준으로 하위클래스를 제한하므로 Worker와 그의 부모 객체인 Person만 가능함
	}

}
