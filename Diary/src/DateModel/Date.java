package DateModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.crypto.Data;

public class Date {
	private Calendar calendar;
	private SimpleDateFormat sdf;
	private java.util.Date date;
	private String wholeDate=null;

	public Date() {
			
		setDefaultDay();
	}
	
	public String getTime() {
		return wholeDate;
		
	}
	
	public void setDefaultDay() {	
		calendar=Calendar.getInstance();
		date= calendar.getTime();	
		sdf=new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		wholeDate=sdf.format(date)+", "+getDayString(date.getDay());
	}
	
	
	public void setDate(String year,String month,String dat,String hour,String minute,String second) {
		date=new java.util.Date();
		date.setDate(Integer.parseInt(dat));
		date.setMonth(Integer.parseInt(month));
		date.setYear(Integer.parseInt(year));
		date.setHours(Integer.parseInt(hour));
		date.setMinutes(Integer.parseInt(minute));
		date.setSeconds(Integer.parseInt(second));
		int d=date.getDay();
		this.wholeDate=year+":"+month+":"+dat+" "+hour+":"+minute+":"+second+", " +getDayString((d+3)%7);
	}
	
	public String toString() {
		return wholeDate;
		
	}

	public int getScond() {
		// TODO Auto-generated method stub
		int second=date.getSeconds();
		return second;
	}

	public int getMinute() {
		// TODO Auto-generated method stub
		int minute=date.getMinutes();
		return minute;
	}
	
	public int getHour() {
		int hour=date.getHours();
		return hour;
		
	}
	
	public String getDayString(int day) {
		String s=null;
		
		switch(day) {
		case(1):s="Mon";
		break;
		
		case(2):s="Tue";
		break;
		
		case(3):s="Wed";
		break;

		case(4):s="Thu";
		break;

		case(5):s="Fri";
		break;

		case(6):s="Sat";
		break;

		case(0):s="Sun";
		break;
		}
		
		return s;
	}
	
	public int getDay() {
		int  d=date.getDay();
		return d;
		
	}
	
	public int getMonth() {
		int  month=date.getMonth();
		return month;
		
	}
	
	public int getDate() {
		int dat=date.getDate();
		return dat;
	}
	
	public  static void  main(String[]args) {
		Date d=new Date();
		System.out.println(d.getTime());
		System.out.println(d.getDay());
		d.setDate("2019", "09", "01", "20", "1", "1");
		System.out.println(d.getTime());
		System.out.println(d.getDay());
		System.out.println(d.getMonth());
		System.out.println(d.getDate());
		d.setDefaultDay();
		System.out.println(d.getTime());
		
	}
	
}
