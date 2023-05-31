import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
//import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Runnable;

public class LottoServer{
    public static final int PORT = 8888;
    private ServerSocket server;
    //private ArrayList<Socket> clients;
    public LottoServer(){
        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("ServerSocket생성에 실패하였습니다.. port : "+PORT);
            e.printStackTrace();
        }
    }

    public void start(){
        System.out.println("Server is started....");
        boolean flag = true;
        while(flag){
            try {
                Socket client = this.server.accept();
                new Thread(new ClientDo(client)).start();
                System.out.println("Client Connect..."+client.getInetAddress());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    private class ClientDo implements Runnable{
        private PrintWriter out;
        private Scanner in;
        private Socket sock;
        public ClientDo(Socket client) {
            this.sock = client;
            try {
                this.out = new PrintWriter(sock.getOutputStream(), true);
                this.in = new Scanner(sock.getInputStream());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            int command = -1;
            while(command != 0){
                command = in.nextInt();
                System.out.println("Client says "+command);
                int message = 0;
                if(command == 1){
                    message = (int)(Math.random()*45)+1;
                    out.println(message);
                }
                System.out.println("Client["+sock.getInetAddress()+"] : input("+command+") output("+message+")");
            }
            try {
                out.println(0);
                this.sock.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

   
/*
    public static void main(String[] args){
        new LottoServer().start();
    }
 */
}