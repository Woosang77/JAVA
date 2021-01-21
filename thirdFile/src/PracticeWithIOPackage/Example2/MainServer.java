package PracticeWithIOPackage.Example2;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class MainServer {
	int port = 7777;
	ServerSocket server = null;
	Socket child = null;
	
	HashMap<String, PrintWriter> hm;
	
	public MainServer() {
		ChatSverThread sr;
		Thread thread;
		
		try {
			server = new ServerSocket(port);
			System.out.println("*************************************");
			System.out.println("*                   채팅서버                        *");
			System.out.println("*************************************");
			System.out.println("클라이언트의 접속을 기다립니다.");
			
			hm = new HashMap<>();
			
			while (true) {
				child = server.accept();
				if (child != null) {
					sr = new ChatSverThread(child, hm);
					thread = new Thread(sr);
					thread.start();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MainServer();
	}
}
