public class MyTickLine extends MyLine{
    private double tick;
    public MyTickLine(){
        this(0,0,0,0, 1);
    }
    public MyTickLine(double tick){
        this(0,0,0,0, tick);
    }
    public MyTickLine(double x1, double y1, double x2, double y2){
        this(x1, y1, x2, y2, 1);
    }
    public MyTickLine(double x1, double y1, double x2, double y2, double tick){
        super(x1, y1, x2, y2);
        this.
        tick = tick;
    }
    public MyTickLine(MyPoint start, MyPoint end){
        this(start, end, 1);
    }
    public MyTickLine(MyPoint start, MyPoint end, double tick){
        super(start, end);
        this.tick = tick;
    }
    public String toString(){
        return super.toString()+" Tick ["+this.tick+"]";
    }
    @Override
    public void draw() {
        System.out.print("TickLine Object ");
        this.println();
    }
}