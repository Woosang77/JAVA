package Practice.Lesson.IOpackage.Network.UDPNetworking;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class UDPSendExample {
	/*
	 * UDP ��Ʈ��ũ : TCP�� �޸� �񿬰��� ��Ʈ��ũ
	 * TCP�� ������ ���� ���� ���ϰ� Ŭ���̾�Ʈ�� ����� ���Ŀ� ������ ��ȯ�� �־��ٸ�,
	 * UDP�� ������� ������ ������ �ӵ��� TCP���� ��������, ��� ���ΰ� ��������̸� ������ �ս��� �߻��� �� �ִ�.
	 * ��� ���ΰ� ��������̸�, ���� ���� ��Ŷ�� ���߿� ���� ��Ŷ���� �ʰ� ���޵� ���� �ִ�.
	 * 
	 * UDP������ DatagramSocket�� DatagramPacket API�� �����Ѵ�.
	 * DatagramSocket�� DatagramPacket�� ������ ����̴�.
	 * DatagramPacket�� �����Ϳ� �������� ������ ����ִ�.
	 * DatagramPacket(���� ������ byte[], �迭���� �������� �ϴ� �׸��� ��(length), ������ IP, Port�� �ִ� InetSocketAddress)
	 */
	public static void main(String[] args) throws Exception{
		DatagramSocket datagramSocket = new DatagramSocket();
		Scanner scan = new Scanner(System.in);
		while (true) {			
			System.out.print("�߼��� �޼��� : ");
			String msg = scan.nextLine();
			byte[] sendArr = msg.getBytes("UTF-8");
			DatagramPacket datagramPacket = new DatagramPacket(
					sendArr, sendArr.length, new InetSocketAddress("localhost", 5001));
			datagramSocket.send(datagramPacket);
			if (msg.equals("/quit")) {
				System.out.println("3�� �� �޼����� �����մϴ�.");
				break;
			}
		}
		Thread.sleep(3000);
		System.out.println("�߽� ����");
		datagramSocket.close();
		System.exit(0);
		
	}
}
