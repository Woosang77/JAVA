package PracticeWithIOPackage;

import java.io.IOException;
import java.net.ServerSocket;

public class ShareServer {

	public ShareServer() throws IOException{
		ServerSocket serverSocket = new ServerSocket(5001);
		while (true) {
			System.out.println("Waiting Client...");
			new ServSocket(serverSocket.accept()).start();
		}
	}
	
	public static void main(String[] args) throws IOException{
		new ShareServer();
	}
}
