package PracticeWithIOPackage.UDPExample;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Receiver {
	
	public static void main(String[] args) {
		try {
			DatagramSocket datagramSocket = new DatagramSocket(5001);
			Scanner scan = new Scanner(System.in);
			while (true) {
				byte[] recvBuffer = new byte[50];
				DatagramPacket packet = new DatagramPacket(recvBuffer, recvBuffer.length);
				
				System.out.println("Ready to Receive...");
				datagramSocket.receive(packet);
				String recvMsg = new String(recvBuffer, 0, packet.getLength());
				if (recvMsg.equals("/exit")) {
					System.out.println("System exit");
					break;
				} else {System.out.println("> Sender : " + recvMsg);}
				
				System.out.print("Write a return Message : ");
				String answer = scan.nextLine();
				byte[] sendBuffer = answer.getBytes();
				InetAddress returnAddress = packet.getAddress();
				int port = packet.getPort();
				packet = new DatagramPacket(sendBuffer, sendBuffer.length, returnAddress, port);
				datagramSocket.send(packet);
				if (answer.equals("/exit")) {
					System.out.println("System exit");
					break;
				}
				System.out.println("answer sended");
			}
			datagramSocket.close();
			scan.close();
			System.exit(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
