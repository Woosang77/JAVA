package Practice.Lesson.stream.stream_pipelines;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Stream�� ���� ������ �������� ��Ҹ� �ݺ��ϸ鼭 ������(����ó��)�� �ϴ�  ���̴�.
 * ������ �� ���� ����ó���� �� ���� ��찡 ��κ��̴�. ����ϴ� ��ҵ� �߿� �ʿ��� �κи� ���� ����ϰų�, ����, ���͸� ���� �ִ�.
 * �̴� �߰� ó������ ó�� �� ���� ó������ ������ �Ѵ�.
 * ���� ���������� ���� ó�� �ܰ谡 ���۵��� �ʾҴٸ�, �߰� �ܰ�� �Ѿ�� �ʰ� �����ȴ�.
 * ���� ��� �������� ������, ���������� ����� ������ ���� Ʋ�� �ʴ� �����̴�.
 */

public class StreamPipeLinesExample {
	public static void main(String[] args) {
		//��Ʈ�� �ҽ� �÷��� ����
		List<Member>	list = Arrays.asList(
				new Member("ȫ�浿", Member.MALE,30),
				new Member("�質��", Member.FEMALE,20),
				new Member("����", Member.MALE,45),
				new Member("�ڼ���", Member.FEMALE,27)
		);
		//�⺻
		Stream<Member> stream = list.stream();	//�������� ��Ʈ��
		
		Stream<Member> mStream = stream.filter(m -> m.getSex() == Member.MALE);
		//�߰� ��Ʈ�� .filter�޼ҵ�� Predicate �Լ��� �������̽��� ����Ѵ�. �ռ� ������ ��ó�� Predicated�� �Ҹ������� ���ϵǴ� ���̴�.
		
		IntStream intStream = mStream.mapToInt(a -> a.getAge());
		//�߰� ��Ʈ�� .mapToInt()�� �Ű������� �޴� ��ҿ��� int�� �����Ͽ� IntStream�� �����Ѵ�.

		OptionalDouble optionalDouble = intStream.average();
		//�����ܰ� .average()�� intStream�� ��� ���� OptionalDoubleŸ������ �����Ѵ�.
		
		double ageAverage = optionalDouble.getAsDouble();
		//OptionalDouble�� ����ϱ� ���� Double�� ����  
		System.out.println(ageAverage);
		
		//����ȭ ����
		double ageAvg = list.stream()
		.filter(m -> m.getSex() == Member.MALE)
		.mapToInt(a -> a.getAge())
		.average()
		.getAsDouble();
		
		System.out.println(ageAvg);
	}
}
