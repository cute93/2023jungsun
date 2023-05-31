public class MyColorPoint extends MyPoint{
    private String color;
    public String toString(){
        return super.toString() + "["+this.color+"]";
    }
    public void print(){
        System.out.print(this);
    }
    public void println(){
        this.print();
        System.out.println();
    }
    public MyColorPoint(){
        this("black");
    }
    public MyColorPoint(String color){
        super();
        this.color = color;
    }
    public MyColorPoint(double x, double y){
        this(x, y, "black");
    }
    public MyColorPoint(double x, double y, String color) {
        super(x, y);
        this.color = color;
    }
}