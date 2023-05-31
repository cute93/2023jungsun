package kr.ms.ccms;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NumberServer{
    ServerSocket server;
    public NumberServer(){
        try {
            server = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("서버생성에 오류가 발생했습니다...");
        }
    }
    public NumberServer(int port){
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("서버생성에 오류가 발생했습니다...");
        }
    }

    public void close(){
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("서버가 종료되었습니다...");
        }
    }

    public void run(){
        boolean flag = true;
        while(flag){
            try (Socket client = this.server.accept()) {
                System.out.println(client.getInetAddress()+"와 연결되었습니다...");
                PrintWriter writer = new PrintWriter(client.getOutputStream());
                int sendNumber = (int)(Math.random()*46); // 0부터 ~ 45까지의 정수발생..
                writer.println(sendNumber);
                if(sendNumber==0){
                    writer.println("Server is terminated....");
                    flag = false; 
                }
                writer.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("클라이언트와의 통신과정에서 오류가 발생했습니다...");
            } 
        }
        this.close();
    }

}