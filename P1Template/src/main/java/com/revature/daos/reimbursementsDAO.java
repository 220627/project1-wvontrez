package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.editions;
import com.revature.models.reimbursements;
import com.revature.utils.ConnectionUtil;

public class reimbursementsDAO implements reimbursementsDAOInterface{

	@Override
	public editions getEditionById(int id) {
	
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from editions where edition_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id); //this means the first and only question mark
			
			//the data that is returned is a ResultSet - result set object holds our data
			ResultSet rs = ps.executeQuery(); //executes query into our new result set
			
			//need to iterate through the ResultSet to fill a editions all args constructor
			
			while(rs.next()) {
			editions edition = new editions (
					rs.getInt("edition_id"),
					rs.getString("edition_title"),
					rs.getInt("edition_price")
					);
			rs.next();
			return edition;
			}

			
					
		} catch (SQLException e) {
			System.out.println("Get Edition failed . . . bummer :("); //tell the console it failed
			e.printStackTrace(); //print an error log for debugs
		}
		
		return null;
	
	}//end of select by id method

	@Override
	public boolean updateEditionPrice(String title, int price) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//SQL String for our UPDATE command
			String sql = "update editions set edition_price = ? where edition_title = ?;";
			
			//create our PreparedStatement to fill in the variables
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, price);
			ps.setString(2, title);
			
			ps.executeUpdate();
			
			//tell the console the update was successfully 
			System.out.println(title + " has been updated to " + price);
			
			//if it succeeds, return true
			return true;
		
	} catch (SQLException e) {
		System.out.println("FAILED TO UPDATE");
		e.printStackTrace();
	}
		
		return false; 

}

	@Override
	public void insertReimb(reimbursements x) {
		//at the top of EVERY DAO METHOD, we need to open a database connection.
		try(Connection conn = ConnectionUtil.getConnection()){
			
		//First, we need out SQL String that represents the INSERT statement we want to send to the DB
		//There are variables here, and we can fill them out thanks to a PreparedStatement object
		//The question marks are how we indiciate that it's a value that we'll fill below
		String sql = "insert into reimbursements (reimbursement_name, author_name, edition_id_fk) values (?, ?, ?);";
			
		//Instantiate a PreparedStatement to fill in the variables of our SQL String (the ?s).
		//we use the prepareStatement() method from our Connection object to do this.
		PreparedStatement ps = conn.prepareStatement(sql);
			
		//fill in the values of our variables using ps.setXYZ()

		ps.setString(1, book.getBook_name()); //by "1" here, we're referring to the first question mark in the SQL String.
		ps.setString(2, book.getBook_author());
		ps.setInt(3, book.getEdition_id_fk()); 
							   
		
		System.out.println(ps);
		
		//we've created the SQL String and filled it with data - now we need to EXECUTE THE STATEMENT!
		ps.executeUpdate(); //This is what actually sends our SQL off to the database.
		
		//Tell the user the insert was successful
		System.out.println("Book " + book.getBook_name() + " was added!");
		
		return true; //if the update is successful, true will get returned
			
		} catch (SQLException e) { //if anything goes wrong, this SQLException will get thrown
			System.out.println("INSERT BOOK FAILED D:"); //tell the console we failed
			e.printStackTrace(); //print out the error log, which we'll need for debugging
		}


	}

	@Override
	public reimbursements selectReimb(int x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public reimbursements[] selectAllReimb() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateReimb(reimbursements x) {
		// TODO Auto-generated method stub
		
	}
	
}
