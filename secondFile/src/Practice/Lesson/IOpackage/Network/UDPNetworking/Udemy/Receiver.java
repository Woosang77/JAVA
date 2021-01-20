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
				//�����ڿ� �߽��ڰ� ������� �ʾұ� ������ �����ڴ� �ٽ� ������ ���ؼ� 
				//�޾Ҵ� packet�� address�� port�� ���� �޾� packet�� ������Ѵ�.
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
