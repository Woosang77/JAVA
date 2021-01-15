package Practice.Lesson.IOpackage.Network.Chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private Socket socket;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	
	public void connect() {
		try {
			socket = new Socket("localhost", 5001);
			System.out.println("���� ���� �Ϸ�");
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
							System.out.println("���� : " + recvData);
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
	
	public void streamSetting() {
		try {
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {}
	}
	
	public Client() {
		connect();
		streamSetting();
		dataSend();
		dataRecv();
	}
	
	public static void main(String[] args) {
		new Client();
	}
}
