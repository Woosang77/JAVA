package Practice.Lesson.ThreadPart.Function.E05_stop;

public class PrintThread1 extends Thread	{
	//스레드를 종료하는 방법으로 stop()메소드가 있었는데, run()작동 중일 때 스레드가 갑자기 중지되면, 사용하던 파일이나 네트워크 연결과 같은 자원들이 
	//불안전한 상태로 남겨지기 때문에 deprecated되었다.
	
	//그래서 실행중에 동작정지를 시키기 위해서는 stop flag를 사용하여 정지한다.
	
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	@Override
	public void run() {
		//run()안에 stop(boolean)이 포함된 while문을 넣어두고, 메인스레드 start 후, 특정 조건이 맞는다면 stop boolean을 바꿔주면서 실행을 종료시킨다. 
		while (!stop) {
			System.out.println("실행중");
		}
		System.out.println("자원정리");
		System.out.println("실행 종료");
	}
}
