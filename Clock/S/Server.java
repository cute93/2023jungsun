import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Server{
    private ServerSocket server;
    private ArrayList<PrintWriter> outs;
    public Server(){
        try {
            server = new ServerSocket(8888);
            outs = new ArrayList<PrintWriter>();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        boolean flag = true;
        while(flag){
            try {
                Socket client = server.accept();
                PrintWriter temp = new PrintWriter(client.getOutputStream());
                Scanner tempin = new Scanner(client.getInputStream());
                outs.add(temp);
                ClientDo cd = new ClientDo(temp, tempin);
                cd.start();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
    }

    public class  ClientDo extends Thread{
        PrintWriter out;
        Scanner in;
        public ClientDo(PrintWriter temp, Scanner tempin) {
            out = temp;
            in = tempin;
        }
        private String listen(){
            return in.nextLine();
        }
        private void repeat(String msg){
            for(PrintWriter w:outs){
                w.println(msg);
                w.flush();
            }
            
        }
        public void run(){
            boolean flag = true;
            String msg;
            while(flag){
                msg = listen();
                System.out.println(msg);
                if(msg.equals("exit")){
                    outs.remove(out);
                    break;
                }
                repeat(msg);
            }
            out.close();
            in.close();
        }
    }

    public static void main(String[] args) {
        new Server().start();
    }

}