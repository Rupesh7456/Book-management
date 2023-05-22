package com.takeo.dao.impl;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.takeo.configure.JdbcUtility1;
import com.takeo.dao.BookDAO;
import com.takeo.model.Book;
import com.takeo.query.QueryConstants;

public class BookDAOImpl implements BookDAO {

	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public String register(Book book) {
		// TODO Auto-generated method stubString 
		String msg="";
		try {
		con=JdbcUtility1.getConnection();
		ps=con.prepareStatement(QueryConstants.USER_INSERT_QUERY);
			
			ps.setString(1, book.getBname());
			ps.setString(2, book.getBtype());
			ps.setInt(3, book.getBprice());
			ps.setString(4, book.getUsername());
			ps.setString(5, book.getPassword());
			
			int count=ps.executeUpdate();
			
			
			
		
			
			if (count!=0)
				msg="Book registration is done";
			else
				msg="Book registration is not done try later"; 
				
			
				
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		finally {
			try {
				JdbcUtility1.closeConnection(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return msg;
		}
		
		
			
		
	

	public List<Book> viewRegisters() {
		// TODO Auto-generated method stub
		List<Book>addBooks=new ArrayList<>();
		try {
			con=JdbcUtility1.getConnection();
			
			ps=con.prepareStatement(QueryConstants.USER_SELECT_QUERY);
			
		rs=ps.executeQuery();
			
			while(rs.next()) {
				int bid=rs.getInt(1);
				String bname=rs.getString(2);
				String btype=rs.getString(3);
				String bprice=rs.getString(4);
				String uname=rs.getString(5);
				String pass=rs.getString(6);
				Book book=new Book(bprice,bname,bid,uname,pass);
				
				addBooks.add(book);
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace()	;				
		}
		finally {
			
				try {
					JdbcUtility1.closeConnection(con, ps, rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
		
		return addBooks;
	}

	public boolean verifyUsernameAndPassword(String username, String pass) {
		// TODO Auto-generated method stub
		boolean flag=true;
		try {
			
			con=JdbcUtility1.getConnection();
			ps=con.prepareStatement(QueryConstants.USER_VALID_QUERY);
			
			
			ps.setString(1, username);
			
			
			ps.setString(2, pass);
			
			rs=ps.executeQuery();
			
			if (rs.next()) 	
			
			flag=true;
			else
				flag=false;
			
				
			
			
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				JdbcUtility1.closeConnection(con, ps,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return flag;
	}

	
	

	
}

