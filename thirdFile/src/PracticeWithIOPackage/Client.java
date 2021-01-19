package PracticeWithIOPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	private static final int PORT = 5001;
	
	public static void main(String[] args) throws IOException{		
		
		Socket socket = new Socket("localhost", PORT);
		BufferedReader input = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
		Scanner scan = new Scanner(System.in);
		System.out.println("Server connected");
		while (true) {
			String msg = scan.nextLine();
			output.println(msg);
			if (msg.equals("/quit")) {
				break;
			}
			System.out.println(" > Server : " + input.readLine());
		}
		System.out.println("Chat over");
		socket.close();
	}
}
