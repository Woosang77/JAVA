package PracticeWithIOPackage.Example1;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShareServer {
	
	ExecutorService pool = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors());
	HashMap<String, ServSocket> serverMap = 
			new HashMap<>();
	
	public ShareServer() throws IOException{
		ServerSocket serverSocket = new ServerSocket(5001);
		while (true) {
			System.out.println("Waiting Client...");
			ServSocket servSocket = new ServSocket(serverSocket.accept());
			pool.execute(servSocket);
			while (servSocket.clientName == null) {
				if (servSocket.clientName != null) {
					serverMap.put(servSocket.clientName, servSocket);
					System.out.println("해시맵에 저장완료 : " + serverMap.size());
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		new ShareServer();
	}
}
