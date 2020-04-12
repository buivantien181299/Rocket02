//
package com.vti.FinalExam.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.FinalExam.DTO.LoginDTO;
import com.vti.FinalExam.form.LoginForm;
import com.vti.FinalExam.service.LoginService;

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
public class LoginController {
	private LoginService service;

	public LoginController() {
		;
		service = new LoginService();
	}

	public LoginDTO Login(LoginForm input)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		if (input != null) {
			return service.login(input);
		}
		return null;

	}
}
