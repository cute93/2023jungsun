import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LServer {
    ServerSocket server;
    public LServer(){
        try {
            server = new ServerSocket(8888);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void start(){
        Socket sock = null;
        boolean flag = true;
        System.out.println("Server Stated...");
        while(flag){
            try {
                sock = server.accept();
                System.out.println("Connect at "+sock.getInetAddress());
                ServerDo client = new ServerDo(sock);
                client.start();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new LServer().start();
    }
}
