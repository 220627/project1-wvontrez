package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.books;
import com.revature.models.editions;
import com.revature.models.employees;
import com.revature.utils.ConnectionUtil;

public class employeesDAO implements employeesDAOInterface{


	@Override
	public void insertEmployee(employees x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<employees> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public employees selectEmployee(String x) {
		// TODO Auto-generated method stub
		return null;
	}

	public employees getEmployeesById(int empFK) {
		// TODO Auto-generated method stub
		return null;
	}

}
