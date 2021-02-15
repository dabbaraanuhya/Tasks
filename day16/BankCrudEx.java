package day16task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankCrudEx {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/bankdb";
		String username="root";
		String password="root";
		Connection con;
		
		 con = DriverManager.getConnection(url, username, password);
		    System.out.println("Successfully connected");
		    
		    //insert employee record into database
		    Statement stmt = con.createStatement();
		    int rows = stmt.executeUpdate("insert into bank values(987654,'vani','karurvisya','kvb4566','saving','credit',5000000)");
		    System.out.println("Rows inserted = "+ rows);
		    
		    //update employee record
		    rows= stmt.executeUpdate("Update bank set amount=5000 where holdername='gowri'");
		    System.out.println("Rows updated = "+ rows);
		    
		    //read employee records
		    ResultSet rs = stmt.executeQuery("Select * from bank");
		
		    	
				 while(rs.next())
				 {
					 System.out.println(rs.getLong(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getDouble(7));
				 }
		    //delete employee record
		    rows = stmt.executeUpdate("delete from bank where holdername ='vani'");
		    System.out.println("Rows deleted = "+ rows);
		   
		    } catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  }
		  
	}


