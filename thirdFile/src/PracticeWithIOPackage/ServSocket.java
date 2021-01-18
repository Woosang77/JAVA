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
			out.writeUTF("\n 접속자 확인 : /check \n	자료저장 : /save \n	종료 : /quit");
			out.flush();
			while (true) {
				String msg = in.readUTF();
				if (msg.equals("/check")) {
					//접속자 보여주기
				}else if (msg.equals("/save")) {
					//저장된 자료 보여주기
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
