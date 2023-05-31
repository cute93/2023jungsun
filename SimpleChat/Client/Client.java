import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread{
    Socket client;
    Scanner in;
    String name;
    public Client(Socket sock) {
        client = sock;
        try {
            in = new Scanner(client.getInputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        name = "";
    }

    public String listen(){
        return in.nextLine();
    }

    public void run(){
        boolean flag = true;
        while(flag){
            System.out.println(listen());
        }
    }
}
