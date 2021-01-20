package Practice.Lesson.IOpackage.Network.UDPNetworking;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
/*
 * UDP수신자
 * 포트번호를 설정해 소켓을 열어둔다.
 * 수신자는 발신자가 보내는 DatagramPacket를 받기 위해 DatagramPacket를 만든다.
 * DatagramPacket(byte[int], int);
 * 		첫 번째 매개값 : 발신자 데이터를 받을 수 있는 바이트 배열
 * 		두 번째 매개값 : 발신자 데이터 배열에서 보내고자 하는 항목의 수, byte[].length이하로 설정 가능
 * DatagramSocket에서 DatagramPacket를 receive시키면서 발신자 데이터가 올 때까지 블로킹된다.
 */
public class UDPReceiveExample {
	public static void main(String[] args) throws Exception{
		DatagramSocket datagramSocket = new DatagramSocket(5001);
		
		while (true) {
			System.out.println("Ready to receive..");
			DatagramPacket packet = new DatagramPacket(
					new byte[100], 100);
			datagramSocket.receive(packet);
			String receiveMsg = new String(
					packet.getData(), 0, packet.getLength(), "UTF-8");
			if (receiveMsg.equals("/quit")) {
				System.out.println("3초 뒤 메세지가 종료됩니다.");
				break;
			}else {				
				System.out.println("받은 내용 : " + receiveMsg);
			}
		}
		Thread.sleep(3000);
		System.out.println("시스템 종료");
		datagramSocket.close();
		System.exit(0);
	}
}
