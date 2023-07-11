package RSP;

public class RSPExeption extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7500181960655711046L;
	public RSPExeption() {
		super();
	}
	public void printStackTrace() {
		super.printStackTrace();
		System.out.println("Exception.. 0,1,2");	
	}
}
