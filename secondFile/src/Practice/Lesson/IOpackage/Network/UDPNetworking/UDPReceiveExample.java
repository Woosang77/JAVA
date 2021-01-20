package Practice.Lesson.IOpackage.Network.UDPNetworking;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
/*
 * UDP������
 * ��Ʈ��ȣ�� ������ ������ ����д�.
 * �����ڴ� �߽��ڰ� ������ DatagramPacket�� �ޱ� ���� DatagramPacket�� �����.
 * DatagramPacket(byte[int], int);
 * 		ù ��° �Ű��� : �߽��� �����͸� ���� �� �ִ� ����Ʈ �迭
 * 		�� ��° �Ű��� : �߽��� ������ �迭���� �������� �ϴ� �׸��� ��, byte[].length���Ϸ� ���� ����
 * DatagramSocket���� DatagramPacket�� receive��Ű�鼭 �߽��� �����Ͱ� �� ������ ���ŷ�ȴ�.
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
				System.out.println("3�� �� �޼����� ����˴ϴ�.");
				break;
			}else {				
				System.out.println("���� ���� : " + receiveMsg);
			}
		}
		Thread.sleep(3000);
		System.out.println("�ý��� ����");
		datagramSocket.close();
		System.exit(0);
	}
}
