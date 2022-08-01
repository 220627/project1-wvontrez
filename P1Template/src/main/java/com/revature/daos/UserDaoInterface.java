package com.revature.daos;

import java.util.ArrayList;
import java.util.Map;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;

public interface UserDaoInterface {

	public ArrayList<Employee> getAll();

    public Map<Employee, Reimbursement> get();
    
}
