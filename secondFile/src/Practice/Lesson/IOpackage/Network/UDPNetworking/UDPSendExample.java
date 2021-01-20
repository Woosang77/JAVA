package Practice.Lesson.IOpackage.Network.UDPNetworking;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class UDPSendExample {
	/*
	 * UDP 네트워크 : TCP와 달리 비연결적 네트워크
	 * TCP를 구현할 때는 서버 소켓과 클라이언트가 연결된 이후에 데이터 교환이 있었다면,
	 * UDP는 연결없이 보내기 때문에 속도는 TCP보다 빠르지만, 통신 선로가 비고정적이며 데이터 손실이 발생할 수 있다.
	 * 통신 선로가 비고정적이면, 먼저 보낸 패킷이 나중에 보낸 패킷보다 늦게 전달될 수도 있다.
	 * 
	 * UDP에서는 DatagramSocket과 DatagramPacket API를 제공한다.
	 * DatagramSocket은 DatagramPacket을 전달할 통로이다.
	 * DatagramPacket은 데이터와 수신자의 정보를 담고있다.
	 * DatagramPacket(보낼 데이터 byte[], 배열에서 보내고자 하는 항목의 수(length), 수신자 IP, Port가 있는 InetSocketAddress)
	 */
	public static void main(String[] args) throws Exception{
		DatagramSocket datagramSocket = new DatagramSocket();
		Scanner scan = new Scanner(System.in);
		while (true) {			
			System.out.print("발송할 메세지 : ");
			String msg = scan.nextLine();
			byte[] sendArr = msg.getBytes("UTF-8");
			DatagramPacket datagramPacket = new DatagramPacket(
					sendArr, sendArr.length, new InetSocketAddress("localhost", 5001));
			datagramSocket.send(datagramPacket);
			if (msg.equals("/quit")) {
				System.out.println("3초 뒤 메세지를 종료합니다.");
				break;
			}
		}
		Thread.sleep(3000);
		System.out.println("발신 종료");
		datagramSocket.close();
		System.exit(0);
		
	}
}
