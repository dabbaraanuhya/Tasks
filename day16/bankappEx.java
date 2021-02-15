package day16task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class bankappEx {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Bank b=new Bank();
		Scanner s=new Scanner(System.in);
		char c;
		do
		{
			System.out.println("enter accountnumber");
			long accno=s.nextLong();
			System.out.println("enter holdername");
			String holdname=s.next();
			System.out.println("enter bankname");
			String bankname=s.next();
			System.out.println("enter ifsc code");
			String ifsccode=s.next();
			System.out.println("enter accounttype");
			String acctype=s.next();
			System.out.println("enter transaction type");
			String transac=s.next();
			System.out.println("enter amount");
			double amount=s.nextDouble();
			
			b.setAccountno(accno);
			b.setHoldername(holdname);
			b.setBankname(bankname);
			b.setIfsccode(ifsccode);
			b.setAccounttype(acctype);
			b.setTransaction(transac);
			b.setAmount(amount);
             Connection con=null;
			PreparedStatement pstmt=null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try
			{
						Class.forName("com.mysql.cj.jdbc.Driver");
						String url="jdbc:mysql://localhost:3306/bankdb";
						String username="root";
						String password="root";
						con=DriverManager.getConnection(url,username,password);
						stmt = con.createStatement();
						String sql="insert into bank values(?,?,?,?,?,?,?)";
						pstmt=con.prepareStatement(sql);
						pstmt.setLong(1, b.getAccountno());
						pstmt.setString(2, b.getHoldername());
						pstmt.setString(3, b.getBankname());
						pstmt.setString(4, b.getIfsccode());
						pstmt.setString(5, b.getAccounttype());
						pstmt.setString(6, b.getTransaction());
						pstmt.setDouble(7, b.getAmount());
						
						
						pstmt.execute();
						System.out.println("-------insert success---------------");
						
						stmt=con.createStatement();
						
						 int rows = stmt.executeUpdate("insert into bank values(987654,'vani','karurvisya','kvb4566','saving','credit',5000000)");
						    System.out.println("Rows inserted = "+ rows);
						    String sql1="select * from bank";
							rs=stmt.executeQuery(sql1);
							 while(rs.next())
							 {
								 System.out.println(rs.getLong(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getDouble(7));
							 }
						    
							 rows = stmt.executeUpdate("delete from bank where holdername ='vani'");
							    System.out.println("Rows deleted = "+ rows);
							    System.out.println("-----deleted  successfully-----");
						
							    String sql2="select * from bank";
								rs=stmt.executeQuery(sql2);
								 while(rs.next())
								 {
									 System.out.println(rs.getLong(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getDouble(7));
								 }
								 
								 rows= stmt.executeUpdate("Update bank set amount=0 where holdername='gowri'");
								    System.out.println("Rows updated = "+ rows);
								    System.out.println("-----deleted  successfully-----");
								    String sql3="select * from bank";
									rs=stmt.executeQuery(sql3);
									 while(rs.next())
									 {
										 System.out.println(rs.getLong(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getDouble(7));
									 }
			} 
			
			catch (ClassNotFoundException e)
			{
						// TODO Auto-generated catch block
						e.printStackTrace();
			}
			finally
			{
				pstmt.close();
				con.close();
				rs.close();
			}
			System.out.println("do you want to continue y/n");
			c=s.next().charAt(0);
		}while(c!='n');
	}

}
