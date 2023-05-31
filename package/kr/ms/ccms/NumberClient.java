package kr.ms.ccms;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class NumberClient{
    private Socket client;
    public NumberClient(){
        try {
            client = new Socket("127.0.0.1", 8888);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("서버와의 연결에 오류가 발생했습니다..");
        }
    }
    public void run(){
        try (Scanner sc = new Scanner(this.client.getInputStream())) {
            System.out.println(sc.nextInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}