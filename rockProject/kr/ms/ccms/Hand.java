package kr.ms.ccms;

public class Hand {
    public int rsp;
    public static String[] SHOW = {"ROCK", "SCISSORS", "PAPER"};
    public String toString(){
        return "["+SHOW[this.rsp]+"]";
    }
    public void print(){
        System.out.print(this);
    }
    public void println(){
        this.print();
        System.out.println();
    }


    public Hand(){
        this(0);
    }
    public Hand(int i) {
        try {
            setRsp(i);
        } catch (RSPException e) {
           // e.printStackTrace();
            e.println();

        } finally {
            this.adjust(i);
        }
    }
    private void adjust(int i) {
        this.rsp = Math.abs(i)%3;
    }

    public void setRsp(int i) throws RSPException {
        if(i<0) throw new RSPException();
        if(i>3) throw new RSPException();
        this.rsp = i;
    }
    
    public int getRsp() {
        return rsp;
    } 

    public int match(int o){
        int rtn = 0;
        if(this.rsp == o) rtn = 0;
        if((this.rsp+1)%3 == o) rtn = 1;
        if((this.rsp+2)%3 == o) rtn = -1;
        return rtn;
    }
    public int match(Hand other){
        return this.match(other.getRsp());
    }
    
}
