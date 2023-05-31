import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class LClient{
    private Socket sock;
    private PrintWriter out;
    private Scanner in;
    private Scanner keyin;

    public LClient(){
        try {
            this.sock = new Socket("127.0.0.1", 8888);
            this.out = new PrintWriter(this.sock.getOutputStream());
            this.in = new Scanner(this.sock.getInputStream());
            this.keyin = new Scanner(System.in);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        System.out.println("...: 1");
        this.out.println(5);
        int gn = this.in.nextInt();
        System.out.println(gn);
        String msg = this.in.nextLine();
        System.out.println("...: 2");
        System.out.println(msg);
        msg = this.in.nextLine();
        System.out.print(msg);
        msg = this.keyin.nextLine();
        this.out.println(msg);

        boolean flag = true;
        
    }
    public static void main(String[] args){
        new LClient().start();
    }
}