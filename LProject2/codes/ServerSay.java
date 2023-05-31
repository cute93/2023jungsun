import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerSay implements java.lang.Runnable {
    private Socket sock;
    public ServerSay(Socket client) {
        this.sock = client;
    }
    @Override
    public void run() {
        boolean flag = true;
        int command = -1;
        int n = -1;
        try {
            PrintWriter out = new PrintWriter(this.sock.getOutputStream());
            Scanner in = new Scanner(this.sock.getInputStream());
            out.println("[Server]Welcome to LServer...");
            out.println("[Server]Name : ");
            String name = in.nextLine();
            System.out.println(name+"님이 접속하였습니다...");
            while(flag){
                command = in.nextInt();
                if(command == 1){
                    n = (int)(Math.random()*45)+1;
                    out.println(n);
                }
                if(command == 0){
                    flag = false;
                }
                System.out.println(name + " says " + command + " --  Response to " + n);
            }
            this.sock.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }

    
}
