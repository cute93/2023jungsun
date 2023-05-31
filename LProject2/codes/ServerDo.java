import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerDo extends Thread{
    private Socket sock;
    public ServerDo(Socket client){
        this.sock = client;
        System.out.println("client생성");
    }
    public void run(){
        System.out.println("started..");
        boolean flag = true;
        PrintWriter out = null;
        Scanner in = null;
        int command = -1;
        int n = -1;
        try { 
            System.out.println("PrintWriter생성");
            out = new PrintWriter(this.sock.getOutputStream());
            in = new Scanner(this.sock.getInputStream());
            System.out.println("[Server]Welcome to LServer...");
            System.out.println(in.nextInt());
            out.println(5);
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
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            out.close();
            in.close();
        }
    }
}
