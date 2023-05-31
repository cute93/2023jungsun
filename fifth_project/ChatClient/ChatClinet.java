import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class ChatClinet{
    private Socket client;
    public ChatClinet(){
        try {
            this.client = new Socket("127.0.0.1", 8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        Scanner keyin = new Scanner(System.in);
        PrintWriter netout = null;
        new Thread(new Runnable(){
            public void run() {
                Scanner netin = null;
                String netmsg = "";
                try {
                    netin = new Scanner(client.getInputStream());
                    netmsg = netin.next();
                    System.out.println(netmsg);

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    netin.close();
                }
            }
        }).start();
        try {
            netout = new PrintWriter(client.getOutputStream());
            boolean flag = true;
            String msg = "";
            while(flag){
                System.out.print("Message : ");
                msg = keyin.next();
                netout.println(msg);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            netout.close();
            keyin.close();

        }
       

    }
}