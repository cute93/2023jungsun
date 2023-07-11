import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Chatting {
    ChatClient client;
    Socket sock;
    Scanner keyin;
    PrintWriter out;
    public Chatting(){
        try {
            sock = new Socket("127.0.0.1", 8888);
            keyin = new Scanner(System.in);
            out = new PrintWriter(sock.getOutputStream());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        boolean flag = true;
        System.out.println("::: Start in Chatting :::");
        client = new ChatClient(sock);
        client.start();
        while(flag){
            System.out.print("Message ::: ");
            String msg = keyin.nextLine();
            out.println(msg);
            out.flush();
            if(msg.equals("exit")){
                break;
            }
        }
        out.close();
        keyin.close();
        try {
            sock.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Chatting().start();
    }
}
