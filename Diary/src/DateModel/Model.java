package DateModel;

import java.util.StringTokenizer;

public class Model {
	private Date date;
	private String content;
	private int id;
	
	public Model(Date date,String content) {
		this.date=date;
		this.content=content;
	}
	
	public void setContent(String content) {
		this.content=content;
		
	}
	
	public String getContent() {
		return content;
	}
	
	public  int getId() {
		String s1=date.getTime();
		StringTokenizer st1=new StringTokenizer(s1);
		
		String s2=st1.nextToken();
		StringTokenizer st2=new StringTokenizer(s2,":");
		
		String s3=st2.nextToken()+st2.nextToken()+st2.nextToken();
		id=Integer.parseInt(s3);
		
		return id;
	
	}
	
	public String getDate() {
		return date.getTime();
		
	}
	
	public static void main(String[]args) {
		Date date1=new Date();
		String s=":";
		Model m=new Model(date1,s);
		
		System.out.println(m.getId());
		System.out.println(date1);
	}
   
}
