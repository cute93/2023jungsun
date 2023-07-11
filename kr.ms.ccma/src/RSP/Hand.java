package RSP;

public class Hand {
	public int rsp;
	private final String SHOW[] = {"Scissors", "Rock", "Paper"};

	public Hand() {
		// TODO Auto-generated constructor stub
		this(0);
	}
	public Hand(int i) {
		// TODO Auto-generated constructor stub
		try {
			setRsp(i);
		} catch (RSPExeption e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			setRandomRsp();
		}
	}
	
	public String toString() {
		return SHOW[rsp];
	}
	
	public void setRsp(int rsp) throws RSPExeption{
		if(rsp<0) throw new RSPExeption();
		if(rsp>2) throw new RSPExeption();
		this.rsp = rsp;
	}
	public void setRandomRsp() {
		rsp = (int)(Math.random()*3);
	}
	public int game(Hand other) {
		int r = 0;
		if(this.rsp == other.rsp) r = 1;
		if(this.rsp == (other.rsp+1)%3) r = 2;
		if(this.rsp == (other.rsp+2)%3) r = 0;
		return r;
	}
}
