import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient{
    private Socket sock;
    private Scanner keyin;
    private Scanner in;
    private PrintWriter out;
    private Client client;
    private String name;

    public static final String SERVERADDR = "127.0.0.1";
    public static final int PORT = 8888;
    
    public ChatClient(){
        try {
            sock = new Socket(SERVERADDR, PORT);
            keyin = new Scanner(System.in);
            in = new Scanner(sock.getInputStream());
            out = new PrintWriter(sock.getOutputStream());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void print(String msg){
        out.print(msg);
        out.flush();
    }
    public void println(String msg){
        out.println(msg);
        out.flush();
    }
    public void go(){
        System.out.println("Connected... at "+sock.getInetAddress());
        System.out.print("Name : ");
        name = keyin.nextLine();
        println("["+name+"] Connected...");
        client = new Client(sock);
        client.start();
        
        boolean flag = true;
        while(flag){
            System.out.print("Message : ");
            println("["+name+"]"+keyin.nextLine());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new ChatClient().go();
    }
}