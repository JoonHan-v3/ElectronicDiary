package Test;

public class T2 {
	private int a=8;
	private T1 t1;
	
	public T2(int i) {
		t1=new T1();
		this.a=t1.getI()+5;
	}
	
	public T2(){
		
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
}
