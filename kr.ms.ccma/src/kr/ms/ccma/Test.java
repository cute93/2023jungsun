package kr.ms.ccma;

class Test {
	public static  int num;
	private int age;
	private final int MAX = 120;
	Test(){
		this(0);
	}
	Test(int age){
		setAge(age);
		num++;
	}
	public void setAge(int age) {
		if(age<0) age = 0;
		if(age>MAX) age=MAX;
		this.age = age;
	}
	public String toString() {
		return "["+age+"]";
	}
	public void print() {
		System.out.print(this);
	}
	void println() {
		print();
		System.out.println();
	}
}
