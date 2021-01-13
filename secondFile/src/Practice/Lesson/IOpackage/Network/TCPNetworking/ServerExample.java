package Practice.Lesson.IOpackage.Network.TCPNetworking;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {			
			serverSocket = new ServerSocket(5001);
			//서버는 항상 클라이언트의 연결요청을 기다려야해서 무한루프를 돌린다.
			while (true) {
				System.out.println("연결 기다림");
				Socket socket = serverSocket.accept();
				//accept()는 Client Socket에서 요청이 오기 전까지 대기한다.
				InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("[연결 수락함]" + isa.getHostName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (!serverSocket.isClosed()) {
			try {				
				serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
