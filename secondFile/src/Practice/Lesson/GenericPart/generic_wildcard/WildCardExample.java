package Practice.Lesson.GenericPart.generic_wildcard;

import java.util.Arrays;

public class WildCardExample {

	public static void registerCourse(Course<?> course) {
		System.out.println(course.getName() + "������" + Arrays.toString(course.getStudents()));
	}
	
	public static void registerCourseStudent (Course<? extends Student> course) {		//<? extends Student>�� ���� Ŭ���� Ÿ���� �����Ѵ�.
		System.out.println(course.getName() + "������" + Arrays.toString(course.getStudents()));
	}
	
	public static void registerCourseWorker (Course<? super Worker> course) {		//<? extends Student>�� ���� Ŭ���� Ÿ���� �����Ѵ�.
		System.out.println(course.getName() + "������" + Arrays.toString(course.getStudents()));
	}
	
	public static void main(String[] args) {
	
		Course<Person> personCourse = new Course<>("�Ϲ��� ����", 5);
		personCourse.add(new Person("�Ϲ���"));
		personCourse.add(new Person("������"));
		personCourse.add(new Person("�л�"));
		personCourse.add(new Person("����л�"));
		
		Course<Worker> workerCourse = new Course<>("������ ����", 5);
		workerCourse.add(new Worker("������"));
		
		Course<Student> studentCourse = new Course<>("�л�����", 5);
		studentCourse.add(new Student("�л�"));
		studentCourse.add(new HighStudent("����л�"));
		
		
		Course<HighStudent> highStudentCourse = new Course<>("����л�����", 5);
		highStudentCourse.add(new HighStudent("����л�"));
		
		
		System.out.println();
		registerCourse(highStudentCourse);
		registerCourse(studentCourse);
		registerCourse(workerCourse);
		registerCourse(personCourse);
		// ���ϵ� ī�� Ÿ������ <?>�� �´ٸ� � ���̵� ������� �����ϴ�. 
		
		System.out.println();
		registerCourseStudent(highStudentCourse);
		registerCourseStudent(studentCourse);
		//registerCourseStudent(workerCourse);
		//registerCourseStudent(personCourse);
		//�Ʒ��� �ΰ��� ������ �߻��Ѵ�. StudentŬ���� �������� ���� Ŭ�������� �����ϱ� ������ Student�� ���� ��� Ŭ������ ������
		
		
		System.out.println();
		registerCourseWorker(workerCourse);
		registerCourseWorker(personCourse);
		//registerCourseWorker(studentCourse);
		//registerCourseWorker(highStudentCourse);
		//�Ʒ��� �ΰ��� ������ �߻��Ѵ�. WorkerŬ���� �������� ����Ŭ������ �����ϹǷ� Worker�� ���� �θ� ��ü�� Person�� ������
	}

}
