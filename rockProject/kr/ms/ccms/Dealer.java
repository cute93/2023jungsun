package kr.ms.ccms;

public class Dealer extends Player {
    private double rate;
    public Dealer(){
        this("Dealer", 0.5);
    }
    public Dealer(double rate){
        this("Dealer", rate);
    }
    public Dealer(String name, double rate) {
        super(name);
        this.rate = rate;
    }
    public void setHand(Player other){
        if(Math.random()<this.rate){
            try {
                getHand().setRsp((other.getHand().getRsp()+2)%3);
            } catch (RSPException e) {
                e.println();
            }
        }else{
            int rsp = (int)(Math.random()*3);
            try {
                getHand().setRsp(rsp);
            } catch (RSPException e) {
                e.println();
            }
        }
        
    }
    
    
}
