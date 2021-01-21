package PracticeWithIOPackage.Example2;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ReceiveDataThread implements Runnable{
	
	Socket client;
	BufferedReader ois;
	String receiveData;
	
	public ReceiveDataThread(Socket s, BufferedReader ois) {
		client = s;
		this.ois = ois;
	}
	
	@Override
	public void run() {
		try {
			while ((receiveData = ois.readLine()) != null) {
				System.out.println(receiveData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				client.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}