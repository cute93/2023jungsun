import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Main{
    public static void main(String[] args) {
        Runnable10 a = new Runnable10("Runnables.. ");
        Thread t1 = new Thread(a);
        t1.start();
    }
}