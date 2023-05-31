import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class LServer{
    public static final int PORT = 8888;
    private ServerSocket server;
    public LServer(){
        try {
            this.server = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("Server생성에 실패하였습니다..");
            e.printStackTrace();
        }
    }
    
    public void start(){
        System.out.println("Server stared!!!!");
        boolean flag = true;
        try {
            while(flag){
                Socket client = this.server.accept();
                System.out.println(client.getInetAddress()+"에서 접속하였습니다...");
                ServerDo doit = new ServerDo(client);
                
                doit.start();
                
            }
        } catch (IOException e) {
            System.out.println("클라이언트가 접속하는 과정에서 오류가 발생했습니다...");
            flag = false;
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new LServer().start();
    }
}