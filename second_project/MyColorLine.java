public class MyColorLine extends MyLine{
    private String color;
    public MyColorLine(){
        this(0,0,0,0, "Black");
    }
    public MyColorLine(String color){
        this(0,0,0,0, color);
    }
    public MyColorLine(double x1, double y1, double x2, double y2){
        this(x1, y1, x2, y2, "Black");
    }
    public MyColorLine(double x1, double y1, double x2, double y2, String color){
        super(x1, y1, x2, y2);
        this.color = color;
    }
    public MyColorLine(MyPoint start, MyPoint end){
        this(start, end, "Black");
    }
    public MyColorLine(MyPoint start, MyPoint end, String color){
        super(start, end);
        this.color = color;
    }
    public String toString(){
        return super.toString()+" Color["+this.color+"]";
    }
    public void print(){
        System.out.print(this);
    }
    public void println(){
        this.print();
        System.out.println();
    }
    public void draw() {
        System.out.print("ColorLine Object ");
        this.println();
    }
}