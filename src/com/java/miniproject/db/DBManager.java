package com.java.miniproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.java.miniproject.pojo.Hobby;
import com.java.miniproject.pojo.User;

public class DBManager {

	private Connection connect;

	public DBManager() {


	}

//	public Connection getConnect() {
//		return connect;
//	}

//	public void setConnect(Connection connect) {
//		this.connect = connect;
//	}


	public void openConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//			String jdbc_url = "jdbc:mysql://localhost:3306/webjava";
			//			String user = "root";
			//			String password = "root";
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project_db", "root", "root");
			System.out.println("Connection Successfull...!!!");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}


	public void closeConnection()
	{
		try {
			connect.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public boolean validateUser(User newUser)
	{
		//connect db
		openConnection();
		//fire query
		try {
			String query = "SELECT * FROM USER_INFO_TBL WHERE USER_USERNAME='" + newUser.getUserName() + "' AND USER_PASSWORD='" + newUser.getPassword() + "'";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			//validate output   1. validate user 2. return whole user information
			if(rs.next())
			{
				newUser.setId(rs.getInt(1));
				newUser.setFirstName(rs.getString(2));
				newUser.setLastName(rs.getString(3));
				newUser.setEmail(rs.getString(4));
				newUser.setMobNo(rs.getString(5));
				return true;
			}

			else
				return false;

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			//close connection
			closeConnection();
		}

		//return value
		return false;
	}


	public boolean createUser(User newUser)
	{
		//connect db
		openConnection();
		//fire query
		try {
			String query1 = "INSERT INTO USER_INFO_TBL values(default,?,?,?,?,?,?)";
			PreparedStatement pstmt = connect.prepareStatement(query1);
			pstmt.setString(1, newUser.getFirstName());
			pstmt.setString(2, newUser.getLastName());
			pstmt.setString(3, newUser.getEmail());
			pstmt.setString(4, newUser.getMobNo());
			pstmt.setString(5, newUser.getUserName());
			pstmt.setString(6, newUser.getPassword());

			//validate output
			if(pstmt.executeUpdate() != 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			//close connection
			closeConnection();
		}

		//return value
		return false;
	}
	
	
	
	public void addHobby(Hobby Hobby)
	{
		//connect db
		openConnection();
		//fire query
		try {
			String query1 = "INSERT INTO HOBBY_TBL values(default,?,?)";
			PreparedStatement pstmt = connect.prepareStatement(query1);
			pstmt.setInt(1, Hobby.getUserId());
			pstmt.setString(2, Hobby.getHobby());
			pstmt.executeUpdate();
			
			
			//validate output
//			if(pstmt.executeUpdate() != 0)
//				return true;
//			else
//				return false;

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			//close connection
			closeConnection();
			System.out.println("connection Closed...!!!");
		}

		//return value
//		return false;
	}

	public List<Hobby> getAllHobby(User currentUser)
	{
		//connect db
		openConnection();
		//fire query
		List<Hobby> list = new ArrayList<Hobby>() ;
		try {
			String query1 = "SELECT * FROM HOBBY_TBL WHERE HOBBY_USERID ='"+currentUser.getId()+"'";
			PreparedStatement pstmt = connect.prepareStatement(query1);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next())
			{
				Hobby hobby = new Hobby();
				hobby.setId(rs.getInt(1));
				hobby.setUserId(rs.getInt(2));
				hobby.setHobby(rs.getString(3));
				list.add(hobby);
			}
			return list;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			//close connection
			closeConnection();
		}

		//return value
		return list;
	}

	//	public static void main(String[] args) {
	//		DBManager db = new DBManager();
	//
	//		boolean result = db.validateUser("anil", "anil@123");
	//		boolean result = db.createUser("pritam", "KAdam", "sas@123", "2222", "pritam123", "pritam123");
	//		System.out.println(result);
	//	}

}
