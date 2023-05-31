import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class LClient {
    private Socket sock;
    private PrintWriter out;
    private Scanner in;
    public LClient(){
        try {
            sock = new Socket("127.0.0.1", 8888);
            out = new PrintWriter(sock.getOutputStream());
            in = new Scanner(sock.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public void sendRequest(int command){
        out.println(command);
        out.flush();
    }

    public int getResponse(){
        int n =  in.nextInt();
        //System.out.println("[Server] "+n);
        return n;
    }

    public void start(){
        Scanner keyin = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.print("Command : ");
            int command = keyin.nextInt();
            sendRequest(command);
            int n = getResponse();
            System.out.println("[Server] " + n);
            if(n==-1) break;
        }
        finish();
    }

    void finish() {
        in.close();
        out.close();
        try {
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
   // public static void main(String[] args) {
    //    new LClient().start();
   // }

}
