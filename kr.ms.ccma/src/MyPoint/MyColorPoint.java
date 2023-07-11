package MyPoint;

public class MyColorPoint extends MyPoint {
	private String color;
	public MyColorPoint() {
		// TODO Auto-generated constructor stub
		super();
		color = "black";
	}
	public MyColorPoint(double x, double y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		color = "black";
	}
	public MyColorPoint(double x, double y, String color) {
		// TODO Auto-generated constructor stub
		super(x, y);
		this.color = color; 
	}
	public MyColorPoint(String color) {
		super();
		this.color = color;
	}
	
	public String toString() {
		double x = getX();
		double y = getY();
		if(isInt(x) && isInt(y))
			return "("+(int)x+", "+(int)y+" : "+this.color+")";
		if(isInt(x) && !isInt(y))
			return "("+(int)x+", "+String.format("%.2f", y)+" : "+this.color+")";
		if(!isInt(x) && isInt(y))
			return "("+String.format("%.2f", x)+", "+(int)y+" : "+this.color+")";
		return "("+String.format("%.2f", x)+", "+String.format("%.2f", y)+" : "+this.color+")";
	}
}
