package Practice.Lesson.IOpackage.Network.TCPNetworking.DataNetwork;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample {
	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket();
			System.out.println("[연결 요청]");
			socket.connect(new InetSocketAddress("localhost", 5001));		
			System.out.println("[연결 성공]");
			
			byte[] bytes = null;
			String message = null;
			int readByte;
			OutputStream os = socket.getOutputStream();
			message = "Hello Server, I'm Client";
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("[데이터 전송 성공]");
			
			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			readByte = is.read(bytes);
			message = new String(bytes, 0, readByte, "UTF-8");
			System.out.println("[데이터 수신 성공] : " + message);
			
			os.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (!socket.isClosed()) {
			try {
				socket.close();				
			} catch (Exception e) {
			}
		}
	}
}
