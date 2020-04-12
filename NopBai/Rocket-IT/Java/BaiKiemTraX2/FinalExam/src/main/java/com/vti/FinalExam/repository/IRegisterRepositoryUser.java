//
package com.vti.FinalExam.repository;

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
public interface IRegisterRepositoryUser {
	
	/**
	 * This method is . 
	 * 
	 * @Description: .
	 * @author: TienBui
	 * @create_date: Apr 12, 2020
	 * @version: 1.0
	 * @modifer: TienBui
	 * @modifer_date: Apr 12, 2020
	 * @param input
	 * @return
	 */
	public int registerUser (RegisterUserInput input)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	
	/**
	 * This method is . 
	 * 
	 * @Description: .
	 * @author: TienBui
	 * @create_date: Apr 12, 2020
	 * @version: 1.0
	 * @modifer: TienBui
	 * @modifer_date: Apr 12, 2020
	 * @param input
	 * @return
	 */
	public int registerManager (RegisterManagerInput input)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	
	
	public int registerEmployee (RegisterEmployeeInput input)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	
	
}
