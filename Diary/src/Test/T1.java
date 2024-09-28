package Test;

public class T1 {
	private int i=1;
	private T2 t2;
	
	public  T1(int  i) {
		t2=new  T2();
		this.i=t2.getA()+10;
	}
	
	public T1() {
		
	}
	public int getI() {
		return i;
	}
	
	

}
