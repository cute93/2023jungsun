import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatServer{
    private ServerSocket server;
    private ArrayList<PrintWriter> writers;

    public ChatServer(){
        try {
            server = new ServerSocket(8888);
            writers = new ArrayList<PrintWriter>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
       System.out.println("Chatting Server가 시작되었습니다.");
       while(true){
        try (Socket client = this.server.accept()) {
            System.out.println("클라이언트가 접속하였습니다.");
            PrintWriter temp = new PrintWriter(client.getOutputStream());
            this.writers.add(temp);
            System.out.println(writers.size()+"명 접속되었습니다..");
            new Thread(new Runnable(){
                public void run() {
                    Scanner in = null;
                    try {
                         in = new Scanner(client.getInputStream());
                    
                        while(true){
                            System.out.println("incomming...");
                            
                            String msg = in.nextLine();
                            for(PrintWriter p:writers){
                                p.println(msg);
                            }
                        }
                        

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        in.close();
                    }
                }

            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
       }
       

    }
}