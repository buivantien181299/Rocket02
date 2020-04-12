//
package com.vti.FinalExam.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.FinalExam.form.RegisterEmployeeInput;
import com.vti.FinalExam.form.RegisterManagerInput;
import com.vti.FinalExam.form.RegisterUserInput;

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
public interface IRegisterServiceUser {
	public boolean RegisterUser(RegisterUserInput input)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	
	public boolean RegisterManager(RegisterManagerInput input)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;

	public boolean RegisterEmployee(RegisterEmployeeInput input)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
}
