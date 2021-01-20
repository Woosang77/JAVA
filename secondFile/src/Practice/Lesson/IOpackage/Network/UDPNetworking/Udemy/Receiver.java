package Practice.Lesson.IOpackage.Network.UDPNetworking.Udemy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Receiver {

	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(5000);
			
			while (true) {
				byte[] buffer = new byte[50];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
				String senderMsg = new String(buffer, 0, packet.getLength());
				System.out.println("Sender said : " + senderMsg);
				
				String returnMsg = "Sender : " + senderMsg;
				byte[] buffer2 = returnMsg.getBytes();
				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				//수신자와 발신자가 연결되지 않았기 때문에 수신자는 다시 보내기 위해서 
				//받았던 packet의 address와 port를 리턴 받아 packet을 재생성한다.
				packet = new DatagramPacket(buffer2, buffer2.length, address, port);
				socket.send(packet);
			}
		} catch (SocketException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
