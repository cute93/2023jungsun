public class Test extends Thread{
    public static int Rank = 5;
    public Test(){
        this("NewThread");
    }
    public Test(String name) {
        setName(name);
    }
    public void run(){
        for(int i=0; i<10;i++){
            System.out.println(""+getName()+":"+(i+1));
            try {
                Thread.sleep((int)(Math.random()*800));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(getName() + (Rank-Thread.activeCount()) + "등");
        
    }
    public static void main(String[] args) {
        new Test().start();
        new Test("Field").start();
        new Test("GOT").start();
    }
}