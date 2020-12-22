package Practice.Lesson.stream.stream_aggregate;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {
	public static void main(String[] args) {
		/*
		 * Optional Ŭ������ ���� �����ϴ� �� ��� Ŭ�����̴�.
		 * ������δ� 
		 * - ����(�뷮�� �����͸� ������ ����ϴ� ������) ���� ����
		 * - ���� ���� ���� ��� ����Ʈ �� ����
		 * - ���� ���� ó���ϴ� Consumer ���
		 */
		
		List<Integer> list = new ArrayList<>();
		//list�� ��Ұ� ���� ������ ��հ��� ����. 
//		double avg = list.stream()
//			.mapToInt(Integer :: intValue)
//			.average()
//			.getAsDouble();
		//��� : java.util.NoSuchElementException �߻� (��Ұ� ����)
		//ó���ϴ� �������� ����ó���� ���� ��µ� �� �ִ� ��Ұ� �߰� ó������ �� �ɷ����� ���� �� �ִ�.
		//�׷��� ������ ��� ��Ұ� ��� ������ ���� �ȵȴ�.
		
		//��� 1	 : IF���� �߰��ؼ� ���ǿ� ��߳��� ������ 0.0���
		OptionalDouble optional = list.stream()
				.mapToInt(Integer :: intValue)
				.average();
		if (optional.isPresent()	) {
			System.out.println(optional.getAsDouble());
		}else {
			System.out.println(0.0);
		}
		
		//���2	 : orelse() �޼ҵ� ��� - ���� ���� �ִٸ� ���� ��������, ���ٸ� �Ű����� ���
		double avg = list.stream()
				.mapToInt(Integer :: intValue)
				.average()
				.orElse(0.0);
		//���������� average�� ���� ��µ� OptionalXXX�� getXXX���� ��ȯ �� ���������,
		//.orElse�� ���ϵ� avg���� �����ش�.
		System.out.println(avg);
		
		//���3 : .ifPresent�� ��� - ���� ���� ������ ���ٽĿ�  Consumer�� �ְ� �����ϰ� ���ٸ� ������ �Ѿ
		list.stream()
		.mapToInt(Integer :: intValue)
		.average()
		.ifPresent(n -> System.out.println(n));
		
		
	}
}
