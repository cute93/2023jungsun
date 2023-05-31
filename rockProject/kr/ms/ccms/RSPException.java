package kr.ms.ccms;

public class RSPException extends Exception{
    public RSPException(){
        super();
    }
    public void println(){
        System.out.println("0과 3사이의 숫자로 조정됩니다..");
    }
}
