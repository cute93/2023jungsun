package Sock;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import kr.ms.ccma.Main;

public class Client {
	private Socket client;
	private Scanner in;
	public static final String serverAddr = "127.0.0.1";
	public Client() {
		// TODO Auto-generated constructor stub
		try {
			client = new Socket(serverAddr, Server.PORT);
			in = new Scanner(client.getInputStream());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void go() {
		String n;
		n = in.next();
		System.out.println("Server says "+n);
		
	}
	public static void main(String[] args) {
		new Client().go();
		
	}
	
}
