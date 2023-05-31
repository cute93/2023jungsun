
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int k = 12;
       int n = 0;
       int result = 0;
       try{
             n = sc.nextInt();
             result = k/n;
       }catch(Exception e){
            System.out.println("0으로는 나누어질 수 없습니다... 입력값을 1로 변환합니다..");
            n = 1;
            result = k;
       }finally{
            System.out.println(k+"를 "+n+"으로 나눈 몫은 "+result+"이다.");
       }
       sc.close();
    }
}
