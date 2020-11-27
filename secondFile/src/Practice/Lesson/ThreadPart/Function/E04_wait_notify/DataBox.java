package Practice.Lesson.ThreadPart.Function.E04_wait_notify;

public class DataBox {
	
	//Databox�� ������ü�� �����̴�. 
	//wait�� notify�� Thread Ŭ������ �޼ҵ尡 �ƴ϶�, Object Ŭ������ �޼ҵ��̹Ƿ� ������ü���� ȣ���� �����ϴ�.
	private String data;		//�⺻ data ���� null�̴�.
	
	public synchronized String getData() {		//wait�� notify�� ����ϴ� �޼ҵ�� �ݵ�� ����ȭ(synchronized)ó���� �Ǿ���Ѵ�.
		/*
		 * ������ ã�� �޼ҵ�(getData)�� producerThread�� ���� ���� �־��־��ٴ� �����Ͽ� ����ȴ�.
		 * �׷��� ������ data�� null���̶�� ����, ���� producerThread�� setData���� ���� ������(ConsumerThread�� ��� ������ or data�� �ʱⰪ)�̱� ������ 
		 * producerThread�� notify�� ��ٸ� �� �ְ� wait()�� ȣ���Ѵ�.
		 */
		if(data == null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		String getValue = data;
		System.out.println("ConsumerThread�� ������ ������ :" + getValue);
		data = null;		//data�� null�� �ƴ϶�� �����͸� ������ �� producerThread�� �ٽ� ���� �� �ְ� null�� �ٲ� ���´�.
		notify();			//�׸��� wait() ���� producerThread�� notify()�� ���� ���� ����Ų��.
		return getValue;
	}
	
	public synchronized void setData(String data) {
		/*
		 * �����͸� �־��ִ� �޼ҵ�(setData)�� data�� null�� ���� �����Ͽ� ����ȴ�.
		 * data�� null�� �ƴ϶�� ���� ���� ConsumerThread�� getData���� ���� ������(producerThread�� ��� �־���)�� ���ϱ� ������ 
		 * ConsumerThread�� notify�� ��ٸ� �� �ְ� wait()�� ȣ���Ѵ�.
		 */
		if (this.data != null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		this.data = data;	//data�� null�̶�� ConsumerThread�� ������ �Ŀ� null�� �ٲ���ų�, data�ʱⰪ�̹Ƿ� data�� �����Ѵ�.
		System.out.println("ProducerThread�� �Է��� ������ : " + data);
		notify();				//�׸��� wait()�� ���� �Ͻ� ������ �ִ� ConsumerThread�� ȣ���Ѵ�.
	}
	
}
