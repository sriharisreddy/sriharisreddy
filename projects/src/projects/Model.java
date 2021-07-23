package projects;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import oracle.jdbc.driver.OracleDriver;

public class Model
{
	private String custid;
    private String password;
    private int balance;
    private String acc_no;
    private String npwd;
    private String cpwd;
    
    private int tamt;
    private  String tacc_no;
    
    public int getTamt() {
		return tamt;
	}
	public void setTamt(int tamt) {
		this.tamt = tamt;
	}
	public String getTacc_no() {
		return tacc_no;
	}
	public void setTacc_no(String tacc_no) {
		this.tacc_no = tacc_no;
	}
	public String getNpwd() {
		return npwd;
	}
	public void setNpwd(String npwd) {
		this.npwd = npwd;
	}
	public String getCpwd() {
		return cpwd;
	}
	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
    Connection con;
    ResultSet res;
    PreparedStatement pstmt;
    
    
    
	Model()
	{   
		try
		{
		DriverManager.registerDriver(new OracleDriver());
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("driver is loaded");
	    con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","system");
		System.out.println("connection established");
		}
		
		catch(Exception e)
		{
			System.out.println("some prob");
		}
	}

		
		
		public boolean Login() throws ServletException, IOException
		{
			try
			{
				pstmt=con.prepareStatement("select * from BANKAPPS where custid=? and password=? ");
				pstmt.setString(1,custid);
				pstmt.setString(2,password);
				res=pstmt.executeQuery();
				while(res.next())
				{
					 acc_no=res.getString(2);
				
					
					System.out.println(acc_no);
					return true;
				} 
			}
			
			
			catch(Exception e)
			{
			  e.printStackTrace();
			}
			return false;
		}
		
		public boolean checkBalance()
		{
			try
			{
				pstmt=con.prepareStatement("select * from BANKAPPS where acc_no=?");
				pstmt.setString(1, acc_no);
				res=pstmt.executeQuery();
				System.out.println("after the resultset");
				while(res.next()) 
				{
				 balance=res.getInt(3);
				 System.out.println("inside while");
				 return true;
				}
	
			}
			catch(Exception e)
			{
				 e.printStackTrace();
			}
			return false;
			
		}
		
		
		public boolean changepassword()
		{
			try {
				pstmt=con.prepareStatement("update BANKAPPS set password=? where acc_no=?");
				pstmt.setString(1, npwd);
				pstmt.setString(2, acc_no);
			    res = pstmt.executeQuery();
				if(res.next())
				{
					return true;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return false;
		}
		
		
		public boolean AmtTransfer()
		{
			try
			{
			pstmt=con.prepareStatement("update bankapps set balance=balance-? where acc_no=?");
			pstmt.setInt(1, tamt);
			pstmt.setString(2, acc_no);
			int rows=pstmt.executeUpdate();
			if(rows==0)
			{
				return false;
			}
			else
			{
				pstmt=con.prepareStatement("update bankapps set balance=balance+? where acc_no=?");
				pstmt.setInt(1, tamt);
				pstmt.setString(2, tacc_no);
				int row=pstmt.executeUpdate();
				pstmt=con.prepareStatement("insert into statement values(?,?,?)");
				pstmt.setString(1, acc_no);
				pstmt.setString(2, tacc_no);
				pstmt.setInt(3,tamt);
				pstmt.executeUpdate();
				return true;
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return false;
		}	
		
		
		public ArrayList getstatement()
		{
			ArrayList al=new ArrayList();
			try {
			pstmt=con.prepareStatement("select * from statement where acc_no=?");
			pstmt.setString(1, acc_no);
			res=pstmt.executeQuery();
			while(res.next())
			{
			
			al.add(res.getString(1));
		
			}
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return al;
		}
		
}