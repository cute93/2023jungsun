import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient extends Thread {
    private Scanner in;
    private PrintWriter out;
    private Socket client;
    public ChatClient(Socket sock){
        client = sock;
        try {
            in = new Scanner(client.getInputStream());
            out = new PrintWriter(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String listen(){
        return in.nextLine();
    }
    public void repeat(String msg){
        out.println(msg);
        out.flush();
    }
    public void run(){
        boolean flag = true;
        String msg;
        
        while(flag){
            msg = listen();
            System.out.println(msg);
            //repeat(msg);
            //System.out.println(msg=="exit");
            //System.out.println(msg.equals("exit"));
            
            if(msg.equals("exit")){
                System.out.println("Terminated....");
                repeat(msg);
                break;
            } 
        }
        in.close();
        out.close();
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
