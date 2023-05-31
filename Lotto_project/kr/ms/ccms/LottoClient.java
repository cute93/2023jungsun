import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class LottoClient{
    private Socket sock;
    private Scanner in;
    private Scanner keyin;
    private PrintWriter out;
    
    public LottoClient(){
        try {
            this.sock = new Socket("127.0.0.1", LottoServer.PORT);
            this.in = new Scanner(sock.getInputStream());
            this.out = new PrintWriter(sock.getOutputStream());
            this.keyin = new Scanner(System.in);
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void start(){
        System.out.println("KeyInput Start");
        new Thread(new KeyInput()).start();
        boolean flag = true;
        int num = 0;
        System.out.println("Client start");
        while(flag){
            num = in.nextInt();
            System.out.println("Server says "+num);
            if(num==0) flag=false;
        }
    }

    public class KeyInput implements Runnable {

        @Override
        public void run() {
            boolean flag = true;
            int command = 0;
            while(flag){
                System.out.print("Command[Send(1), Exit(0)] : ");
                command = keyin.nextInt();
                if(command == 1){
                    out.println(command);
                }
                if(command == 0){
                    flag = false;
                }
            }
        }

    }
}