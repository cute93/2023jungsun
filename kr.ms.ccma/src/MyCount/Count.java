package MyCount;

public class Count extends Thread{
	public Count() {
		super();
	}
	public Count(String name) {
		super(name);
	}
	public void run() {
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
}
