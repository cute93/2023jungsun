package RSP;

public class Player implements Comparable<Player> {
	private int score;
	private String name;
	private Hand hand;
	private final String GAME[] = {"lose", "draw", "win"};
	public Player() {
		this("Default Player");
	}
	public Player(String string) {
		// TODO Auto-generated constructor stub
		this(string, -1);
	}
	public Player(String string, int k) {
		name = string;
		hand = new Hand(k);
		score = 100;
	}
	public String toString() {
		return name+"["+this.hand+","+score+"]";
		//return name+"["+this.hand+"]";
	}
	public String game(Player other) {
		int r = this.hand.game(other.hand);
		if(r==0) this.score -= 10;
		if(r==1) this.score -= 5;
		if(r==2) this.score += 10;
		return GAME[r];
	}
	public String getName() {
		return name;
	}
	public Hand getHand() {
		return hand;
	}
	public void printScore() {
		// TODO Auto-generated method stub
		System.out.println(this.name+" : "+this.score);
		
	}
	@Override
	public int compareTo(Player o) {
		// TODO Auto-generated method stub
		return this.score - o.getScore();
	}
	private int getScore() {
		// TODO Auto-generated method stub
		return this.score;
	}

}
