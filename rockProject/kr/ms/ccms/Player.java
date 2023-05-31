package kr.ms.ccms;

public class Player {
    private Hand hand;
    private String name;
    private int score;
    public Player(){
        this(new Hand(0), "default player", 0);
    }
    public Player(String name) {
        this(new Hand(0), name, 0);
    }
    public Player(Hand hand, String name) {
        this(hand, name, 0);
    }
    public Player(Hand hand, String name, int score) {
        this.hand = hand;
        this.name = name;
        this.score = score;
    }
    public String toString(){
        return "["+this.name+" set "+this.hand.toString()+"]";
    }
    public void print(){
        System.out.print(this);
    }
    public void println(){
        this.print();
        System.out.println();
    }
    public String getName() {
        return name;
    }
    public Hand getHand() {
        return this.hand;
    }
    public int match(Player other){
        return this.hand.match(other.getHand());

    }
    public void setHand(){
        int rsp = (int)(Math.random()*3);
        try {
            this.hand.setRsp(rsp);
        } catch (RSPException e) {
            e.println();
        }
    }
    public void printMatch(Player other){
        this.print();
        String matchResult = "";
        switch(this.match(other)){
            case -1 : matchResult = "lose";
                this.score -= 10;
            break;
            case 0 : matchResult = "draw";
                this.score -= 5;
            break;
            case 1 : matchResult = "win";
                this.score += 10;
            break;
        }
        System.out.print(" "+matchResult+" ");
        other.println();
    }
    public int getScore() {
        return score;
    }
}
