package jdbcprac;
import java.sql.*;
public class JDBCInteraction {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://127.0.0.1:3306/practiceone";
		String uname = "myuser";//"root";
		String upass = "userpassword";//"password";
		
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,upass);
			
			//showTables(con);
			
			String tableName = "pracuserdetails";
			//describeTable(con, tableName);
			
			String username="akash";
			int userage = 20;
			String userdept = "Finance";
			insertRecord(con, tableName, username, userage,userdept);
			
			
			int recordID = 12;
			//deleteRecord(con, recordID, tableName);
	
			//callSpToInsert(con,username,userage,userdept);
			
			displayTable(con,tableName);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void showTables(Connection con) throws SQLException {
		String query = "show tables;";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("table :" + rs.getString("Tables_in_practiceone"));
		}
		
		pst.close();
	}
	
	public static void describeTable(Connection con, String tablename) throws SQLException {
		String query = "describe " + tablename;
		PreparedStatement pst = con.prepareStatement(query);
		pst = con.prepareStatement(query);
//		pst.setString(1, tablename);
		
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			System.out.println("field : " + rs.getString("Field") + " type : " + rs.getString("Type") + " is null : " + rs.getString("Null"));
		}
		pst.close();
	}
	
	public static void insertRecord(Connection con, String tablename, String name, int age, String dept) throws SQLException {
		String query = "INSERT INTO " + tablename + " (uname, uage, udept) VALUES(?,?,?);";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, name);
		pst.setInt(2, age);
		pst.setString(3,dept);
		
		int rowsAffected = pst.executeUpdate(); //execute update since this is insert statement : DML
		System.out.println(rowsAffected + " rows affected");
		
		pst.close();
	}
	
	public static void displayTable(Connection con, String tablename) throws SQLException {
		String query = "Select * from " + tablename + ";";
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		System.out.println("id \t uname \t uage \t udept");
		System.out.println("-------------------------------------");
		while(rs.next()) {
			System.out.print(rs.getInt("id") + "\t" + rs.getString("uname") + "\t" + rs.getInt("uage") + "\t" + rs.getString("udept"));
			System.out.println();
		}
		
		st.close();
	}
	
	public static void deleteRecord(Connection con, int id, String tablename) throws SQLException {
		String query = "delete from " + tablename + " where id=?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		
		int rowsAffected = pst.executeUpdate();
		System.out.println(rowsAffected + " rows Affected");
		
		pst.close();
	}
	
	public static void callSpToInsert(Connection con, String name, int age, String dept) throws SQLException {
		String query = "call insert_pracuserdetails(?,?,?)";
		PreparedStatement pst = con.prepareStatement(query); //here we can use callableStatement also to call the SP
		
		pst.setString(1, name);
		pst.setInt(2, age);
		pst.setString(3, dept);
		
		int rowsAffected = pst.executeUpdate();
		System.out.println(rowsAffected + " rows affected");
		
		pst.close();
	}

}
