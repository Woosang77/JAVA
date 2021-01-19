package PracticeWithIOPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServSocket extends Thread {
	
	Socket socket;
	BufferedReader input;
	PrintWriter output;
	
	public ServSocket(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("Client connected");
			input = new BufferedReader(new InputStreamReader(
					this.socket.getInputStream()));
			output = new PrintWriter(this.socket.getOutputStream(), true);
			while (true) {
				String inputMsg = input.readLine();
				if (inputMsg.equals("/quit")) {
					System.out.println("Chat over");
					break;
				}
				System.out.println(" > Client : " + inputMsg);
				output.println(inputMsg);				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();				
			} catch (IOException e2) {
				System.out.println(e2.getStackTrace());
			}
		}
	}
}
