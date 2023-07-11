package Sock;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket server;
	private Socket client;
	private PrintWriter out;
	public static final int PORT = 9898;
	public Server() {
		try {
			server = new ServerSocket(PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Start Server port at "+PORT);
	}
	public void go() {
		try {
			while(true) {
				client = server.accept();
				System.out.println(client.getInetAddress()+" connected...");
				out = new PrintWriter(client.getOutputStream());
				out.println((int)(Math.random()*45));
				out.flush();	
			}
			
			//System.out.println("....");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
