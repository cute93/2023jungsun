package MyCount;

public class MyRunnable implements Runnable{
	String name;
	private static int n = 0;
	private static int TNUM = Thread.activeCount();
	public MyRunnable() {
		n++;
		this.name = "Runner"+n;
	}
	public MyRunnable(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1; i<=10; i++) {
			System.out.println(String.format(getName()+": %3d", i));
			try {
				Thread.sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(getName()+" Finished " + (5-Thread.activeCount())+" Rank!!!");
	}
	
	public String toString() {
		return this.name;
	}
	public String getName() {
		return name;
	}
}
