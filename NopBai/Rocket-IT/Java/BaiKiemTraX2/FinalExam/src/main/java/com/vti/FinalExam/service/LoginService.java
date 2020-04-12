//
package com.vti.FinalExam.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.FinalExam.DTO.LoginDTO;
import com.vti.FinalExam.form.LoginForm;
import com.vti.FinalExam.repository.Loginrepository;
import com.vti.FinalExam.view.UserView;

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
public class LoginService implements ILoginService{
	
	private Loginrepository repository;
	
	public LoginService() {
		repository = new Loginrepository();
	}

	/* 
	* @see com.vti.FinalExam.service.ILoginService#login(com.vti.FinalExam.form.LoginForm)
	*/
	public LoginDTO login(LoginForm input)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		
		UserView viewUser = repository.login(input);
		
		if(viewUser == null) {
			return null;
		}
				
		return new LoginDTO(viewUser);
	}

}
