public class Runnable10 implements Runnable{
    private String name;
    private static int count = 2;
    public Runnable10(String name){
        this.name = name;
        count++;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println(getName() + " : " +(i+1));
            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(count-(Thread.activeCount())+"등 "+getName()+" is Terminated!!");
    }
    
}
