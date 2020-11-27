package Practice.Lesson.ThreadPart.Function.E04_wait_notify;

public class DataBox {
	
	//Databox는 공유객체의 역할이다. 
	//wait과 notify는 Thread 클래스의 메소드가 아니라, Object 클래스의 메소드이므로 공유객체에서 호출이 가능하다.
	private String data;		//기본 data 값은 null이다.
	
	public synchronized String getData() {		//wait과 notify를 사용하는 메소드는 반드시 동기화(synchronized)처리가 되어야한다.
		/*
		 * 데이터 찾는 메소드(getData)는 producerThread가 먼저 값을 넣어주었다는 전제하에 실행된다.
		 * 그렇기 때문에 data가 null값이라는 뜻은, 아직 producerThread가 setData하지 않은 데이터(ConsumerThread가 방금 가져감 or data의 초기값)이기 때문에 
		 * producerThread의 notify를 기다릴 수 있게 wait()를 호출한다.
		 */
		if(data == null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		String getValue = data;
		System.out.println("ConsumerThread가 가져온 데이터 :" + getValue);
		data = null;		//data가 null이 아니라면 데이터를 가져간 후 producerThread가 다시 넣을 수 있게 null로 바꿔 놓는다.
		notify();			//그리고 wait() 중인 producerThread를 notify()를 통해 실행 대기시킨다.
		return getValue;
	}
	
	public synchronized void setData(String data) {
		/*
		 * 데이터를 넣어주는 메소드(setData)는 data가 null인 것을 전제하에 실행된다.
		 * data가 null이 아니라는 뜻은 아직 ConsumerThread가 getData하지 않은 데이터(producerThread가 방금 넣었음)를 뜻하기 때문에 
		 * ConsumerThread의 notify를 기다릴 수 있게 wait()를 호출한다.
		 */
		if (this.data != null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		this.data = data;	//data가 null이라면 ConsumerThread가 가져간 후에 null로 바꿔놨거나, data초기값이므로 data를 설정한다.
		System.out.println("ProducerThread가 입력한 데이터 : " + data);
		notify();				//그리고 wait()를 통해 일시 정지에 있는 ConsumerThread를 호출한다.
	}
	
}
