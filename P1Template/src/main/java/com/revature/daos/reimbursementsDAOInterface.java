package com.revature.daos;



public interface reimbursementsDAOInterface {
		//a method that returns a Role object from the database given the Role's ID
		editions getEditionById(int id);
		
		//a method that updates the salary data for a given role
		boolean updateEditionPrice(String title, int price);
	}
		//ctrl + shift + o to import unimported Classes 

