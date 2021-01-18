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
	//�ڷ� ����(�ڷ� ����, �����)
	//������ Ȯ��
	private static ArrayList<ServSocket> connections = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		
		ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		Scanner scan = new Scanner(System.in);
		//���� ���� �� ���ε�
		ServerSocket server = new ServerSocket(5001);
		
		//Ŭ���̾�Ʈ ������ ���ú�
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
