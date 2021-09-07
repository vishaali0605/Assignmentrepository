package com.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookApplicationDAO implements BookDAO {

	@Override
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driverclass);
			con = DriverManager.getConnection(jdbcurl, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public void insertBooks(Book b) {
		String query="insert into bookapplication values(?,?,?,?,?)";
		try (Connection con=getConnection()){
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,b.getBid());
			ps.setString(2,b.getName());
			ps.setString(3,b.getBauthor());
			ps.setString(4,b.getBgenre());
			ps.setInt(5,b.getBcost());
			ps.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}

	@Override
	public Book selectBook(int id) {
		Book bok=null;
		String query="select*from bookapplication where bookid=?";
		try (Connection con=getConnection()){
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				bok=new Book();
				bok.setBid(id);
				bok.setName(rs.getString(2));
				bok.setBauthor(rs.getString(3));
				bok.setBgenre(rs.getString(4));
				bok.setBcost(rs.getInt(5));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return bok;
	}

	@Override
	public List<Book> SelectAllBook() {
		List<Book>list=new ArrayList();
		String query="Select*from bookapplication";
		try (Connection con=getConnection()){
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Book book=new Book();
				book.setBid(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setBauthor(rs.getString(3));
				book.setBgenre(rs.getString(4));
				book.setBcost(rs.getInt(5));
				list.add(book);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deleteBook(int id) {
		boolean result=false;
		String query="delete from bookapplication where bookid=?";
		try (Connection con=getConnection()){
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			result=ps.executeUpdate()>0;
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean updateBook(Book b) {
		boolean result=false;
		String query="update  bookapplication set bookname=?,bookauthor=?,bookgenre=?,bookcost=? where bookid=? ";
		try (Connection con=getConnection()){
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,b.getName());
			ps.setString(2,b.getBauthor());
			ps.setString(3,b.getBgenre());
			ps.setInt(4,b.getBcost());
			ps.setInt(5,b.getBid());
			result=ps.executeUpdate()>0;
			
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return result;
	}

}
