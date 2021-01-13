package Practice.Lesson.IOpackage.Network.TCPNetworking;

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
