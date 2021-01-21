package PracticeWithIOPackage.UDPExample;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender {
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			DatagramSocket datagramSocket = new DatagramSocket();
			Scanner scan = new Scanner(System.in);
			String message;
			while (true){
				//send
				System.out.print("Write a message to send : ");
				message = scan.nextLine();
				byte[] buffer = message.getBytes();
				DatagramPacket packet = new DatagramPacket(
						buffer, buffer.length, address, 5001);
				datagramSocket.send(packet);
				
				//return Message
				byte[] recvBuffer = new byte[50];
				packet = new DatagramPacket(recvBuffer, recvBuffer.length);
				datagramSocket.receive(packet);
				String recvMsg = new String(recvBuffer, 0, packet.getLength());
				if (recvMsg.equals("/exit")) {
					System.out.println("System exit");
					break;
				}
				System.out.println("message received"
						+ "\n[Read] / [Skip]");
				String answer = scan.nextLine();
				if (answer.equals("read")) {
					System.out.println("> Receiver : " + recvMsg);
				} else{System.out.println("skip the message");}
			}
			
			scan.close();
			datagramSocket.close();
			System.exit(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
