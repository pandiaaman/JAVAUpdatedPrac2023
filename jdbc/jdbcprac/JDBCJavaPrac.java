package jdbcprac;
import java.sql.*;

public class JDBCJavaPrac {

	public static void main(String[] args) {
		/*
		 * start the sql workbench server and make sure that it is connected and tested
		 * 7steps
		 * 	import the java.sql.*
		 * 	load and register the driver (com.mysql.jdbc.Driver)
		 * 	create the connection con = DriverManager.getConnection(url,name,pass)
		 * 	write the query as a string
		 * 	create the statement : different queries have different statmenets, for DQL we can use createStatement
		 * 	load the resultset by using executeQuery
		 * 	process the resultset
		 * 	close the connection and statement
		 * 	
		 */
		String url = "jdbc:mysql://127.0.0.1:3306/practiceone"; //in mysql workbench
		String uname = "root";
		String upass = "password";
		
		Connection con;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,upass);
			
			String DQLquery = "select * from pracuserdetails;";
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(DQLquery);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("uname");
				int age = rs.getInt("uage");
				String dept = rs.getString("udept");
				
				System.out.print("id " + id + " name " + name  + " age " + age + " udept " + dept);
				System.out.println();
			}
			
			st.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
