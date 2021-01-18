package PracticeWithIOPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException{
				
		Socket client = new Socket("localhost", 5001);
		System.out.println("Server is Connected!!");
		DataInputStream in = new DataInputStream(client.getInputStream());
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
		Scanner scan = new Scanner(System.in);
		
		//Receiving
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						String msg = in.readUTF();
						if (msg.equals("/quit"))	break;
						else System.out.println("Server  : " + msg);
					}
				} catch (IOException e) {
					System.out.println("대화가 종료되었습니다.");
				}
				try {					
					in.close(); out.close(); 
				} catch (IOException e) {
				}
			}
		}).start();
				
		//Sending
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						String send = scan.nextLine();
						if (send.equals("/quit")) {
							System.out.println("상대방과 대화를 종료합니다.");
							break;
						}
						out.writeUTF(send);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				try {
					in.close(); out.close(); 
				} catch (IOException e) {
				}
			}
		}).start();
	}
}
