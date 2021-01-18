package PracticeWithIOPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShareServer {
	//자료 저장(자료 제목, 기안자)
	//접속자 확인
	private static ArrayList<ServSocket> connections = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		
		ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		Scanner scan = new Scanner(System.in);
		//서버 생성 및 바인딩
		ServerSocket server = new ServerSocket(5001);
		
		//클라이언트 지속적 리시브
		Runnable task = new Runnable() {			
			@Override
			public void run() {
				while (true) {
					System.out.println("Wait for connect....");
					try {
						Socket socket = server.accept();
						DataInputStream in = new DataInputStream(socket.getInputStream());
						DataOutputStream out = new DataOutputStream(socket.getOutputStream());
						out.writeUTF("What is your name to use?");
						String userName = in.readUTF();
						System.out.println("Connected with " + userName);
						out.writeUTF("Welcome " + userName);
						ServSocket servSocket = new ServSocket(socket, connections, userName);
						pool.execute(servSocket);
						connections.add(servSocket);			
						System.out.println(connections.size());
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
					
					}
				}
			}
		};
		pool.execute(task);
		
		
	}
}
