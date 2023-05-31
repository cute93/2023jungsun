public class MyPoint{
    private double x;
    private double y;

    
    public double distance(double x, double y){
        return Math.sqrt(Math.pow((x-this.x),2)+Math.pow((y-this.y),2));
    }
    public double distance(){
        return this.distance(0, 0);
    }
    public double distance(MyPoint other){
        double dist = 0.0;
        dist = Math.sqrt(Math.pow((other.getX()-this.x),2)+Math.pow((other.getY()-this.y),2));
        return dist;
    }
    public void move(){
        this.x = 0.0;
        this.y = 0.0;
    }
    public void move(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void moveTo(double x, double y){
        this.x += x;
        this.y += y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public double getX() {
        return x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getY() {
        return y;
    }



    public MyPoint(){
        this.move();
    }
    public MyPoint(double x, double y){
        this.move(x, y);
    }
    public String toString(){
        return "("+this.x+", "+this.y+")";
    }
    public void print(){
        System.out.print(this);
    }
    public void println(){
        this.print();
        System.out.println();
    }
}