package PasswordFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLCommand {
	private Connection conn;
	private PreparedStatement ps;
	private String password;
	
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void insert() {
		String sql="INSERT INTO password VALUES (?,?)";
		connect();
		try {
			String id="password";
			String password="00000";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int update(String s) {
		String sql="UPDATE password SET password=? WHERE id='password'";
		int result=0;
		connect();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, s);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	public String getPassword() {
		
		String sql="SELECT * FROM password WHERE id='password'";
		ResultSet rs;
		connect();
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
			password=rs.getString("password");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return password;
	}
	
	public static void main(String[]args) {
		SQLCommand c=new SQLCommand();
		c.connect();
		if(c.update("00000")>0) {
			System.out.println("ok");
		};
		
		System.out.println(c.getPassword());
		
	}

}
