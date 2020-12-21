package Practice.Lesson.stream.introduce;

import java.util.Arrays;
import java.util.List;

public class MapAndReduceExample {

	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("ȫ�浿", 10),
				new Student("�ſ��", 20),
				new Student("���̼�", 30)
		);
		//�߰�ó�� : �л��� ������ ����
		//studentList.stream().mapToInt(s -> s.getScore());
		
		double avg = studentList.stream()	// --> �������� ��Ʈ�� : studentList�� ����� Student��ü�� ��ҷΰ����� ��Ʈ��
				
				.mapToInt(Student :: getScore)	// --> mapToInt�� �����ϴ� IntStream�� Student�� ������ ������, ������ ����� ��Ʈ��
																	//�Ķ���� Ÿ���� ToIntFunction�̱� ������ Int�� ���ϵǴ� �޼ҵ����Ѵ�.
		//����ó�� : ������ ��հ� ���				
				.average()		// ���� ��Ʈ���� �̿��ؼ� ��հ��� ���� �ɼų� ���� 
				.getAsDouble();
		
		System.out.println(avg); 
	}
 
}
