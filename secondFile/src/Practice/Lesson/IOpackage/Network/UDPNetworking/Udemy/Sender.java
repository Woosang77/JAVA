package Practice.Lesson.IOpackage.Network.UDPNetworking.Udemy;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender {
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			DatagramSocket datagramSocket = new DatagramSocket();
			
			Scanner scanner = new Scanner(System.in);
			String echoString;
			
			do {
				System.out.println("Enter string to be echoed : ");
				echoString = scanner.nextLine();
				
				byte[] buffer = echoString.getBytes();
				DatagramPacket packet = new DatagramPacket(
						buffer, buffer.length, address, 5000);
				datagramSocket.send(packet);
				
				byte[] buffer2 = new byte[50];
				packet = new DatagramPacket(buffer2, buffer2.length);
				datagramSocket.receive(packet);
				String msg = new String(buffer2, 0, packet.getLength());
				System.out.println(msg);
				
 			} while (!echoString.equals("exit"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
