//
package com.vti.FinalExam.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.FinalExam.DTO.LoginDTO;
import com.vti.FinalExam.form.LoginForm;

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
public interface ILoginService {
	public LoginDTO login(LoginForm input)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
}
