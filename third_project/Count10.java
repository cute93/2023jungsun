public class Count10 extends Thread{
    static int count = 2;
    public Count10(){
        super();
        count++;
    }
    public Count10(String name){
        super(name);
        count++;
    }
    public void run(){

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
