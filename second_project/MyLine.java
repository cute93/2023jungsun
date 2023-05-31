public abstract class MyLine {
    private MyPoint start;
    private MyPoint end;
    
    public double length(){
        return start.distance(end);
    }
    
    public MyLine(){
        this(0,0,0,0);
    }
    public MyLine(double x1, double y1, double x2, double y2){
        this.start = new MyPoint(x1, y1);
        this.end = new MyPoint(x2, y2);
    }
    public MyLine(MyPoint start, MyPoint end){
        this.start = start;
        this.end = end;
    }
    public String toString(){
        return this.start.toString() + "=>" + this.end.toString();
    }
    public void print(){
        System.out.print(this);
    }
    public void println(){
        this.print();
        System.out.println();
    }
    public abstract void draw();
}
