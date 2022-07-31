package com.revature.models;

import java.sql.Timestamp;

public class reimbursements {

	private int reimb_id;
	private int reimb_amount;
	private Timestamp reimb_submitted;
	private String reimb_description;
	private int reimb_status_fk;
	private int reimb_author_fk;
	private int reimb_resolver_fk;
	
	
	
	
	
	public reimbursements() {
		super();
		// TODO Auto-generated constructor stub
	}





	public reimbursements(int reimb_id, int reimb_amount, Timestamp reimb_submitted, String reimb_description,
			int reimb_status_fk, int reimb_author_fk, int reimb_resolver_fk) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_description = reimb_description;
		this.reimb_status_fk = reimb_status_fk;
		this.reimb_author_fk = reimb_author_fk;
		this.reimb_resolver_fk = reimb_resolver_fk;
	}





	@Override
	public String toString() {
		return "reimbursements [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_description=" + reimb_description + ", reimb_status_fk=" + reimb_status_fk
				+ ", reimb_author_fk=" + reimb_author_fk + ", reimb_resolver_fk=" + reimb_resolver_fk + "]";
	}





	public int getReimb_id() {
		return reimb_id;
	}





	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}





	public int getReimb_amount() {
		return reimb_amount;
	}





	public void setReimb_amount(int reimb_amount) {
		this.reimb_amount = reimb_amount;
	}





	public Timestamp getReimb_submitted() {
		return reimb_submitted;
	}





	public void setReimb_submitted(Timestamp reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}





	public String getReimb_description() {
		return reimb_description;
	}





	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}





	public int getReimb_status_fk() {
		return reimb_status_fk;
	}





	public void setReimb_status_fk(int reimb_status_fk) {
		this.reimb_status_fk = reimb_status_fk;
	}





	public int getReimb_author_fk() {
		return reimb_author_fk;
	}





	public void setReimb_author_fk(int reimb_author_fk) {
		this.reimb_author_fk = reimb_author_fk;
	}





	public int getReimb_resolver_fk() {
		return reimb_resolver_fk;
	}





	public void setReimb_resolver_fk(int reimb_resolver_fk) {
		this.reimb_resolver_fk = reimb_resolver_fk;
	}
	
	
	
	
}
