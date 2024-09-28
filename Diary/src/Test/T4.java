package Test;

public class T4 {
	int x=100;
	int y=101;
	String s1="cd";
	String s2="az";
	
	public void setValue(int value) {
		value=0;
		this.x=value;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T4 t4=new T4();
		System.out.println(t4.x);
		System.out.println(t4.y);
		
		t4.setValue(t4.x);
		t4.setValue(t4.y);
		
		System.out.println(t4.x);
		System.out.println(t4.y);

	}

}
