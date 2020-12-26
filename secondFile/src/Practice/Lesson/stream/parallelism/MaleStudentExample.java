package Practice.Lesson.stream.parallelism;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MaleStudentExample {
	public static void main(String[] args) {
		List<Student> totalList = Arrays.asList(
				new Student("ȫ�浿", 10, Student.Sex.MALE),
				new Student("�����", 6, Student.Sex.FEMALE),
				new Student("����", 10, Student.Sex.MALE),
				new Student("�����", 6, Student.Sex.FEMALE)
		);
		//����
//		Stream<Student> totalStream = totalList.stream();
//		//�������� ��Ʈ�� ����
//		
//		Stream<Student> maleStream = totalStream.filter(s -> s.getSex() == Student.Sex.MALE);
//		//�������� ��Ʈ������ ���� ���͸��� ���� ���ڽ�Ʈ�� ����
//		
//		Supplier<MaleStudent> supplier = () -> new MaleStudent();
//		//collect()�� ���� ù ��° supplier ����( ����� ���� �����̳�)
//		BiConsumer<MaleStudent, Student> accumulator = (r, t) -> r.accumulate(t);
//		//�� ��° Biconsumer�� ���� ����
//		BiConsumer<MaleStudent, MaleStudent> combiner = (r1, r2) -> r1.combine(r2);
//		//��Ƽ �����忡�� �����۾��� ���� MaleStudent���� �Ѱ����� ����ִ� Bicomsumer
//		//�̱� �����忡���� ���� ������, �� ������ ������ �ȵ�
//		
//		MaleStudent maleStudent2 = maleStream.collect(supplier, accumulator, combiner);
//		//�� ���� �� ��������ϱ� ���� collect ���� --> ����ڰ� ���ϴ� ��� �����̳ʸ� �����ϰ� ��Ҹ� �����ߴ�.
//		
//		maleStudent2.getList().stream()
//		.forEach(s -> System.out.println(s.getName()));
//		
//		System.out.println();
//		
		
		//����ȭ
		MaleStudent maleStudent = totalList.parallelStream()
			.filter(s -> s.getSex() == Student.Sex.MALE)
			//����� �����̳ʿ� ����
			.collect(
					() -> new MaleStudent(),		//����� ���� �����̳ʸ� ����   �� Supplier(�Ű��� ���� ���ϰ�����)
					(r, t) -> r.accumulate(t),		//BiConsumer  r�� ����� �����ߴ� �����̳�, t�� ���͸��� ��� �ϳ� r�� t�� ������Ű�ڴٴ� ��
					(r1,r2) -> r1.combine(r2));	//����ó������ �����̳� �ΰ��� ����
		maleStudent.getList().stream()
			.forEach(s -> System.out.println(s.getName()));
		
		
		//���� ����ȭ �ϴ� ���
//		MaleStudent maleStudent3 = totalList.stream()
//				.filter(s -> s.getSex() == Student.Sex.MALE)
//				.collect(MaleStudent :: new, MaleStudent :: accumulate, MaleStudent :: combine);
//		 
//		maleStudent3.getList().stream()
//			.forEach(s -> System.out.println(s.getName()));
		
		
		
	}
}
