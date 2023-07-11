package RSP;

public class Dealer extends Player {
	private int rate;
	public Dealer() {
		super("Dealer", -1);
	}
	public String toString() {
		//return name+"["+this.hand+","+score+"]";
		return getName()+"["+getHand()+"]";
	}
}
