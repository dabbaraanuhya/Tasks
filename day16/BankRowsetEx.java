package day16task;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.*;
public class BankRowsetEx {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		JdbcRowSet rs=RowSetProvider.newFactory().createJdbcRowSet();
	String url="jdbc:mysql://localhost:3306/bankdb";
	 String password="root";
	 String username="root";
	 rs.setUrl(url);
	 rs.setUsername(username);
	 rs.setPassword(password);
	 ResultSet rr;
	 System.out.println("----full table----");
	 rs.setCommand("select *  from bank");
	 rs.execute();
	 while(rs.next())
	 {
		 System.out.println(rs.getLong(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getDouble(7));
	 }
	 System.out.println("-----update table----");
	  rs.absolute(3);
	     rs.updateString("amount", "400000");
	     rs.updateRow();
	     rs.setCommand("select *  from bank");
		 rs.execute();
		 while(rs.next())
		 {
			 System.out.println(rs.getLong(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getDouble(7));
		 }
	     System.out.println("3 Row amount  Updated");
	 System.out.println("----insert table-------");
	 rs.moveToInsertRow();
	 rs.updateLong("accountno",12388);
	 rs.updateString("holdername","sowmi");
	 rs.updateString("bankname","axis");
	 rs.updateString("ifsccode"," axis8000");
	 rs.updateString("accounttype","salary");
	 rs.updateString("transcation","debit");
	 rs.updateDouble("amount",79999);
	 rs.insertRow();
	 rs.setCommand("select *  from bank");
	 rs.execute();
	 while(rs.next())
	 {
		 System.out.println(rs.getLong(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getDouble(7));
	 }
	 System.out.println("inserted sucessfully");
	 System.out.println("----delete last row-------");
	 rs.last();
     rs.deleteRow(); 
     rs.setCommand("select *  from bank");
	 rs.execute();
	 while(rs.next())
	 {
		 System.out.println(rs.getLong(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getDouble(7));
	 }
     System.out.println("deleted sucessfully");
     System.out.println("----delete first row-------");
	 rs.first();
     rs.deleteRow(); 
     rs.setCommand("select *  from bank");
	 rs.execute();
	 while(rs.next())
	 {
		 System.out.println(rs.getLong(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getDouble(7));
	 }
     System.out.println("deleted sucessfully");
	 
	 rs.close();
	

	
}

}