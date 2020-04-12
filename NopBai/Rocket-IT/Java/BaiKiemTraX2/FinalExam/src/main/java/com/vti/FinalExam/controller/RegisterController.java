//
package com.vti.FinalExam.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.FinalExam.form.RegisterEmployeeInput;
import com.vti.FinalExam.form.RegisterManagerInput;
import com.vti.FinalExam.form.RegisterUserInput;
import com.vti.FinalExam.service.RegisterServiceUser;

/**
 * This class is . 
 * 
 * @Description: .
 * @author: TienBui
 * @create_date: Apr 12, 2020
 * @version: 1.0
 * @modifer: TienBui
 * @modifer_date: Apr 12, 2020
 */
public class RegisterController {
	
	private RegisterServiceUser regController;
	
	public RegisterController() {
		regController = new RegisterServiceUser();
	}
	
	public boolean RegisterUser(RegisterUserInput input) 
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		return regController.RegisterUser(input);
	}
	
	
	public boolean RegisterManager(RegisterManagerInput input) 
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException { 
		return regController.RegisterManager(input);
	}
	
	public boolean RegisterEmployee(RegisterEmployeeInput input) 
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		return regController.RegisterEmployee(input);
		
	}
	
}
