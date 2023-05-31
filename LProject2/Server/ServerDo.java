import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerDo extends Thread{
    Socket sock;
    public ServerDo(Socket client){
        sock = client;
    }
    @Override
    public void run() {
        System.out.println(sock.getInetAddress()+"에서 접속하였습니다..");
        PrintWriter out = null;
        Scanner in = null;
        boolean flag = true;
        try {
             out = new PrintWriter(sock.getOutputStream());
             in = new Scanner(sock.getInputStream());
             //out.println("[Server] Welcome to LServer...");
             //out.flush();
             while(flag){
                int n = in.nextInt();
                System.out.println("client command : "+n);
                if(n==1){
                    out.println((int)(Math.random()*45)+1);
                    out.flush();
                }else{
                    out.println(-1);
                    out.flush();
                    break;
                }
             }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        out.close();
        in.close();
        try {
            sock.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
