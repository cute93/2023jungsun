import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatServer{
    private ServerSocket server;
    private ArrayList<Client> clients;
    public static final String SERVERADDR = "127.0.0.1";
    public static final int PORT = 8888;

    public ChatServer(){
        try {
            server = new ServerSocket(PORT);
            clients = new ArrayList<Client>();
        } catch (IOException e) {
            System.out.println("Server 생성오류!!");
            e.printStackTrace();
        }
    }
    public void go(){
        boolean flag = true;
        System.out.println("Server 시작!!!");
        while(flag){
            try {
                Socket temp = server.accept();
                Client client = new Client(temp);
                clients.add(client);
                client.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private class Client extends Thread{
        private Socket sock;
        private PrintWriter out;
        private Scanner in;
        public Client(Socket temp) {
            sock = temp;
            try {
                out = new PrintWriter(sock.getOutputStream()); 
                in = new Scanner(sock.getInputStream());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        public void run(){
            boolean flag = true;
            String msg = "";
            while(flag){
                msg = listen();
                System.out.println(msg);
                for(Client c : clients){
                    c.println(msg);
                }
            }
        }
        private String listen(){
            return in.nextLine();
        }
        private void println(String msg){
            //System.out.println(msg);
            out.println(msg);
            out.flush();
        }
        
    }

    public static void main(String[] args) {
        new ChatServer().go();
    }
}