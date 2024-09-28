package DateModel;

import java.sql.ResultSet;
import java.sql.SQLException;

import MainFrame.SQLCommand;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SQLCommand svc=new SQLCommand();
		svc.addDiary(3, "hello","111");
		svc.addDiary(4, "go","222");
		svc.addDiary(5, "I love you.","333");
		svc.addDiary(6, "I will be  the top","444");
		ResultSet rs1=svc.searchResult(3);
		svc.update(3, "googog");
		
		ResultSet rs=svc.selectAll();
		try {
			if(rs1.next()==true) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(svc.deleteRow(3)>0) {
//			System.out.println("K");
//		}
		
		
	}
	
	

}
