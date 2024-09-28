package MainFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLCommand {
	private Connection conn;
	private PreparedStatement ps;
	
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet selectAll() {
		connect();
		ResultSet rs=null;
		String sql="SELECT * FROM diary";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public int addDiary(int id, String content,String date) {
		connect();
		int result=0;
		String sql="INSERT INTO diary VALUES (?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, content);
			ps.setString(3, date);
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
	
	
	public ResultSet searchResult(int id) {
		connect();
		ResultSet result=null;
		String sql="SELECT * FROM diary WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			result=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteRow(int id) {
		connect();
		int result=0;
		String sql="DELETE diary WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
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
	
	public int update(int id,String content) {
		connect();
		int result=0;
		String sql="UPDATE diary SET content=? WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, id);
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
	
	public static void main(String[]args) {
		SQLCommand s=new SQLCommand();
		s.connect();
	}
}

