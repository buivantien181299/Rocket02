//
package com.vti.FinalExam.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.FinalExam.form.RegisterEmployeeInput;
import com.vti.FinalExam.form.RegisterManagerInput;
import com.vti.FinalExam.form.RegisterUserInput;
import com.vti.FinalExam.repository.IRegisterRepositoryUser;
import com.vti.FinalExam.repository.RegisterRepositorylmpl;

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
public class RegisterServiceUser implements IRegisterServiceUser{
	
	private IRegisterRepositoryUser repository;
	
	public RegisterServiceUser() {
		repository = new RegisterRepositorylmpl();
	}

	/* 
	* @see com.vti.FinalExam.service.IRegisterServiceUser#RegisterUser(com.vti.FinalExam.form.RegisterUserInput)
	*/
	public boolean RegisterUser(RegisterUserInput input)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		if (repository.registerUser(input) == 1) {
			return true;
		}
		return false;
		
	}

	/* 
	* @see com.vti.FinalExam.service.IRegisterServiceUser#RegisterManager(com.vti.FinalExam.form.RegisterManagerInput)
	*/
	public boolean RegisterManager(RegisterManagerInput input)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		if (repository.registerManager(input) == 1) {
			return true;
		}
		return false;
	}

	/* 
	* @see com.vti.FinalExam.service.IRegisterServiceUser#RegisterExperienceEmployee(com.vti.FinalExam.form.RegisterEmployeeInput)
	*/
	public boolean RegisterEmployee(RegisterEmployeeInput input)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		if (repository.registerEmployee(input) == 1) {
			return true;
		}
		return false;
	}

}
