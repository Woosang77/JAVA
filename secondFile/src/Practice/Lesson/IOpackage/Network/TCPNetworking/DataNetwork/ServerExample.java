package Practice.Lesson.IOpackage.Network.TCPNetworking.DataNetwork;

import java.io.InputStream;
import java.io.OutputStream;
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
				
				byte[ ] bytes = null; 
				String message = null;
				int readByte;
		 		
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				readByte = is.read(bytes);
				message = new String(bytes, 0, readByte, "UTF-8");
				System.out.println("[데이터 수신 성공] : " + message);
				
				OutputStream os = socket.getOutputStream();
				message = "Hello Client, I'm Server";
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("[데이터 전송 성공]");
				os.close();
				socket.close();
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
