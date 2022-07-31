package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.reimbursements;

public interface reimbursementsDAOInterface {
		
	//my methods p much everything i need except the log ins
	ArrayList<reimbursements> getReimbursements();
	public reimbursements selectReimbursement(int x); //not all, just one by satus_id
	public void updateReimbursement (reimbursements x);
	boolean insertReimb(reimbursements x);

	
	
	}
		

