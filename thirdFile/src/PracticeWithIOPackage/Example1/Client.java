package PracticeWithIOPackage.Example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	private static final int PORT = 5001;
	String name;
	Socket socket;
	Scanner scan = new Scanner(System.in);
	
	public Client() throws IOException{
		System.out.print("What's your name? : "); 
		name = scan.nextLine();
		socket = new Socket("localhost", PORT);
		BufferedReader input = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
		System.out.println("Server connected");
		output.println(name);
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
	
	public static void main(String[] args) throws IOException{
		new Client();
	}
}
