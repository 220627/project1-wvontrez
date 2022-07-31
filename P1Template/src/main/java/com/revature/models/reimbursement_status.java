package com.revature.models;

public class reimbursement_status {

	private int status_id;
	private String status;
	public reimbursement_status() {
		super();
		// TODO Auto-generated constructor stub
	}
	public reimbursement_status(int status_id, String status) {
		super();
		this.status_id = status_id;
		this.status = status;
	}
	@Override
	public String toString() {
		return "reimbursement_status [status_id=" + status_id + ", status=" + status + "]";
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
