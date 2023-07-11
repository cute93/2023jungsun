package Line;
import MyPoint.MyPoint;

public class Line {
	private MyPoint s;
	private MyPoint e;
	private double len;
	public Line() {
		this(0,0,0,0);
	}
	public Line(MyPoint p1, MyPoint p2) {
		this.s = p1;
		this.e = p2;
		len = p1.distance(p2);
	}
	public Line(double x1, double y1, double x2, double y2) {
		this(new MyPoint(x1, y1), new MyPoint(x2, y2));
	}
	
	public String toString() {
		return s.toString()+"=>"+e.toString()+ " : " +this.len+"cm";
	}
	public void print() {
		System.out.print(this);
	}
	public void println() {
		print();
		System.out.println();
	}
}
