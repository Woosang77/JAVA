package PracticeWithIOPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServSocket implements Runnable {
	Socket socket;
	ArrayList<ServSocket> connections;
	String userName;
	DataInputStream in;
	DataOutputStream out;
	
	public ServSocket(Socket socket, ArrayList<ServSocket> connections, String userName) throws IOException{
		this.socket = socket;
		this.connections = connections;
		this.userName = userName;
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
	}
	
	@Override
	public void run() {
		try {			
			out.writeUTF("\n ������ Ȯ�� : /check \n	�ڷ����� : /save \n	���� : /quit");
			out.flush();
			while (true) {
				String msg = in.readUTF();
				if (msg.equals("/check")) {
					//������ �����ֱ�
				}else if (msg.equals("/save")) {
					//����� �ڷ� �����ֱ�
				}else if(msg.equals("/quit")) {
					break;
				}else System.out.println(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {}
		}
		
	}
}
