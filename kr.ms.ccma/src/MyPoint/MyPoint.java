package MyPoint;

public class MyPoint {
	private double x, y;
	public MyPoint() {
		setPoint(0.0, 0.0);
	}
	public MyPoint(double x1, double y1) {
		setPoint(x1, y1);
	}
	public void setPoint(double x, double y) {
		setX(x);
		setY(y);
	}
	public boolean isInt(double x) {
		return x == (int)x;
	}
	public String toString() {
		if(isInt(x) && isInt(y))
			return "("+(int)x+", "+(int)y+")";
		if(isInt(x) && !isInt(y))
			return "("+(int)x+", "+String.format("%.2f", y)+")";
		if(!isInt(x) && isInt(y))
			return "("+String.format("%.2f", x)+", "+(int)y+")";
		return "("+String.format("%.2f", x)+", "+String.format("%.2f", y)+")";
		
	}
	public void print() {
		System.out.print(this);
	}
	public void println() {
		print();
		System.out.println();
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setX(double x) {
		if(x<0) x = 0;
		if(x>100) x = 100;
		this.x = x;
	}
	public void setY(double y) {
		if(y<0) y = 0;
		if(y>100) y=100;
		this.y = y;
	}
	public void move() {
		setX(0);
		setY(0);
	}
	public void move(double x, double y) {
		setX(x);
		setY(y);
	}
	public double distance() {
		return distance(new MyPoint(0,0));
	}
	public double distance(MyPoint p) {
		double r = Math.sqrt(Math.pow(p.getX()-x,2)+Math.pow(p.getY()-y,2));
		//System.out.println(r);
		return r;
	}
}
