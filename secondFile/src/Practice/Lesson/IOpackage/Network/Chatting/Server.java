package Practice.Lesson.IOpackage.Network.Chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	
	public void serverSetting() {
		try {			
			serverSocket = new ServerSocket(5001);
			System.out.println("Ŭ���̾�Ʈ ���� �����...");
			clientSocket = serverSocket.accept();
			System.out.println("Ŭ���̾�Ʈ ����");
		} catch (Exception e) {}
	}
	
	public void streamSetting() {
		try {
			dataInputStream = new DataInputStream(clientSocket.getInputStream());
			dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
		} catch (Exception e) {}
	}
	
	public void dataRecv() {
		new Thread(new Runnable() {
			boolean isThread = true;
			@Override
			public void run() {
				while (isThread) {
					try {
						String recvData = dataInputStream.readUTF();
						if (recvData.equals("/quit")) {					
							isThread = false;
						}else {							
							System.out.println("Ŭ���̾�Ʈ : " + recvData);
						}
					} catch (Exception e) {}
				}
			}
		}).start();
	}
	
	public void dataSend() {
		new Thread(new Runnable() {
			Scanner sc = new Scanner(System.in);
			@Override
			public void run() {
				boolean isThread = true;
				while (isThread) {					
					try {
						String sendData = sc.nextLine();
						if (sendData.equals("/quit")) {
							dataOutputStream.writeUTF("���沲�� ��ȭ�� �����Ͽ����ϴ�.");
							isThread = false;
						}else {
							dataOutputStream.writeUTF(sendData);							
						}
					} catch (Exception e) {}
				}
			}
		}).start();

	}
	
	public void closeAll() {
		try {
			serverSocket.close();
			clientSocket.close();
			dataInputStream.close();
			dataOutputStream.close();			
		} catch (Exception e) {}
	}
	
	public Server() {
		serverSetting();
		streamSetting();
		dataRecv();
		dataSend();
	}
	
	public static void main(String[] args) {
		new Server();
	}
}
