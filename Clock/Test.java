public class Test extends Thread{
    private int sec;
    private int min;
    private int hour;

    public Test(){
        init();
    }

    private void init() {
        sec = 0;
        min = 0;
        hour = 0;
    }
    public static void main(String[] args) {
        long stime = System.currentTimeMillis();
        int m, s, ms;
        m = s = ms = 0;
        boolean flag = true;
        while(flag){
            long ctime = System.currentTimeMillis();
            if((ctime-stime) == 10){
                stime = ctime;
                ms = (++ms)%100;
                if(ms==0){
                    flag = false;
                }
                System.out.println(ms);

            }
        }
        
    }
}