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
			//������ �׻� Ŭ���̾�Ʈ�� �����û�� ��ٷ����ؼ� ���ѷ����� ������.
			while (true) {
				System.out.println("���� ��ٸ�");
				Socket socket = serverSocket.accept();
				//accept()�� Client Socket���� ��û�� ���� ������ ����Ѵ�.
				InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("[���� ������]" + isa.getHostName());
				
				byte[ ] bytes = null;
				String message = null;
				int readByte;
				
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				readByte = is.read(bytes);
				message = new String(bytes, 0, readByte, "UTF-8");
				System.out.println("[������ ���� ����] : " + message);
				
				OutputStream os = socket.getOutputStream();
				message = "Hello Client, I'm Server";
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("[������ ���� ����]");
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
